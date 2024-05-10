package co.edu.unbosque.Papeleria.modelo;

public class Inventario {
	private String id_inventario;
	private String descripcion;
	private int cantidad;
	private String producto_id_producto;
	
	public void Inventario() {
		
	}

	public Inventario(String id_inventario, String descripcion, int cantidad, String producto_id_producto) {
		super();
		this.id_inventario = id_inventario;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.producto_id_producto = producto_id_producto;
	}

	public String getId_inventario() {
		return id_inventario;
	}

	public void setId_inventario(String id_inventario) {
		this.id_inventario = id_inventario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getProducto_id_producto() {
		return producto_id_producto;
	}

	public void setProducto_id_producto(String producto_id_producto) {
		this.producto_id_producto = producto_id_producto;
	}
	
}
