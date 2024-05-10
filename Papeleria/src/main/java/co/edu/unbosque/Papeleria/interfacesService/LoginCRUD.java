package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;

import co.edu.unbosque.Papeleria.modelo.Login;

public interface LoginCRUD {
	public List<Login> listlog();
	public String deleteLog(String contra);
	public Login createLog(Login log);

}
