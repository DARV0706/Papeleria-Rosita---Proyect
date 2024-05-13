package co.edu.unbosque.Papeleria.dto;

import java.util.Date;

public class CompraDTO {

	private int id_compra;
	private String fecha_compra;
	private String fecha_llegada;
	private int total_compra;
	private int saldo_pendiente;
	private int proveedor_id_proveedor;
	private int status;	
	
	public CompraDTO() {
		
	}

	public CompraDTO(int id_compra, String fecha_compra, String fecha_llegada, int total_compra, int saldo_pendiente,
			int proveedor_id_proveedor, int status) {
		super();
		this.id_compra = id_compra;
		this.fecha_compra = fecha_compra;
		this.fecha_llegada = fecha_llegada;
		this.total_compra = total_compra;
		this.saldo_pendiente = saldo_pendiente;
		this.proveedor_id_proveedor = proveedor_id_proveedor;
		this.status = status;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
