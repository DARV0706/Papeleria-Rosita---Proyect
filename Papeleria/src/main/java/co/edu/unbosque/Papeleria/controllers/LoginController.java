package co.edu.unbosque.Papeleria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.unbosque.Papeleria.dao.LoginDAO;
import co.edu.unbosque.Papeleria.interfacesService.LoginCRUD;
import co.edu.unbosque.Papeleria.modelo.Login;
import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginDAO loginDao;

	@GetMapping("/list_logs")
    public ResponseEntity<List<Login>> listLogs() {
        List<Login> logs = loginDao.listlog();

        if (logs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(logs, HttpStatus.OK);
        }
    }
	
	@PostMapping("/insert_log")
    public ResponseEntity<Login> insertLog(@RequestBody Login log) {
        Login newLog = loginDao.createLog(log);
        return new ResponseEntity<>(newLog, HttpStatus.CREATED);
    }
	

    @DeleteMapping("/delete_log/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable String id) {
        String resultado = loginDao.deleteLog(id);
        if (resultado.equals("ELIMINACIÓN EXITOSA")) {
            return ResponseEntity.noContent().build(); 
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }

	
	

}
