package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;
import java.util.Optional;

import co.edu.unbosque.Papeleria.modelo.DetalleVentas;

public interface DetalleVentasCRUD {
	
	public List<DetalleVentas> listSaleRep();
	public Optional<DetalleVentas> searchSaleRep(Long id);
	public String deleteSaleRep(Long id);
	public DetalleVentas insertSaleRep(DetalleVentas SaleRep);
	public DetalleVentas editSaleRep(DetalleVentas SaleRep);

}
