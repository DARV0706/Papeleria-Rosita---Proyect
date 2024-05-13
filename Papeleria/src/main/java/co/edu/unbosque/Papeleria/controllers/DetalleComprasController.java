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
import co.edu.unbosque.Papeleria.modelo.DetalleCompraId;
import co.edu.unbosque.Papeleria.modelo.DetalleVentaId;
import co.edu.unbosque.Papeleria.modelo.DetalleVentas;

@Controller
@RequestMapping("/detalleCompras")
public class DetalleComprasController {
	@Autowired
	private DetalleCompraDAO BuyRepoDao;
	
	@GetMapping("/list_buyRep")
	public ResponseEntity<List<DetalleCompra>> listSalesRep() {
		List<DetalleCompra> logs = BuyRepoDao.listBuyRep();

		if (logs.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(logs, HttpStatus.OK);
		}
	}

	@PostMapping("/insert_buyRep")
	public ResponseEntity<DetalleCompra> insertSalesRep(@RequestBody DetalleCompra log) {
		DetalleCompra newLog = BuyRepoDao.insertBuyRep(log);
		return new ResponseEntity<>(newLog, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete_buyRep/{id}/{id2}/{id3}")
	public ResponseEntity<Void> deleteSalesRep(@PathVariable int id,@PathVariable int id2, @PathVariable String id3 ) {
		DetalleCompraId aux = new DetalleCompraId(id, id2, id3);
		String resultado = BuyRepoDao.deleteBuyRep(aux);
		if (resultado.equals("ELIMINACION EXITOSA")) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/edit_buyRep")
	public ResponseEntity<DetalleCompra> editSalesRep(@RequestBody DetalleCompra cli) {
		DetalleCompra editBuyReport = BuyRepoDao.editBuyRep(cli);
		return new ResponseEntity<DetalleCompra>(editBuyReport, HttpStatus.ACCEPTED);

	}

	@GetMapping("/list_buyRep/{id}/{id2}/{id3}")
	public ResponseEntity<Optional> listCostumbyId(@PathVariable int id,@PathVariable int id2, @PathVariable String id3) {
		DetalleCompraId aux = new DetalleCompraId(id, id2, id3);
		Optional<DetalleCompra> logs = BuyRepoDao.searchBuyRep(aux);
		if (logs == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(logs, HttpStatus.OK);
		}
	}
	

}
