package co.edu.unbosque.Papeleria.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DetalleVentas")
public class DetalleVentas {
	@Id
	private int id_det_venta;
	@Column(name = "precio")
	private int precio;
	@Column(name = "cantidad")
	private int cantidad;
	@Column(name = "monto_total")
	private int monto_total;
	@Column(name = "Venta_id_venta")
	private int venta_id_venta;
	@Column(name = "saldo_pendiente")
	private int saldo_pendiente;
	@Column(name = "Producto_id_producto")
	private String producto_id_producto;
	@Column(name = "status")
	private int status;
	
	public  DetalleVentas() {
		
	}

	public DetalleVentas(int id_det_venta, int precio, int cantidad, int monto_total, int venta_id_venta,
			int saldo_pendiente, String producto_id_producto, int status) {
		super();
		this.id_det_venta = id_det_venta;
		this.precio = precio;
		this.cantidad = cantidad;
		this.monto_total = monto_total;
		this.venta_id_venta = venta_id_venta;
		this.saldo_pendiente = saldo_pendiente;
		this.producto_id_producto = producto_id_producto;
		this.status = status;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}



	
}
