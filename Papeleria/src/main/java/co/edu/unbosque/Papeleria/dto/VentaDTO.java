package co.edu.unbosque.Papeleria.dto;

public class VentaDTO {
	private int id_venta;
	private int id_cliente;
	private int id_producto;
	private double total;
	private double cambio;
	
	public void VentaDTO() {
		
	}

	public VentaDTO(int id_venta, int id_cliente, int id_producto, double total, double cambio) {
		super();
		this.id_venta = id_venta;
		this.id_cliente = id_cliente;
		this.id_producto = id_producto;
		this.total = total;
		this.cambio = cambio;
	}

	public int getId_venta() {
		return id_venta;
	}

	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getCambio() {
		return cambio;
	}

	public void setCambio(double cambio) {
		this.cambio = cambio;
	}
	
}
