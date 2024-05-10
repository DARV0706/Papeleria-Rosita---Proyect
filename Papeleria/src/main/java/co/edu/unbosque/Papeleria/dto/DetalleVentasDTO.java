package co.edu.unbosque.Papeleria.dto;

public class DetalleVentasDTO {
	private int id_det_venta;
	private int precio;
	private int cantidad;
	private int monto_total;
	private int venta_id_venta;
	private int saldo_pendiente;
	private String producto_id_producto;
	
	public void DetalleVentasDTO() {
		
	}

	public DetalleVentasDTO(int id_det_venta, int precio, int cantidad, int monto_total, int venta_id_venta,
			int saldo_pendiente, String producto_id_producto) {
		super();
		this.id_det_venta = id_det_venta;
		this.precio = precio;
		this.cantidad = cantidad;
		this.monto_total = monto_total;
		this.venta_id_venta = venta_id_venta;
		this.saldo_pendiente = saldo_pendiente;
		this.producto_id_producto = producto_id_producto;
	}

	public int getId_det_venta() {
		return id_det_venta;
	}

	public void setId_det_venta(int id_det_venta) {
		this.id_det_venta = id_det_venta;
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

	public int getVenta_id_venta() {
		return venta_id_venta;
	}

	public void setVenta_id_venta(int venta_id_venta) {
		this.venta_id_venta = venta_id_venta;
	}

	public int getSaldo_pendiente() {
		return saldo_pendiente;
	}

	public void setSaldo_pendiente(int saldo_pendiente) {
		this.saldo_pendiente = saldo_pendiente;
	}

	public String getProducto_id_producto() {
		return producto_id_producto;
	}

	public void setProducto_id_producto(String producto_id_producto) {
		this.producto_id_producto = producto_id_producto;
	}
}
