package co.edu.unbosque.Papeleria.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="Cliente")
public class Cliente {
	@Id
	private int id_cliente;
	@Column(name = "tipo_identificacion")
	private String tipo_identificacion;
	@Column(name = "razon_social")
	private String razon_social;
	@Column(name = "telefono")
	private int telefono;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "saldo_pendiente")
	private int saldo_pendiente;
	@Column(name = "status")
	private int status;
	
	public Cliente() {
		
	}

	public Cliente(int id_cliente, String tipo_identificacion, String razon_social, int telefono, String direccion,
			int saldo_pendiente) {
		super();
		this.id_cliente = id_cliente;
		this.tipo_identificacion = tipo_identificacion;
		this.razon_social = razon_social;
		this.telefono = telefono;
		this.direccion = direccion;
		this.saldo_pendiente = saldo_pendiente;

	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getTipo_identificacion() {
		return tipo_identificacion;
	}

	public void setTipo_identificacion(String tipo_identificacion) {
		this.tipo_identificacion = tipo_identificacion;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getSaldo_pendiente() {
		return saldo_pendiente;
	}

	public void setSaldo_pendiente(int saldo_pendiente) {
		this.saldo_pendiente = saldo_pendiente;
	}

//	public int getStatus() {
//		return status;
//	}
//
//	public void setStatus(int status) {
//		this.status = status;
//	}



}
