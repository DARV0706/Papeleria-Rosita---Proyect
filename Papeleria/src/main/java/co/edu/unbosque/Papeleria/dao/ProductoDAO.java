package co.edu.unbosque.Papeleria.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Papeleria.interfaces.ProductoRepository;
import co.edu.unbosque.Papeleria.interfacesService.ProductoCRUD;
import co.edu.unbosque.Papeleria.modelo.Producto;

@Service
public class ProductoDAO implements ProductoCRUD{
	
	@Autowired
	private ProductoRepository productRepo;

	@Override
	public List<Producto> listProduct() {
		// TODO Auto-generated method stub
		return productRepo.productsActives();
	}



	@Override
	public String deleteProduct(String id) {
		// TODO Auto-generated method stub
		String aux = "Eliminado";
		productRepo.deleteProduct(id, 0);
		return aux;
	}

	@Override
	public Producto insertProduct(Producto product) {
		// TODO Auto-generated method stub
		Producto prod = productRepo.save(product);
		productRepo.changeStatus(product.getId_producto(), 1);
		return prod;
	}

	@Override
	public Optional<Producto> searchProduct(String id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id);
	}



	@Override
	public Producto editProduct(Producto product) {
		// TODO Auto-generated method stub
		Producto prod = productRepo.findById(product.getId_producto()).orElse(null);
		prod.getId_producto();
		prod.setNombre_producto(product.getNombre_producto());
		prod.getIva(); // El usuario no calculará el IVA, lo hará la BD
		prod.setCosto_unitario(product.getCosto_unitario());
		prod.getCosto_total(); // Lo calcula la BD
		prod.setDescripcion(product.getDescripcion());
		return productRepo.save(prod);
	}



}
