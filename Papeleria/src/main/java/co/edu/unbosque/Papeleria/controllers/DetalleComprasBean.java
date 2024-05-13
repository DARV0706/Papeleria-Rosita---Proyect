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

import co.edu.unbosque.Papeleria.dao.DetalleCompraDAO;
import co.edu.unbosque.Papeleria.dto.DetalleCompraDTO;


@Controller
@RequestMapping("/detalleCompras")
public class DetalleComprasBean {
	@Autowired
	private DetalleCompraDAO BuyRepoDao;
	
	 @GetMapping("/list_buyRep")
	    public String listBuyRep(Model model) {
	        List<DetalleCompraDTO> logs = BuyRepoDao.listBuyRep();
	        model.addAttribute("listaDetalleCompra",logs);
	          return "list_buy_rep_view"; // Vista para mostrar la lista de registros
	    }

	    @PostMapping("/insert_buyRep")
	    public String insertBuyRep(@ModelAttribute DetalleCompraDTO log) {
	        BuyRepoDao.insertBuyRep(log);
	        return "redirect:/detalleCompras/list_buyRep"; 
	    }

	    @DeleteMapping("/delete_buyRep/{id}/{id2}/{id3}")
	    public String deleteBuyRep(@PathVariable int id, @PathVariable int id2, @PathVariable String id3) {
	    	BuyRepoDao.deleteBuyRep(id, id2, id3);
	        return "redirect:/detalleCompras/list_buyRep"; 
	    }

	    @PutMapping("/edit_buyRep")
	    public String editBuyRep(@ModelAttribute DetalleCompraDTO cli) {
	        BuyRepoDao.editBuyRep(cli);
	        return "redirect:/detalleCompras/list_buyRep"; 
	    }

	    @GetMapping("/list_buyRep/{id}/{id2}/{id3}")
	    public String listBuyRepById(@PathVariable int id, @PathVariable int id2, @PathVariable String id3, Model model) {
	    	BuyRepoDao.searchBuyRep(id, id2, id3);
	        return "detalle_compra_view"; 

	    }
	

}
