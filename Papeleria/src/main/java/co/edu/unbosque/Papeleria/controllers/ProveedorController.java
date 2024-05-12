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

import co.edu.unbosque.Papeleria.dao.ProveedorDAO;
import co.edu.unbosque.Papeleria.modelo.Cliente;
import co.edu.unbosque.Papeleria.modelo.Proveedor;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
	@Autowired
	private ProveedorDAO provDao;
	
	@GetMapping("/list_provider")
    public ResponseEntity<List<Proveedor>> listProvider() {
        List<Proveedor> logs = provDao.listProvider();

        if (logs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(logs, HttpStatus.OK);
        }
    }
	
	@PostMapping("/insert_provider")
    public ResponseEntity<Proveedor> insertProvider(@RequestBody Proveedor pov) {
		Proveedor newProvider = provDao.insertProvider(pov);
        return new ResponseEntity<>(newProvider, HttpStatus.OK);
    }
	
    @DeleteMapping("/delete_provider/{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable Long id) {
        String resultado = provDao.deleteProvider(id);
        if (resultado.equals("ELIMINACIÓN EXITOSA")) {
            return ResponseEntity.noContent().build(); 
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }
    
    @PutMapping("/edit_provider")
    public ResponseEntity<Proveedor> editProvider(@RequestBody Proveedor pov){
    	Proveedor editProvider = provDao.editProvider(pov);
		return new ResponseEntity<Proveedor>(editProvider, HttpStatus.ACCEPTED);
    	
    }
    
	@GetMapping("/list_provider/{id}")
    public ResponseEntity<Optional> listProviderId(@PathVariable Long id) {
        Optional<Proveedor> logs = provDao.searchProvider(id);

        if (logs == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>( logs, HttpStatus.OK);
        }
    }
	

}
