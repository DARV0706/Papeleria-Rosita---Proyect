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

import co.edu.unbosque.Papeleria.dao.CompraDAO;
import co.edu.unbosque.Papeleria.modelo.Compra;

@Controller
@RequestMapping("/compra")
public class CompraController {

	@Autowired
	private CompraDAO buyDao;

	@GetMapping("/list_buy")
	public ResponseEntity<List<Compra>> listBuy() {
		List<Compra> logs = buyDao.listBuy();

		if (logs.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(logs, HttpStatus.OK);
		}
	}

	@PostMapping("/insert_buy")
	public ResponseEntity<Compra> insertBuy(@RequestBody Compra log) {
		Compra newLog = buyDao.insertBuy(log);
		return new ResponseEntity<>(newLog, HttpStatus.OK);
	}

	@DeleteMapping("/delete_compra/{id}")
	public ResponseEntity<Void> deleteBuy(@PathVariable Long id) {
		String resultado = buyDao.deleteBuy(id);
		if (resultado.equals("ELIMINACION EXITOSA")) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/edit_buy")
	public ResponseEntity<Compra> editCustom(@RequestBody Compra cli) {
		Compra editCustom = buyDao.editBuy(cli);
		return new ResponseEntity<Compra>(editCustom, HttpStatus.ACCEPTED);

	}
	
	@GetMapping("/list_buy/{id}")
    public ResponseEntity<Optional> listBuy(@PathVariable int id) {
        Optional<Compra> logs = buyDao.searchBuy(id);

        if (logs == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>( logs, HttpStatus.OK);
        }
    }
}
