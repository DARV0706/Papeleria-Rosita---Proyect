package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;
import java.util.Optional;

import co.edu.unbosque.Papeleria.modelo.DetalleVentaId;
import co.edu.unbosque.Papeleria.modelo.DetalleVentas;

public interface DetalleVentasCRUD {
	
	public List<DetalleVentas> listSaleRep();
	public Optional<DetalleVentas> searchSaleRep(DetalleVentaId id);
	public String deleteSaleRep(DetalleVentaId id);
	public DetalleVentas insertSaleRep(DetalleVentas SaleRep);
	public DetalleVentas editSaleRep(DetalleVentas SaleRep);

}
