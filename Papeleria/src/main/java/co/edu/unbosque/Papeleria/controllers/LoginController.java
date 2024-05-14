package co.edu.unbosque.Papeleria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@PostMapping("/Login")
	public String login(@RequestParam("email") String email,
            @RequestParam("password") String password,
            RedirectAttributes redirectAttributes) {
		
	     String usuarioRosita = "rosita@gmail.com";
	     String passwordRosita = "rosita123";
	     
	     String usuarioGladis = "gladis@gmail.com";
	     String passwordGladis = "usuario123";

	        if (email.equals(usuarioRosita) && password.equals(passwordRosita)) {
	            return "redirect:/menuRosita";
	        } else if (email.equals(usuarioGladis) && password.equals(passwordGladis)) {
				return "redirect:/menuGladis";
			}else {
	            redirectAttributes.addFlashAttribute("error", "Email o contraseña incorrectos");
	            return "redirect:/login";
	        }
	    }
	
	@GetMapping("/menuRosita")
    public String meuRosita() {
        return "MenuRosita";
    }
	
	@GetMapping("/menuGladis")
    public String menuGladis() {
        return "MenuGladis";
    }
	
	@GetMapping("/")
    public String hola() {
        return "index";
    }
	

}
