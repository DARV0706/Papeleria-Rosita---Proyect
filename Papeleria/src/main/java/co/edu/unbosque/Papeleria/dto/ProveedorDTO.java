package co.edu.unbosque.Papeleria.dto;

public class ProveedorDTO {

	private int id_proveedor;
	private String tipo_identificacion;
	private String razon_social;
	private int telefono;
	private String direccion;
	private int saldo_pendiente;
	private int status;
	
	public ProveedorDTO() {
		
	}

	public ProveedorDTO(int id_proveedor, String tipo_identificacion, String razon_social, int telefono, String direccion,
			int saldo_pendiente, int status) {
		super();
		this.id_proveedor = id_proveedor;
		this.tipo_identificacion = tipo_identificacion;
		this.razon_social = razon_social;
		this.telefono = telefono;
		this.direccion = direccion;
		this.saldo_pendiente = saldo_pendiente;
		this.status = status;
	}

	public int getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getTipo_identificacion() {
		return tipo_identificacion;
	}

	public void setTipo_identificacion(String tipo_identificacion) {
		this.tipo_identificacion = tipo_identificacion;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getSaldo_pendiente() {
		return saldo_pendiente;
	}

	public void setSaldo_pendiente(int saldo_pendiente) {
		this.saldo_pendiente = saldo_pendiente;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
