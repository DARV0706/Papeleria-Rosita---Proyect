package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;

import co.edu.unbosque.Papeleria.dto.ProductoDTO;


public interface ProductoCRUD {
	public List<ProductoDTO> listProduct();
	public ProductoDTO searchProduct(String id);
	public int deleteProduct(String id);
	public int insertProduct(ProductoDTO product);
	public int editProduct(ProductoDTO product );

}
