package co.edu.unbosque.Papeleria.modelo;

import java.io.Serializable;

public class DetalleVentaId implements Serializable{

	
	private int id_det_venta;
	private int venta_id_venta;
	private String producto_id_producto;
	
	public DetalleVentaId() {
		
	}

	public DetalleVentaId(int id_det_venta, int venta_id_venta, String producto_id_producto) {
		super();
		this.id_det_venta = id_det_venta;
		this.venta_id_venta = venta_id_venta;
		this.producto_id_producto = producto_id_producto;
	}

	public int getId_det_venta() {
		return id_det_venta;
	}

	public void setId_det_venta(int id_det_venta) {
		this.id_det_venta = id_det_venta;
	}

	public int getVenta_id_venta() {
		return venta_id_venta;
	}

	public void setVenta_id_venta(int venta_id_venta) {
		this.venta_id_venta = venta_id_venta;
	}

	public String getProducto_id_producto() {
		return producto_id_producto;
	}

	public void setProducto_id_producto(String producto_id_producto) {
		this.producto_id_producto = producto_id_producto;
	}
	
	
}
