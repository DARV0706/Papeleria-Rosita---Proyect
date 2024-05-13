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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.unbosque.Papeleria.dao.InventarioDAO;
import co.edu.unbosque.Papeleria.modelo.Inventario;

@Controller
@RequestMapping("/inventario")
public class InventarioController {

	@Autowired
	private InventarioDAO inventoryDao;

	@GetMapping("/list_inventory")
	public String mostrar_inventario(Model model) {
		List<Inventario> inventarios = inventoryDao.listInventory();
		System.out.println("Lista de inventarios: " + inventarios);
		model.addAttribute("list_inventory", inventarios);
		return "formInventario";
	}
	

	@PostMapping("/insert_inventory")
	public ResponseEntity<Inventario> insertInventory(@RequestBody Inventario log) {
		Inventario newLog = inventoryDao.insertInventory(log);
		return new ResponseEntity<>(newLog, HttpStatus.OK);
	}

	@DeleteMapping("/delete_inventory/{id}")
	public ResponseEntity<Void> deleteInventory(@PathVariable String id) {
		String resultado = inventoryDao.deleteInventory(id);
		if (resultado.equals("ELIMINACION EXITOSA")) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/edit_inventory")
	public ResponseEntity<Inventario> editInventory(@RequestBody Inventario cli) {
		Inventario editCustom = inventoryDao.editInventory(cli);
		return new ResponseEntity<Inventario>(editCustom, HttpStatus.ACCEPTED);

	}
	
	@GetMapping("/list_inventory/{id}")
    public ResponseEntity<Optional> listInventorybyId(@PathVariable String id) {
        Optional<Inventario> logs = inventoryDao.searchInventory(id);
        if (logs == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>( logs, HttpStatus.OK);
        }
    }
	
	@GetMapping("/")
	public String Login() {
		return "MenuRosita";
	}
	
}
