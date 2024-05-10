package co.edu.unbosque.Papeleria.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Venta")
public class Venta {
	@Id
	private int id_venta;
	@Column(name = "fecha_venta")
	private String fecha_venta;
	@Column(name = "totalizado")
	private int totalizado;
	@Column(name = "saldo")
	private int saldo;
	@Column(name = "Cliente_id_cliente")
	private int cliente_id_cliente;
	@Column(name = "status")
	private int status;
	
	public void Venta() {
		
	}

	public Venta(int id_venta, String fecha_venta, int totalizado, int saldo, int cliente_id_cliente, int status) {
		super();
		this.id_venta = id_venta;
		this.fecha_venta = fecha_venta;
		this.totalizado = totalizado;
		this.saldo = saldo;
		this.cliente_id_cliente = cliente_id_cliente;
		this.status = status;
	}

	public int getId_venta() {
		return id_venta;
	}

	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}

	public String getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(String fecha_venta) {
		this.fecha_venta = fecha_venta;
	}

	public int getTotalizado() {
		return totalizado;
	}

	public void setTotalizado(int totalizado) {
		this.totalizado = totalizado;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public int getCliente_id_cliente() {
		return cliente_id_cliente;
	}

	public void setCliente_id_cliente(int cliente_id_cliente) {
		this.cliente_id_cliente = cliente_id_cliente;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
