package co.edu.unbosque.Papeleria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.unbosque.Papeleria.dao.ClienteDAO;
import co.edu.unbosque.Papeleria.modelo.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteDAO clientDao;
	
	@GetMapping("/list_client")
	public List listar_Cliente() {
		List<Cliente> lista = clientDao.listCustom();
		return lista;
		
	}
	
	public void nose() {
		
	}

	public void nose2() {
		
	}
}
