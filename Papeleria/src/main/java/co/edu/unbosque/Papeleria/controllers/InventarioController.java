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
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.unbosque.Papeleria.dao.InventarioDAO;
import co.edu.unbosque.Papeleria.dto.InventarioDTO;
import co.edu.unbosque.Papeleria.modelo.Inventario;

@Controller
@RequestMapping("/inventario")
public class InventarioController {

	@Autowired
	private InventarioDAO inventoryDao;

	@GetMapping("/list_inventory")
	public String listInventory(Model model) {
		List<Inventario> inventarios = inventoryDao.listInventory();
		
		// Imprimir los datos en la consola del servidor
        System.out.println("Datos de inventario obtenidos correctamente desde la base de datos:");
        for (Inventario inventario : inventarios) {
            System.out.println("ID: " + inventario.getId_inventario() + ", Descripción: " + inventario.getDescripcion() + ", Cantidad: " + inventario.getCantidad());
        }
        
		model.addAttribute("list_inventory", inventarios);
		return "formInventario";
	}
	
//	@PostMapping("/inventario/insert_inventory")
//    public String insertInventory(@ModelAttribute("inventarioDTO") InventarioDTO inventarioDTO) {
//        inventoryDao.insertInventory(convertToInventarioEntity(inventarioDTO));
//        return "redirect:/inventario/list_inventory";
//    }
	
	@PostMapping("/insert_inventory")
    public String insertInventory(@RequestParam String id_inventario, @RequestParam String descripcion, @RequestParam int cantidad, @RequestParam String producto_id_producto) {
        Inventario inventario = new Inventario();
        inventario.setId_inventario(id_inventario);
        inventario.setDescripcion(descripcion);
        inventario.setCantidad(cantidad);
        inventario.setProducto_id_producto(producto_id_producto);
        inventoryDao.insertInventory(inventario);
        
        return "/inventario/list_inventory";
    }
	
//	@PostMapping("/insert_inventory")
//	public ModelAndView insertInventory(InventarioDTO inventario) {
//		
//	}

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
	
	private Inventario convertToInventarioEntity(InventarioDTO inventarioDTO) {
        Inventario inventario = new Inventario();
        inventario.setId_inventario(inventarioDTO.getId_inventario());
        inventario.setDescripcion(inventarioDTO.getDescripcion());
        inventario.setCantidad(inventarioDTO.getCantidad());
        inventario.setProducto_id_producto(inventarioDTO.getProducto_id_producto());
        return inventario;
    }
	
}
