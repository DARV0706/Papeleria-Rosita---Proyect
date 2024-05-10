package co.edu.unbosque.Papeleria.dto;

import jakarta.persistence.Column;

public class Login {
	private String usuario;
	private String contrasenia;	
	

	public Login() {
		// TODO Auto-generated constructor stub
	}


	public Login(String usuario, String contrasenia) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	


}
