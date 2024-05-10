package co.edu.unbosque.Papeleria.dto;

public class ClienteDTO {
	private int id_cliente;
	private String nom_cliente;
	
	public void ClienteDTO() {
		
	}

	public ClienteDTO(int id_cliente, String nom_cliente) {
		super();
		this.id_cliente = id_cliente;
		this.nom_cliente = nom_cliente;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNom_cliente() {
		return nom_cliente;
	}

	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}

}
