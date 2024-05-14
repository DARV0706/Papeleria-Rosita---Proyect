package co.edu.unbosque.Papeleria.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Papeleria.dto.ClienteDTO;
import co.edu.unbosque.Papeleria.interfacesService.ClienteCRUD;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder.In;

@Repository
public class ClienteDAO implements ClienteCRUD {

	@Autowired
	private JdbcTemplate jdbctemple1;

	@Override
	public List<ClienteDTO> listCustom() {
		String sql = "SELECT * FROM cliente";
	    List<ClienteDTO> lista = jdbctemple1.query(sql, BeanPropertyRowMapper.newInstance(ClienteDTO.class));
	    return lista;
	}

	@Override
	public ClienteDTO searchCustom(int id) {
		String sqlFuncion = "SELECT * from cliente where id_cliente=?";
		ClienteDTO clienteDTO = jdbctemple1.queryForObject(sqlFuncion, new Object[] {id},
                BeanPropertyRowMapper.newInstance(ClienteDTO.class));
		return clienteDTO;
	}

	@Override
	public int deleteCustom(int id) {
	    String sqlFuncion = "UPDATE cliente SET status = 0 WHERE id_cliente = ?";
	    
	    int rowsAffected = jdbctemple1.update(sqlFuncion, id);
	    
	    return rowsAffected;
	}

	@Override
	public int insertCustom(ClienteDTO cliente) {
	    String sqlFuncion = "INSERT INTO cliente (id_cliente, tipo_identificacion, razon_social, telefono, direccion, saldo_pendiente, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    
	    int rowsAffected = jdbctemple1.update(sqlFuncion, cliente.getId_cliente(), cliente.getTipo_identificacion(), cliente.getRazon_social(), cliente.getTelefono(), cliente.getDireccion(), cliente.getSaldo_pendiente(), cliente.getStatus());
	    
	    return rowsAffected;
	}


	@Override
	public int editCustom(ClienteDTO cliente) {
	    String sqlFuncion = "UPDATE cliente SET tipo_identificacion=?, razon_social=?, telefono=?, direccion=?, saldo_pendiente=?, status=? WHERE id_cliente=?";
	    int rowsAffected = jdbctemple1.update(sqlFuncion, cliente.getTipo_identificacion(), cliente.getRazon_social(), cliente.getTelefono(), cliente.getDireccion(), cliente.getSaldo_pendiente(), cliente.getStatus(), cliente.getId_cliente());
	    return rowsAffected;
	}


	@Override
	public List<ClienteDTO> listDeletedCustom() {
		String sql = "SELECT * FROM cliente where status=0";
	    List<ClienteDTO> lista = jdbctemple1.query(sql, BeanPropertyRowMapper.newInstance(ClienteDTO.class));
	    return lista;
	}
	

}