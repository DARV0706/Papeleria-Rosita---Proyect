package co.edu.unbosque.Papeleria.dto;

public class VentaDTO {
	private int id_venta;
	private String fecha_venta;
	private int totalizado;
	private int saldo;
	private int cliente_id_cliente;
	private int status;
	
	public void VentaDTO() {
		
	}

	public VentaDTO(int id_venta, String fecha_venta, int totalizado, int saldo, int cliente_id_cliente) {
		super();
		this.id_venta = id_venta;
		this.fecha_venta = fecha_venta;
		this.totalizado = totalizado;
		this.saldo = saldo;
		this.cliente_id_cliente = cliente_id_cliente;
	}

	public int getId_venta() {
		return id_venta;
	}

	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}

	public String getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(String fecha_venta) {
		this.fecha_venta = fecha_venta;
	}

	public int getTotalizado() {
		return totalizado;
	}

	public void setTotalizado(int totalizado) {
		this.totalizado = totalizado;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public int getCliente_id_cliente() {
		return cliente_id_cliente;
	}

	public void setCliente_id_cliente(int cliente_id_cliente) {
		this.cliente_id_cliente = cliente_id_cliente;
	}

	
}
