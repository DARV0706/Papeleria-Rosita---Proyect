package co.edu.unbosque.Papeleria.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.Papeleria.dto.ProveedorDTO;
import co.edu.unbosque.Papeleria.interfacesService.ProveedorCRUD;

@Repository
public class ProveedorDAO implements ProveedorCRUD<ProveedorDTO> {
	
	@Autowired
	private JdbcTemplate jdbctemple1;

	@Override
	public List<ProveedorDTO> listProvider() {
		String sql = "SELECT * FROM proveedor";
		List<ProveedorDTO> lista = jdbctemple1.query(sql, BeanPropertyRowMapper.newInstance(ProveedorDTO.class));
		return lista;
	}

	@Override
	public ProveedorDTO searchProvider(int id) {
		String sql = "SELECT * FROM proveedor WHERE id_proveedor = ?";
		ProveedorDTO resultado = jdbctemple1.queryForObject(sql, new Object[] {id}, BeanPropertyRowMapper.newInstance(ProveedorDTO.class));
		return resultado;
	}

	@Override
	public int deleteProvider(int id) {
		String sql = "DELETE FROM proveedor WHERE id_proveedor = ?";
		int resultado = jdbctemple1.update(sql, new Object[] {id});
		return resultado;
	}

	@Override
	public int insertProvider(ProveedorDTO proveedor) {
		String sql = "INSERT INTO proveedor VALUES(?, ?, ?, ?, ?, ?, ?)";
		int resultado = jdbctemple1.update(sql, proveedor.getId_proveedor(), proveedor.getTipo_identificacion(), proveedor.getRazon_social(), proveedor.getTelefono(), proveedor.getDireccion(), proveedor.getSaldo_pendiente(), proveedor.getStatus());
		
		if(resultado == 1) {
			System.out.println("proveedor creado");
		} else if (resultado == 0) {
			System.out.println("El proveedor ya existe");
		}
		return resultado;
	}

	@Override
	public int editProvider(ProveedorDTO proveedor) {
		String sql = "UPDATE proveedor SET tipo_identificacion = ?, razon_social = ?, telefono = ?, direccion = ?, saldo_pendiente = ?, status = ? WHERE id_proveedor = ?";
		int resultado = jdbctemple1.update(sql, proveedor.getTipo_identificacion(), proveedor.getRazon_social(), proveedor.getTelefono(),  proveedor.getDireccion(), proveedor.getSaldo_pendiente(), proveedor.getStatus(), proveedor.getId_proveedor());
		
		if(resultado == 1) {
			System.out.println("Proveedor Actualizado");
		} else if (resultado == 0) {
			System.out.println("El proveedor no existe");
		}
		return resultado;
	}
}
