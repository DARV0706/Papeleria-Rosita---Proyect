package co.edu.unbosque.Papeleria.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity 
@Table(name="Cliente")
public class Cliente {
	
	private int id_cliente;
	
	private String nom_cliente;
	
	public void Cliente() {
		
	}

	public Cliente(int id_cliente, String nom_cliente) {
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
