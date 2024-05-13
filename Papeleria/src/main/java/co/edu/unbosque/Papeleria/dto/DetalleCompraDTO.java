package co.edu.unbosque.Papeleria.dto;



public class DetalleCompraDTO {
	
	private int id_det_compra;
	
	private int precio;
	
	private int cantidad;
	
	private int monto_total;
		
	private int compra_id_compra;
	
	private String producto_id_producto;
	
	private int status;
	
	public DetalleCompraDTO() {
		
	}

	public DetalleCompraDTO(int id_det_compra, int precio, int cantidad, int monto_total, 
			int compra_id_compra, String producto_id_producto, int status) {
		super();
		this.id_det_compra = id_det_compra;
		this.precio = precio;
		this.cantidad = cantidad;
		this.monto_total = monto_total;
		this.compra_id_compra = compra_id_compra;
		this.producto_id_producto = producto_id_producto;
		this.setStatus(status);
	}

	public int getId_det_compra() {
		return id_det_compra;
	}

	public void setId_det_compra(int id_det_compra) {
		this.id_det_compra = id_det_compra;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getMonto_total() {
		return monto_total;
	}

	public void setMonto_total(int monto_total) {
		this.monto_total = monto_total;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
