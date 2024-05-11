package co.edu.unbosque.Papeleria.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Compra")
public class Compra {
	@Id
	private int id_compra;
	@Column(name = "fecha_compra")
	private String fecha_compra;
	@Column(name = "fecha_llegada")
	private String fecha_llegada;
	@Column(name = "total_compra")
	private int total_compra;
	@Column(name = "saldo_pendiente")
	private int saldo_pendiente;
	@Column(name = "Proveedor_id_proveedor")
	private int proveedor_id_proveedor;
	@Column(name = "status")
	private int status;

	public Compra() {

	}

	public Compra(int id_compra, String fecha_compra, String fecha_llegada, int total_compra, int saldo_pendiente,
			int proveedor_id_proveedor) {
		super();
		this.id_compra = id_compra;
		this.fecha_compra = fecha_compra;
		this.fecha_llegada = fecha_llegada;
		this.total_compra = total_compra;
		this.saldo_pendiente = saldo_pendiente;
		this.proveedor_id_proveedor = proveedor_id_proveedor;
	}

	public int getId_compra() {
		return id_compra;
	}

	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}

	public String getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(String fecha_compra) {
		this.fecha_compra = fecha_compra;
	}

	public String getFecha_llegada() {
		return fecha_llegada;
	}

	public void setFecha_llegada(String fecha_llegada) {
		this.fecha_llegada = fecha_llegada;
	}

	public int getTotal_compra() {
		return total_compra;
	}

	public void setTotal_compra(int total_compra) {
		this.total_compra = total_compra;
	}

	public int getSaldo_pendiente() {
		return saldo_pendiente;
	}

	public void setSaldo_pendiente(int saldo_pendiente) {
		this.saldo_pendiente = saldo_pendiente;
	}

	public int getProveedor_id_proveedor() {
		return proveedor_id_proveedor;
	}

	public void setProveedor_id_proveedor(int proveedor_id_proveedor) {
		this.proveedor_id_proveedor = proveedor_id_proveedor;
	}

}
