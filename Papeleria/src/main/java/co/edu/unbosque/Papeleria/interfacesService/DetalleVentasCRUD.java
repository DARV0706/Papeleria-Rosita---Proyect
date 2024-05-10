package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;

import co.edu.unbosque.Papeleria.modelo.DetalleVentas;

public interface DetalleVentasCRUD {
	
	public List<DetalleVentas> listSaleRep();
	public DetalleVentas searchSaleRep(Long id);
	public DetalleVentas deleteSaleRep(Long id);
	public DetalleVentas insertSaleRep(DetalleVentas SaleRep);

}
