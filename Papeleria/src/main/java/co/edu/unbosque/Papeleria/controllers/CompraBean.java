package co.edu.unbosque.Papeleria.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import co.edu.unbosque.Papeleria.dao.CompraDAO;
import co.edu.unbosque.Papeleria.dto.CompraDTO;

@Controller
@RequestMapping("/compra")
public class CompraBean {

	@Autowired
	private CompraDAO buyDao;

	   @GetMapping("/list_buy")
	    public String listBuy(Model model) {
	        List<CompraDTO> lista = buyDao.listBuy();
	        model.addAttribute("listacompras", lista);
	        return "ListarComprashtml";
	    }

	    @PostMapping("/insert_buy")
	    public String insertBuy(@ModelAttribute CompraDTO compraDTO) {
	        buyDao.insertBuy(compraDTO);
	        return "redirect:/list_buy";
	    }

	    @DeleteMapping("/delete_compra/{id}")
	    public String deleteBuy(@PathVariable int id) {
	        buyDao.deleteBuy(id);
	        return "redirect:/list_buy";
	    }

	    @PutMapping("/edit_buy/{id}")
	    public String editBuy(@RequestBody CompraDTO compraDTO) {
	        buyDao.editBuy(compraDTO);
	        return "redirect:/list_buy";
	    }

	    @GetMapping("/list_buy/{id}")
	    public String listBuy(@PathVariable int id, Model model) {
	        buyDao.searchBuy(id);
			return "";

	    }
}
