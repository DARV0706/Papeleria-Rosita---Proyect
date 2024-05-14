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
import co.edu.unbosque.Papeleria.dto.ProductoDTO;



@Controller
public class ProductoController {
	@Autowired
	private ProductoDAO prodDao;
	
	
	@GetMapping("/listaProducto")
	public String listar(Model modelo) {
	  List<ProductoDTO> lista = prodDao.listProduct();
	  modelo.addAttribute("listaProducto", lista);
	  return "formProducto";
	}
	
	@GetMapping("/listaProductoGladis")
	public String listarGladis(Model modelo) {
	  List<ProductoDTO> lista = prodDao.listProduct();
	  modelo.addAttribute("listaProducto", lista);
	  return "formProductoGladis";
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
		return "EditarProducto";
	}
	
	@PostMapping("/actualizarProducto")
	public String actualizar(@ModelAttribute ProductoDTO productoDTO) {
		prodDao.editProduct(productoDTO);
		return "redirect:/listaProducto";
	}
	
	@GetMapping("/borrarProducto/{id}")
	public String borrar(@PathVariable String id) {
		prodDao.deleteProduct(id);
		return "redirect:/listaProducto";
	}

	@GetMapping("/insertarProductoGladis")
	public String insertarGladis(Model model) {
		model.addAttribute("producto", new ProductoDTO());
		return "CrearProductoGladis";
	}
	
	@PostMapping("/guardarProductoGladis")
	public String guardarGladis(@ModelAttribute ProductoDTO productoDTO) {
		prodDao.insertProduct(productoDTO);
		return "redirect:/listaProductoGladis";
	}
	
	@GetMapping("/editarProductoGladis/{id}")
	public String editarGladis(@PathVariable String id, Model model) {
		ProductoDTO productoDTO = prodDao.searchProduct(id);
		model.addAttribute("producto", productoDTO);
		return "EditarProductoGladis";
	}
	
	@PostMapping("/actualizarProductoGladis")
	public String actualizarGladis(@ModelAttribute ProductoDTO productoDTO) {
		prodDao.editProduct(productoDTO);
		return "redirect:/listaProductoGladis";
	}
	
	@GetMapping("/borrarProductoGladis/{id}")
	public String borrarGladis(@PathVariable String id) {
		prodDao.deleteProduct(id);
		return "redirect:/listaProductoGladis";
	}

}

