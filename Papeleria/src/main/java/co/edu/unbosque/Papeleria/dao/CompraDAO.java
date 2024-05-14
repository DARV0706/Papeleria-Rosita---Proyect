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
		String sql = "SELECT * FROM compra where status=1";
		List<CompraDTO> lista = jdbctemple1.query(sql, BeanPropertyRowMapper.newInstance(CompraDTO.class));
		return lista;
	}

	@Override
	public int deleteBuy(int id) {
		
		String sql = "UPDATE compra SET status = 0 WHERE id_compra = ?";
		int aux2 =  jdbctemple1.update(sql, id);
		return 1;

	}


	@Override
	public CompraDTO searchBuy(int id) {
		// TODO Auto-generated method stub
	    String sql = "SELECT * FROM compra WHERE id_compra = ? AND status = 1";
	    CompraDTO compra = jdbctemple1.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(CompraDTO.class));
	    return compra;
	}

	@Override
	public int insertBuy(CompraDTO compraDTO) {
		
		compraDTO.setStatus(1);
		compraDTO.setId_compra(calcularNumeroMaximo());
		
	    String sql = "INSERT INTO compra (id_compra, fecha_compra, fecha_llegada, tota_compra, Proveedor_id_proveedor, status)"
	                + "VALUES (?, ?, ?, ?, ?, ?)";
	    int aux = jdbctemple1.update(sql, compraDTO.getId_compra(), compraDTO.getFecha_compra(), compraDTO.getFecha_llegada(),
	                                         compraDTO.getTota_compra(), compraDTO.getProveedor_id_proveedor(), compraDTO.getStatus());
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
		compraDTO.setStatus(1);
	    String sql = "UPDATE compra SET fecha_compra = ?, fecha_llegada = ?, tota_compra = ?, Proveedor_id_proveedor = ?, status = ? "
	            + "WHERE id_compra = ?";
	    return jdbctemple1.update(sql, compraDTO.getFecha_compra(), compraDTO.getFecha_llegada(), compraDTO.getTota_compra(),
	            compraDTO.getProveedor_id_proveedor(), compraDTO.getStatus(), compraDTO.getId_compra());
	}


	
	private int calcularNumeroMaximo() {
        String sql = "SELECT MAX(id_compra) FROM compra";
        int r = jdbctemple1.queryForObject(sql, Integer.class) + 1;
        return r ;
    }



}
