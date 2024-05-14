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

import co.edu.unbosque.Papeleria.dao.ProveedorDAO;
import co.edu.unbosque.Papeleria.dto.ProveedorDTO;

@Controller
public class ProveedorController {
	
	@Autowired
	private ProveedorDAO provDao;
	
	@GetMapping("/list_provider")
    public String listProvider(Model model) {
        List<ProveedorDTO> lista = provDao.listProvider();

        model.addAttribute("listaProveedor", lista);
        return "formProveedores";
    }
	
	@GetMapping("/insert_provider")
    public String abrirProveedor(Model model) {
		model.addAttribute("proveedor", new ProveedorDTO());
		return "CrearProveedor";
	}
	
	@PostMapping("/save_provider")
    public String insertInventory(@ModelAttribute ProveedorDTO proveedordto){
		provDao.insertProvider(proveedordto);
        return "redirect:/list_provider";
    }
	
    @GetMapping("/delete_provider/{id}")
    public String deleteProvider(@PathVariable int id) {
        provDao.deleteProvider(id);
        return "redirect:/list_provider";
    }
    
    @GetMapping("/edit_provider/{id}")
    public String editProvider(@PathVariable int id, Model model){
    	ProveedorDTO proveedor = provDao.searchProvider(id);
		model.addAttribute("editProveedor", proveedor);
		return "EditarProveedor";
    }
    
    @PostMapping("/update_provider")
	public String upProvider(@ModelAttribute ProveedorDTO provdto) {
		provDao.editProvider(provdto);
		return "redirect:/list_provider";
	}
    
//	@GetMapping("/list_provider/{id}")
//    public ResponseEntity<Optional> listProviderId(@PathVariable int id) {
//        Optional<Proveedor> logs = provDao.searchProvider(id);
//
//        if (logs == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<>( logs, HttpStatus.OK);
//        }
//    }
	

}
