package co.edu.unbosque.Papeleria.modelo;

import java.io.Serializable;

public class DetalleCompraId implements Serializable {
	private int id_det_compra;
	private int compra_id_compra;
	private String producto_id_producto;
	
	public DetalleCompraId() {
		
	}

	public DetalleCompraId(int id_det_compra, int compra_id_compra, String producto_id_producto) {
		super();
		this.id_det_compra = id_det_compra;
		this.compra_id_compra = compra_id_compra;
		this.producto_id_producto = producto_id_producto;
	}

	public int getId_det_compra() {
		return id_det_compra;
	}

	public void setId_det_compra(int id_det_compra) {
		this.id_det_compra = id_det_compra;
	}

	public int getCompra_id_compra() {
		return compra_id_compra;
	}

	public void setCompra_id_compra(int compra_id_compra) {
		this.compra_id_compra = compra_id_compra;
	}

	public String getProducto_id_producto() {
		return producto_id_producto;
	}

	public void setProducto_id_producto(String producto_id_producto) {
		this.producto_id_producto = producto_id_producto;
	}

	
	
	

}
