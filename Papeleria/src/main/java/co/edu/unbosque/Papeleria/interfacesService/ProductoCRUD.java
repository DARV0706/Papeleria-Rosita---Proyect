package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;

import co.edu.unbosque.Papeleria.modelo.Producto;

public interface ProductoCRUD {
	public List<Producto> listProduct();
	public Producto searchProduct(Long id);
	public Producto deleteProduct(Long id);
	public Producto insertProduct(Producto product);

}
