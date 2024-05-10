package co.edu.unbosque.Papeleria.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Producto")
public class Producto {
	@Id
	private String id_producto;
	@Column(name = "nombre_producto")
	private String nombre_producto;
	@Column(name = "iva")
	private int iva;
	@Column(name = "costo_unitario")
	private int costo_unitario;
	@Column(name = "costo_total")
	private int costo_total;
	@Column(name = "Categoria_id_categoria")
	private String categoria_id_categoria;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "status")
	private String status;
	
	public void Producto() {
		
	}

	public Producto(String id_producto, String nombre_producto, int iva, int costo_unitario, int costo_total,
			String categoria_id_categoria, String descripcion, String status) {
		super();
		this.id_producto = id_producto;
		this.nombre_producto = nombre_producto;
		this.iva = iva;
		this.costo_unitario = costo_unitario;
		this.costo_total = costo_total;
		this.categoria_id_categoria = categoria_id_categoria;
		this.descripcion = descripcion;
		this.status = status;
	}

	public String getId_producto() {
		return id_producto;
	}

	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public int getCosto_unitario() {
		return costo_unitario;
	}

	public void setCosto_unitario(int costo_unitario) {
		this.costo_unitario = costo_unitario;
	}

	public int getCosto_total() {
		return costo_total;
	}

	public void setCosto_total(int costo_total) {
		this.costo_total = costo_total;
	}

	public String getCategoria_id_categoria() {
		return categoria_id_categoria;
	}

	public void setCategoria_id_categoria(String categoria_id_categoria) {
		this.categoria_id_categoria = categoria_id_categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
