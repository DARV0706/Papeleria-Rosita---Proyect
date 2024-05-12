package co.edu.unbosque.Papeleria.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.unbosque.Papeleria.dao.ClienteDAO;
import co.edu.unbosque.Papeleria.modelo.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteDAO clientDao;
	
	@GetMapping("/list_client")
    public ResponseEntity<List<Cliente>> listCostum() {
        List<Cliente> logs = clientDao.listCustom();

        if (logs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(logs, HttpStatus.OK);
        }
    }
	
	@PostMapping("/insert_custom")
    public ResponseEntity<Cliente> insertCustom(@RequestBody Cliente log) {
        Cliente newLog = clientDao.insertCustom(log);
        return new ResponseEntity<>(newLog, HttpStatus.OK);
    }
	
    @DeleteMapping("/delete_custom/{id}")
    public ResponseEntity<Void> deleteCustom(@PathVariable Long id) {
        String resultado = clientDao.deleteCustom(id);
        if (resultado.equals("ELIMINACIÓN EXITOSA")) {
            return ResponseEntity.noContent().build(); 
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }
    
    @PutMapping("/edit_custom")
    public ResponseEntity<Cliente> editCustom(@RequestBody Cliente cli){
    	Cliente editCustom = clientDao.editCustom(cli);
		return new ResponseEntity<Cliente>(editCustom, HttpStatus.ACCEPTED);
    	
    }
    
	@GetMapping("/list_client/{id}")
    public ResponseEntity<Optional> listCostumbyId(@PathVariable int id) {
        Optional<Cliente> logs = clientDao.searchCustom(id);

        if (logs == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>( logs, HttpStatus.OK);
        }
    }
	
	


}