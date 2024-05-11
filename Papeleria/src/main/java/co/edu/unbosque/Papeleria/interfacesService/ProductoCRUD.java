package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;
import java.util.Optional;

import co.edu.unbosque.Papeleria.modelo.Producto;

public interface ProductoCRUD {
	public List<Producto> listProduct();
	public Optional<Producto> searchProduct(String id);
	public String deleteProduct(String id);
	public Producto insertProduct(Producto product);
	public Producto editProduct(Producto product );

}
