package co.edu.unbosque.Papeleria.dto;

import java.util.Date;

public class CompraDTO {

	private int id_compra;
	private String fecha_compra;
	private String fecha_llegada;
	private int tota_compra;
	private int proveedor_id_proveedor;
	private int status;	
	
	public CompraDTO() {
		
	}

	public CompraDTO(int id_compra, String fecha_compra, String fecha_llegada, int tota_compra,
			int proveedor_id_proveedor, int status) {
		super();
		this.id_compra = id_compra;
		this.fecha_compra = fecha_compra;
		this.fecha_llegada = fecha_llegada;
		this.tota_compra = tota_compra;
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

	public int getTota_compra() {
		return tota_compra;
	}

	public void setTota_compra(int total_compra) {
		this.tota_compra = total_compra;
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
