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

import co.edu.unbosque.Papeleria.dao.ProductoDAO;
import co.edu.unbosque.Papeleria.dao.ProveedorDAO;
import co.edu.unbosque.Papeleria.dto.ProductoDTO;


@Controller
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	private ProductoDAO prodDao;
	
	@GetMapping("/listaProducto")
	public String listarFestival(Model modelo) {
	  List<ProductoDTO> lista = prodDao.listProduct();
	  modelo.addAttribute("listaProducto", lista);
	  return "formProducto";
	}
	
	@GetMapping("/insertarProducto")
	public String insertar(Model model) {
		model.addAttribute("producto", new ProductoDTO());
		return "CrearProducto";
	}
	
	@PostMapping("/guardarProducto")
	public String guardar(@ModelAttribute ProductoDTO productoDTO) {
		prodDao.insertProduct(productoDTO);
		return "redirect:/listaProducto";
	}
	
	@GetMapping("/editarProducto/{id}")
	public String editar(@PathVariable String id, Model model) {
		ProductoDTO productoDTO = prodDao.searchProduct(id);
		model.addAttribute("producto", productoDTO);
		return "EditarFestival";
	}
	
	@PostMapping("/actualizarProducto")
	public String actualizar(@ModelAttribute ProductoDTO productoDTO) {
		prodDao.editProduct(productoDTO);
		return "redirect:/listaProducto";
	}
	
	@GetMapping("/borrarProducto/{id}")
	public String borrarpelicula(@PathVariable String id) {
		prodDao.deleteProduct(id);
		return "redirect:/listaProducto";
	}

}
