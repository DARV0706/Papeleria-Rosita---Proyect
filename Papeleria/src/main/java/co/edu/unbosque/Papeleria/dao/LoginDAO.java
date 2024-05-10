package co.edu.unbosque.Papeleria.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Papeleria.interfaces.LoginRepository;
import co.edu.unbosque.Papeleria.interfacesService.LoginCRUD;
import co.edu.unbosque.Papeleria.modelo.Login;
@Service
public class LoginDAO implements LoginCRUD {
	
	@Autowired
	private LoginRepository logrepo;
	@Override
	public List<Login> listlog() {
		// TODO Auto-generated method stub
		return logrepo.findAll();
	}

	@Override
	public String deleteLog(String contra) {
		logrepo.deleteById(contra);
		return "ELIMINACIÓN EXITOSA";
	}

	@Override
	public Login createLog(Login log) {
		// TODO Auto-generated method stub
		return logrepo.save(log);
	}
	

}
