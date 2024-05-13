package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;
import java.util.Optional;

import co.edu.unbosque.Papeleria.modelo.DetalleCompra;
import co.edu.unbosque.Papeleria.modelo.DetalleCompraId;

public interface DetalleCompraCRUD {
	public List<DetalleCompra> listBuyRep();
	public Optional<DetalleCompra> searchBuyRep(DetalleCompraId id);
	public String deleteBuyRep(DetalleCompraId id);
	public DetalleCompra insertBuyRep(DetalleCompra BuyRep);
	public DetalleCompra editBuyRep(DetalleCompra BuyRep);

}
