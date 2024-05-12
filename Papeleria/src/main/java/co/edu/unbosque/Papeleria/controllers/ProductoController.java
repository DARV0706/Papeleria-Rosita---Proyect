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

import co.edu.unbosque.Papeleria.dao.ProductoDAO;
import co.edu.unbosque.Papeleria.dao.ProveedorDAO;
import co.edu.unbosque.Papeleria.modelo.Producto;
import co.edu.unbosque.Papeleria.modelo.Proveedor;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	private ProductoDAO prodDao;
	
	@GetMapping("/list_product")
    public ResponseEntity<List<Producto>> listProduct() {
        List<Producto> logs = prodDao.listProduct();

        if (logs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(logs, HttpStatus.OK);
        }
    }
	
	@PostMapping("/insert_product")
    public ResponseEntity<Producto> insertProduct(@RequestBody Producto pov) {
		Producto newProduct = prodDao.insertProduct(pov);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }
	
    @DeleteMapping("/delete_product/{id}")
    public ResponseEntity<Void> deleteProd(@PathVariable String id) {
        String resultado = prodDao.deleteProduct(id);
        if (resultado.equals("ELIMINACIÓN EXITOSA")) {
            return ResponseEntity.noContent().build(); 
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }
    
    @PutMapping("/edit_product")
    public ResponseEntity<Producto> editProduct(@RequestBody Producto pov){
    	Producto editProd = prodDao.editProduct(pov);
		return new ResponseEntity<Producto>(editProd, HttpStatus.ACCEPTED);
    	
    }
    
	@GetMapping("/list_product/{id}")
    public ResponseEntity<Optional> listProdbyId(@PathVariable String id) {
        Optional<Producto> logs = prodDao.searchProduct(id);

        if (logs == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>( logs, HttpStatus.OK);
        }
    }

}
