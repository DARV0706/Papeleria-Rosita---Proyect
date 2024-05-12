package co.edu.unbosque.Papeleria.dto;



public class DetalleCompraDTO {
	
	private int id_det_compra;
	
	private int precio;
	
	private int cantidad;
	
	private String monto_total;
	
	private int saldo_pendiente;
	
	private int compra_id_compra;
	
	private String producto_id_producto;
	
	public DetalleCompraDTO() {
		
	}

	public DetalleCompraDTO(int id_det_compra, int precio, int cantidad, String monto_total, int saldo_pendiente,
			int compra_id_compra, String producto_id_producto) {
		super();
		this.id_det_compra = id_det_compra;
		this.precio = precio;
		this.cantidad = cantidad;
		this.monto_total = monto_total;
		this.saldo_pendiente = saldo_pendiente;
		this.compra_id_compra = compra_id_compra;
		this.producto_id_producto = producto_id_producto;
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

	public String getMonto_total() {
		return monto_total;
	}

	public void setMonto_total(String monto_total) {
		this.monto_total = monto_total;
	}

	public int getSaldo_pendiente() {
		return saldo_pendiente;
	}

	public void setSaldo_pendiente(int saldo_pendiente) {
		this.saldo_pendiente = saldo_pendiente;
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
