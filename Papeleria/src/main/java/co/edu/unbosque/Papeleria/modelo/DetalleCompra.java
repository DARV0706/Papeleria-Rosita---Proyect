package co.edu.unbosque.Papeleria.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="detalle_compra")
@IdClass(DetalleCompraId.class)
public class DetalleCompra {
	@Id
	private int id_det_compra;

	@Column(name="precio")
	private int precio;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="monto_total")
	private String monto_total;
	
	@Column(name="saldo_pendiente")
	private int saldo_pendiente;
	
	@Id
	@Column(name="Compra_id_compra")
	private int compra_id_compra;
	
	@Id
	@Column(name="Producto_id_producto")
	private String producto_id_producto;
	
	public DetalleCompra() {
		
	}

	public DetalleCompra(int id_det_compra, int precio, int cantidad, String monto_total, int saldo_pendiente,
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
