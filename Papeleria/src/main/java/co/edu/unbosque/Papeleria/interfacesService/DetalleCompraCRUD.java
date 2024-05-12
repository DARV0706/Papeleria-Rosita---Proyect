package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;
import java.util.Optional;

import co.edu.unbosque.Papeleria.modelo.DetalleCompra;
import co.edu.unbosque.Papeleria.modelo.DetalleVentas;

public interface DetalleCompraCRUD {
	public List<DetalleCompra> listBuyRep();
	public Optional<DetalleCompra> searchBuyRep(Long id);
	public String deleteBuyRep(Long id);
	public DetalleCompra insertBuyRep(DetalleCompra BuyRep);
	public DetalleCompra editBuyRep(DetalleCompra BuyRep);

}
