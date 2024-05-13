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
		String sql = "SELECT * FROM producto where status=1";
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
		String sqlFuncion = "update producto set status=0 where id_producto=?";
	    
	    int resultadoFuncion = jdbctemple1.queryForObject(sqlFuncion, new Object[]{id}, Integer.class);
	    
	    return resultadoFuncion;
	}

	@Override
	public int insertProduct(ProductoDTO product) {
		product.setCosto_total(product.getCosto_unitario()*product.getIva());
		 String sqlFuncion = "insert into producto(id_producto,nombre_producto,iva,costo_unitario,costo_total,descripcion,status) values (?,?,?,?,?,?,?)";
		    int resultadoFuncion = jdbctemple1.queryForObject(sqlFuncion, new Object[]{product.getId_producto(),
		    		product.getNombre_producto(),product.getIva(),product.getCosto_unitario(),product.getCosto_total(),
		    		product.getDescripcion(), product.getStatus()}, Integer.class);

		    return resultadoFuncion;
	}

	@Override
	public int editProduct(ProductoDTO product) {
		product.setCosto_total(product.getCosto_unitario()*product.getIva());
		String sqlFuncion = "update producto set nombre_producto=?,iva=?,costo_unitario=?,costo_total=?,descripcion=?,status=? where id_producto=?";
	    int resultadoFuncion = jdbctemple1.queryForObject(sqlFuncion, new Object[]{
	    		product.getNombre_producto(),product.getIva(),product.getCosto_unitario(),product.getCosto_total(),
	    		product.getDescripcion(), product.getStatus(), product.getId_producto()}, Integer.class);

	    return resultadoFuncion;
	}
	
	

}
