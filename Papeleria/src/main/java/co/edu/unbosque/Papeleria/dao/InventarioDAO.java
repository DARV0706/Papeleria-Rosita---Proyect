package co.edu.unbosque.Papeleria.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.Papeleria.dto.InventarioDTO;
import co.edu.unbosque.Papeleria.interfacesService.InventarioCRUD;

@Repository
public class InventarioDAO implements InventarioCRUD<InventarioDTO> {

	@Autowired
	private JdbcTemplate jdbctemple1;

	@Override
	public List<InventarioDTO> listInventory() {
		String sql = "SELECT * FROM inventario";
		List<InventarioDTO> lista = jdbctemple1.query(sql, BeanPropertyRowMapper.newInstance(InventarioDTO.class));
		return lista;
	}

	@Override
	public InventarioDTO searchInventory(String id) {
		String sql = "SELECT * FROM inventario WHERE id_inventario = ?";
		InventarioDTO resultado = jdbctemple1.queryForObject(sql, new Object[] {id}, BeanPropertyRowMapper.newInstance(InventarioDTO.class));
		return resultado;
	}

	@Override
	public int deleteInventory(String id) {
		String sql = "DELETE FROM inventario WHERE id_Inventario = ?";
		int resultado = jdbctemple1.update(sql, new Object[] {id});
		return resultado;
	}

	@Override
	public int insertInventory(InventarioDTO inventory) {
		String sql = "INSERT INTO inventario VALUES(?, ?, ?, ?)";
		int resultado = jdbctemple1.update(sql, inventory.getId_inventario(), inventory.getDescripcion(), inventory.getCantidad(), inventory.getProducto_id_producto());
		
		if(resultado == 1) {
			System.out.println("Inventaria creado");
		} else if (resultado == 0) {
			System.out.println("El inventario ya existe");
		}
		return resultado;
	}

	@Override
	public int editInventory(InventarioDTO inventory) {
		String sql = "UPDATE inventario SET descripcion = ?, cantidad = ?, producto_id_producto = ? WHERE id_inventario = ?";
		int resultado = jdbctemple1.update(sql, inventory.getDescripcion(), inventory.getCantidad(), inventory.getProducto_id_producto(), inventory.getId_inventario());
		
		if(resultado == 1) {
			System.out.println("Inventario Actualizado");
		} else if (resultado == 0) {
			System.out.println("El inventario no existe");
		}
		return resultado;
	}

}
