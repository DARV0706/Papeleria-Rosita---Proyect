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

import co.edu.unbosque.Papeleria.dao.VentaDAO;
import co.edu.unbosque.Papeleria.modelo.Venta;

@Controller
@RequestMapping("/venta")
public class VentaController {

	@Autowired
	private VentaDAO saleDao;
	
	@GetMapping("/list_sale")
	public ResponseEntity<List<Venta>> listSales() {
		List<Venta> logs = saleDao.listSale();

		if (logs.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(logs, HttpStatus.OK);
		}
	}
	
	@PostMapping("/insert_sale")
	public ResponseEntity<Venta> insertSale(@RequestBody Venta log) {
		Venta newLog = saleDao.insertSale(log);
		return new ResponseEntity<>(newLog, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete_sale/{id}")
	public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
		String resultado = saleDao.deleteSale(id);
		if (resultado.equals("ELIMINACION EXITOSA")) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/edit_sale")
	public ResponseEntity<Venta> editSale(@RequestBody Venta cli) {
		Venta editCustom = saleDao.editSale(cli);
		return new ResponseEntity<Venta>(editCustom, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/list_sale/{id}")
	public ResponseEntity<Optional> listCostumbyId(@PathVariable int id) {
		Optional<Venta> logs = saleDao.searchSale(id);
		if (logs == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(logs, HttpStatus.OK);
		}
	}
}
