package co.edu.unbosque.Papeleria.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Papeleria.interfaces.ClienteRepository;
import co.edu.unbosque.Papeleria.interfacesService.ClienteCRUD;
import co.edu.unbosque.Papeleria.modelo.Cliente;
import jakarta.persistence.TypedQuery;

@Service
public class ClienteDAO implements ClienteCRUD {
	@Autowired
	private ClienteRepository clientRepo;

	@Override
	public List<Cliente> listCustom() {
		// TODO Auto-generated method stub
		return clientRepo.customsActives();
	}

	
	@Override
	public String deleteCustom(Long id) {
		// TODO Auto-generated method stub
		int status = 0; 
		 clientRepo.deleteCustom(id, status);;
		return "CLIENTE ELIMINADO";
	}

	@Override
	public Cliente insertCustom(Cliente cliente) {
		// TODO Auto-generated method stub
		Cliente cli = clientRepo.save(cliente);
		clientRepo.changeStatus(cliente.getId_cliente(), 1);
		return cli;
	}

	@Override
	public Cliente editCustom(Cliente cliente) {
		// TODO Auto-generated method stub
		Cliente aux = clientRepo.findById((long) cliente.getId_cliente()).orElse(null);
		aux.getId_cliente();
		aux.setTipo_identificacion(cliente.getTipo_identificacion());
		aux.setRazon_social(cliente.getRazon_social());
		aux.setTelefono(cliente.getTelefono());
		aux.setDireccion(cliente.getDireccion());
		aux.setSaldo_pendiente(cliente.getSaldo_pendiente());
		return clientRepo.save(aux);
	}


	@Override
	public Optional<Cliente> searchCustom(Long id) {
		
		return clientRepo.findById(id);
	}


	@Override
	public List<Cliente> listDeletedCustom() {
		// TODO Auto-generated method stub
		return clientRepo.customsDeleted();
	}

	
	

}
