package co.edu.unbosque.Papeleria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import co.edu.unbosque.Papeleria.dao.InventarioDAO;
import co.edu.unbosque.Papeleria.dto.InventarioDTO;

@Controller
public class InventarioController {

	@Autowired
	private InventarioDAO inventoryDao;

	@GetMapping("/list_inventory")
	public String listInventory(Model model) {
		List<InventarioDTO> lista = inventoryDao.listInventory();
		
//		// Imprimir los datos en la consola del servidor
//        System.out.println("Datos de inventario obtenidos correctamente desde la base de datos:");
//        for (Inventario inventario : inventarios) {
//            System.out.println("ID: " + inventario.getId_inventario() + ", Descripción: " + inventario.getDescripcion() + ", Cantidad: " + inventario.getCantidad());
//        }
        
		model.addAttribute("listaInventario", lista);
		return "formInventarioGladis";
	}
	
	@GetMapping("/list_inventory_rosita")
	public String listInventoryRosita(Model model) {
		List<InventarioDTO> lista = inventoryDao.listInventory();
		
//		// Imprimir los datos en la consola del servidor
//        System.out.println("Datos de inventario obtenidos correctamente desde la base de datos:");
//        for (Inventario inventario : inventarios) {
//            System.out.println("ID: " + inventario.getId_inventario() + ", Descripción: " + inventario.getDescripcion() + ", Cantidad: " + inventario.getCantidad());
//        }
        
		model.addAttribute("listaInventarioRosita", lista);
		return "formInventario";
	}
	
//	@PostMapping("/inventario/insert_inventory")
//    public String insertInventory(@ModelAttribute("inventarioDTO") InventarioDTO inventarioDTO) {
//        inventoryDao.insertInventory(convertToInventarioEntity(inventarioDTO));
//        return "redirect:/inventario/list_inventory";
//    }
	
	@GetMapping("/insert_inventory")
	public String abrirInventario(Model model) {
		model.addAttribute("inventario", new InventarioDTO());
		return "CrearInventario";
	}
	
	@PostMapping("/save_inventory")
    public String insertInventory(@ModelAttribute InventarioDTO inventariodto){
		inventoryDao.insertInventory(inventariodto);
        return "redirect:/list_inventory";
    }
	
	@GetMapping("/insert_inventory_rosita")
	public String abrirInventarioRosita(Model model) {
		model.addAttribute("inventarioRosita", new InventarioDTO());
		return "CrearInventarioRosita";
	}
	
	@PostMapping("/save_inventory_rosita")
    public String insertInventoryRosita(@ModelAttribute InventarioDTO inventariodto){
		inventoryDao.insertInventory(inventariodto);
        return "redirect:/list_inventory_rosita";
    }
	
//	@PostMapping("/insert_inventory")
//	public ModelAndView insertInventory(InventarioDTO inventario) {
//		
//	}

	@GetMapping("/delete_inventory/{id}")
	public String deleteInventory(@PathVariable String id) {
		inventoryDao.deleteInventory(id);
		return "redirect:/list_inventory";
	}
	
	@GetMapping("/delete_inventory_rosita/{id}")
	public String deleteInventoryRosita(@PathVariable String id) {
		inventoryDao.deleteInventory(id);
		return "redirect:/list_inventory_rosita";
	}

	@GetMapping("/edit_inventory/{id}")
	public String editInventory(@PathVariable String id, Model model) {
		InventarioDTO inventario = inventoryDao.searchInventory(id);
		model.addAttribute("editInventario", inventario);
		return "EditarInventario";
	}
	
	@GetMapping("/edit_inventory_rosita/{id}")
	public String editInventoryRosita(@PathVariable String id, Model model) {
		InventarioDTO inventario = inventoryDao.searchInventory(id);
		model.addAttribute("editInventarioRosita", inventario);
		return "EditarInventarioRosita";
	}
	
	@PostMapping("/update_inventory")
	public String upInventory(@ModelAttribute InventarioDTO inventariodto) {
		inventoryDao.editInventory(inventariodto);
		return "redirect:/list_inventory";
	}
	
	@PostMapping("/update_inventory_rosita")
	public String upInventoryRosita(@ModelAttribute InventarioDTO inventariodto) {
		inventoryDao.editInventory(inventariodto);
		return "redirect:/list_inventory_rosita";
	}
	
	
//	@GetMapping("/list_inventory/{id}")
//    public ResponseEntity<Optional> listInventorybyId(@PathVariable String id) {
//        Optional<Inventario> logs = inventoryDao.searchInventory(id);
//        if (logs == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<>( logs, HttpStatus.OK);
//        }
//    }
	
	
}
