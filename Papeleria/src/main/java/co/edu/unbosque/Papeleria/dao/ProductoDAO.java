package co.edu.unbosque.Papeleria.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import co.edu.unbosque.Papeleria.dto.ProductoDTO;
import co.edu.unbosque.Papeleria.interfacesService.ProductoCRUD;


@Repository
public class ProductoDAO implements ProductoCRUD{

	
	@Autowired
	private JdbcTemplate jdbctemple1;
	
	@Override
	public List<ProductoDTO> listProduct() {
		String sql = "SELECT * FROM producto";
	    List<ProductoDTO> lista = jdbctemple1.query(sql, BeanPropertyRowMapper.newInstance(ProductoDTO.class));
	    return lista;
	}

	@Override
	public ProductoDTO searchProduct(String id) {
		String sqlFuncion = "SELECT * from producto where id_producto=?";
		 ProductoDTO productoDTO = jdbctemple1.queryForObject(sqlFuncion, new Object[] {id},
                 BeanPropertyRowMapper.newInstance(ProductoDTO.class));
	        return productoDTO;

	}
	@Override
	public int deleteProduct(String id) {
	    String sqlFuncion = "UPDATE producto SET status = 0 WHERE id_producto = ?";
	    int rowsAffected = jdbctemple1.update(sqlFuncion, id);
	    return rowsAffected;
	}

	@Override
	public int insertProduct(ProductoDTO product) {
	    String sqlFuncion = "INSERT INTO producto (id_producto, nombre_producto, iva, costo_unitario, costo_total, descripcion, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    int rowsAffected = jdbctemple1.update(sqlFuncion, product.getId_producto(), product.getNombre_producto(), product.getIva(), product.getCosto_unitario(), product.getCosto_total(), product.getDescripcion(), product.getStatus());
	    System.out.println("si se guardo");
	    return rowsAffected;
	}

	@Override
	public int editProduct(ProductoDTO product) {
	    String sqlFuncion = "UPDATE producto SET nombre_producto = ?, iva = ?, costo_unitario = ?, costo_total = ?, descripcion = ?, status = ? WHERE id_producto = ?";
	    int rowsAffected = jdbctemple1.update(sqlFuncion, product.getNombre_producto(), product.getIva(), product.getCosto_unitario(), product.getCosto_total(), product.getDescripcion(), product.getStatus(), product.getId_producto());
	    return rowsAffected;
	}


}

