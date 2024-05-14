package co.edu.unbosque.Papeleria.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import co.edu.unbosque.Papeleria.dao.ClienteDAO;
import co.edu.unbosque.Papeleria.dto.ClienteDTO;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteDAO clientDao;
	
	@GetMapping("/listaCliente")
	public String listar(Model modelo) {
	  List<ClienteDTO> lista = clientDao.listCustom();
	  modelo.addAttribute("listaCliente", lista);
	  return "formCliente";
	}
	
	@GetMapping("/insertarCliente")
	public String insertar(Model model) {
		model.addAttribute("cliente", new ClienteDTO());
		return "CrearCliente";
	}
	
	@PostMapping("/guardarCliente")
	public String guardar(@ModelAttribute ClienteDTO clienteDTO) {
		clientDao.insertCustom(clienteDTO);
		return "redirect:/listaCliente";
	}
	
	@GetMapping("/editarCliente/{id}")
	public String editar(@PathVariable int id, Model model) {
		ClienteDTO clienteDTO = clientDao.searchCustom(id);
		model.addAttribute("cliente", clienteDTO);
		return "EditarCliente";
	}
	
	@PostMapping("/actualizarCliente")
	public String actualizar(@ModelAttribute ClienteDTO clienteDTO) {
		clientDao.editCustom(clienteDTO);
		return "redirect:/listaCliente";
	}
	
	@GetMapping("/borrarCliente/{id}")
	public String borrar(@PathVariable int id) {
		clientDao.deleteCustom(id);
		return "redirect:/listaCliente";
	}

}