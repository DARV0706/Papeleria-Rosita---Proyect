package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;

import co.edu.unbosque.Papeleria.modelo.Producto;
import co.edu.unbosque.Papeleria.modelo.Venta;

public interface VentaCRUD {
	public List<Venta> listSale();
	public Venta search_sale(Long id);
	public Venta deleteSale(Long id);
	public Venta insertSale(Venta sale);


}
