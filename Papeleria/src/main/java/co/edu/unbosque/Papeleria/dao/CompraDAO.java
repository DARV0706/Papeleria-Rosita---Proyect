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
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Papeleria.dto.CompraDTO;

import co.edu.unbosque.Papeleria.interfacesService.CompraCRUD;


@Repository
public class CompraDAO implements CompraCRUD<CompraDTO>{
	
	@Autowired 
	private JdbcTemplate jdbctemple1;

	@Override
	public List<CompraDTO> listBuy() {
		String sql = "SELECT * FROM compra";
		List<CompraDTO> lista = jdbctemple1.query(sql, BeanPropertyRowMapper.newInstance(CompraDTO.class));
		return lista;
	}

	@Override
	public int deleteBuy(int id) {
		String aux = "SELECT COUNT(*) FROM compra WHERE id = ? AND status = 1";
		int contador = jdbctemple1.queryForObject(aux, Integer.class, id);
		int aux2;
		
		if(contador > 0) {
			String sql = "UPDATE compra SET status = 0 WHERE id = ?";
			aux2 =  jdbctemple1.update(sql, id);
				if(aux2 > 0) {
					return 1;
				}else {
					return -1;
				}
		}else {
			return 0;
		}
	}


	@Override
	public CompraDTO searchBuy(int id) {
		// TODO Auto-generated method stub
	    String sql = "SELECT * FROM compra WHERE id = ? AND status = 1";
	    CompraDTO compra = jdbctemple1.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(CompraDTO.class));
	    return compra;
	}

	@Override
	public int insertBuy(CompraDTO compraDTO) {
		
		compraDTO.setStatus(1);
		compraDTO.setId_compra(calcularNumeroMaximo());
		
	    String sql = "INSERT INTO compra (id_compra, fecha_compra, fecha_llegada, total_compra, Proveedor_id_proveedor, status)"
	                + "VALUES (?, ?, ?, ?, ?, ?)";
	    int aux = jdbctemple1.update(sql, compraDTO.getId_compra(), compraDTO.getFecha_compra(), compraDTO.getFecha_llegada(),
	                                         compraDTO.getTotal_compra(), compraDTO.getProveedor_id_proveedor(), compraDTO.getStatus());
	    return aux;
	}

	
//	public int insertBuy(CompraDTO compraDTO) {
//		// TODO Auto-generated method stub
//		String sql = "INSERT INTO compra (id_compra, fecha_compra, fecha_llegada,tota_compra,Proveedor_id_proveedor, status)"
//				+ "VALUES(?,?,?,?,?,?,)";
//		jdbctemple1.queryForObject(sql, new Object[] {
//				compraDTO.getId_compra(),compraDTO.getFecha_compra(), compraDTO.getFecha_llegada(), compraDTO.getTotal_compra(),
//				compraDTO.getProveedor_id_proveedor(), compraDTO.getStatus(),   Integer.class
//		});
//		return 1;
//	}

	@Override
	public int editBuy(CompraDTO compraDTO) {
		String sql = "UPDATE compra SET id_compra = ?, fecha_compra = ?, fecha_llegada = ?, tota_compra = ?, Proveedor_id_proveedor = ?, status = ? "
				+ "WHERE id_compra = ? ";
		return jdbctemple1.execute(sql, (PreparedStatementCallback<Integer>) preparedStatement -> {
			preparedStatement.setLong(1, compraDTO.getId_compra());
			preparedStatement.setString(2, compraDTO.getFecha_compra());
			preparedStatement.setString(3, compraDTO.getFecha_llegada());
			preparedStatement.setLong(4, compraDTO.getTotal_compra());
			preparedStatement.setLong(5, compraDTO.getProveedor_id_proveedor());
			preparedStatement.setLong(6, compraDTO.getStatus());

			return preparedStatement.execute() ? 1 : 0;
		});
	}


	
	private int calcularNumeroMaximo() {
        String sql = "SELECT MAX(id_compra) FROM compra";
        int r = jdbctemple1.queryForObject(sql, Integer.class) + 1;
        return r ;
    }



}
