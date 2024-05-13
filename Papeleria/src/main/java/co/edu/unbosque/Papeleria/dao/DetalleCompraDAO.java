package co.edu.unbosque.Papeleria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Papeleria.dto.CompraDTO;
import co.edu.unbosque.Papeleria.dto.DetalleCompraDTO;
import co.edu.unbosque.Papeleria.interfacesService.DetalleCompraCRUD;

@Service
public class DetalleCompraDAO implements DetalleCompraCRUD<DetalleCompraDTO>{
	
	@Autowired 
	private JdbcTemplate jdbctemple1;

	@Override
	public List<DetalleCompraDTO> listBuyRep() {
		String sql = "SELECT * FROM detalle_compra";
		List<DetalleCompraDTO> lista = jdbctemple1.query(sql, BeanPropertyRowMapper.newInstance(DetalleCompraDTO.class));
		return lista;
	}


	@Override
	public int deleteBuyRep(int id, int id2, String id3) {
	    String aux = "SELECT COUNT(*) FROM detalle_compra WHERE id_det_compra = ? AND Compra_id_compra = ? AND Producto_id_producto = ? "
	            + "AND status = 1";
	    int contador = jdbctemple1.queryForObject(aux, new Object[]{id, id2, id3}, Integer.class);

	    if (contador > 0) {
	        String sql = "UPDATE detalle_compra SET status = 0 WHERE id_det_compra = ? "
	                + "AND Compra_id_compra = ? AND Producto_id_producto = ?";
	        int aux2 = jdbctemple1.update(sql, id, id2, id3);

	        if (aux2 > 0) {
	            return 1;
	        } else {
	            return -1;
	        }
	    } else {
	        return 0;
	    }
	}

	@Override
	public int insertBuyRep(DetalleCompraDTO BuyRep) {
		BuyRep.setStatus(1);
		BuyRep.setId_det_compra(calcularNumeroMaximo());
		
		String sql = "INSERT INTO detalle_compra (id_det_compra, precio, cantidad,monto_total,Compra_id_proveedor, Producto_id_producto)"
				+ "VALUES(?,?,?,?,?,?)";
		
	    int aux = jdbctemple1.update(sql, BuyRep.getId_det_compra(), BuyRep.getPrecio(), BuyRep.getCantidad(),
	    		BuyRep.getMonto_total(), BuyRep.getCompra_id_compra(), BuyRep.getProducto_id_producto());;
	    return aux;
	}

	@Override
	public int editBuyRep(DetalleCompraDTO BuyRep) {
		String sql = "UPDATE detalle_compra id_det_compra=?, precio=?, cantidad=?,monto_total=?,Compra_id_compra=?, Producto_id_producto=? "
				+ "WHERE id_det_compra = ? AND Compra_id_compra = ? AND Producto_id_producto = ? ";
		return jdbctemple1.execute(sql, (PreparedStatementCallback<Integer>) preparedStatement -> {
			preparedStatement.setLong(1, BuyRep.getId_det_compra());
			preparedStatement.setLong(2, BuyRep.getPrecio());
			preparedStatement.setLong(3, BuyRep.getCantidad());
			preparedStatement.setLong(4, BuyRep.getMonto_total());
			preparedStatement.setLong(5, BuyRep.getCompra_id_compra());
			preparedStatement.setString(6, BuyRep.getProducto_id_producto());

			return preparedStatement.execute() ? 1 : 0;
		});
	}
	
	private int calcularNumeroMaximo() {
        String sql = "SELECT MAX(id_det_com) FROM detalle_compra";
        int r = jdbctemple1.queryForObject(sql, Integer.class) + 1;
        return r ;
    }


	@Override
	public DetalleCompraDTO searchBuyRep(int id, int id2, String id3) {
	    String sql = "SELECT * FROM compra WHERE id_det_compra = ? AND Compra_id_compra = ? AND Producto_id_producto = ? AND status = 1";
	    DetalleCompraDTO compra = jdbctemple1.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(DetalleCompraDTO.class));
	    return compra;
	}

	
	

}
