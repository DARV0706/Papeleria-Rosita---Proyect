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

import co.edu.unbosque.Papeleria.dao.DetalleCompraDAO;
import co.edu.unbosque.Papeleria.modelo.DetalleCompra;
import co.edu.unbosque.Papeleria.modelo.DetalleVentas;

@Controller
@RequestMapping("/detalleCompras")
public class DetalleComprasController {
	@Autowired
	private DetalleCompraDAO BuyRepoDao;
	
	@GetMapping("/list_salesRep")
	public ResponseEntity<List<DetalleCompra>> listSalesRep() {
		List<DetalleCompra> logs = BuyRepoDao.listBuyRep();

		if (logs.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(logs, HttpStatus.OK);
		}
	}

	@PostMapping("/insert_salesRep")
	public ResponseEntity<DetalleCompra> insertSalesRep(@RequestBody DetalleCompra log) {
		DetalleCompra newLog = BuyRepoDao.insertBuyRep(log);
		return new ResponseEntity<>(newLog, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete_salesRep/{id}")
	public ResponseEntity<Void> deleteSalesRep(@PathVariable Long id) {
		String resultado = BuyRepoDao.deleteBuyRep(id);
		if (resultado.equals("ELIMINACION EXITOSA")) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/edit_salesRep")
	public ResponseEntity<DetalleCompra> editSalesRep(@RequestBody DetalleCompra cli) {
		DetalleCompra editBuyReport = BuyRepoDao.editBuyRep(cli);
		return new ResponseEntity<DetalleCompra>(editBuyReport, HttpStatus.ACCEPTED);

	}

	@GetMapping("/list_salesRep/{id}")
	public ResponseEntity<Optional> listCostumbyId(@PathVariable Long id) {
		Optional<DetalleCompra> logs = BuyRepoDao.searchBuyRep(id);
		if (logs == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(logs, HttpStatus.OK);
		}
	}
	

}
