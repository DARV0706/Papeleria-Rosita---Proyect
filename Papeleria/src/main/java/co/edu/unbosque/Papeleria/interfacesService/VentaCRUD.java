package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;
import java.util.Optional;

import co.edu.unbosque.Papeleria.modelo.Venta;

public interface VentaCRUD {
	public List<Venta> listSale();
	public Optional<Venta> searchSale(Long id);
	public String deleteSale(Long id);
	public Venta insertSale(Venta sale);
	public Venta editSale(Venta sale);

}
