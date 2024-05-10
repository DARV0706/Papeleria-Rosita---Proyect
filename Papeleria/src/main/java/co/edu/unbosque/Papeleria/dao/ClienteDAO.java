package co.edu.unbosque.Papeleria.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Papeleria.interfaces.ClienteRepository;
import co.edu.unbosque.Papeleria.interfacesService.ClienteCRUD;
import co.edu.unbosque.Papeleria.modelo.Cliente;

@Service
public class ClienteDAO implements ClienteCRUD {
	@Autowired
	private ClienteRepository clientRepo;

	@Override
	public List<Cliente> listCustom() {
		// TODO Auto-generated method stub
		return clientRepo.findAll();
	}

	@Override
	public Cliente searchCustom(Long id) {
		// TODO Auto-generated method stub
		return clientRepo.getById(id);
	}

	@Override
	public String deleteCustom(Long id) {
		// TODO Auto-generated method stub
		 clientRepo.deleteById(id);;
		return "CLIENTE ELIMINADO";
	}

	@Override
	public Cliente insertCustom(Cliente cliente) {
		// TODO Auto-generated method stub
		return clientRepo.save(cliente);
	}
	
	

}
