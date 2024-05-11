package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;
import java.util.Optional;

import co.edu.unbosque.Papeleria.modelo.Compra;

public interface CompraCRUD {

	public List<Compra> listBuy();
	public Optional<Compra> searchBuy(Long id);
	public String deleteBuy(Long id);
	public Compra insertBuy(Compra compra);
	public Compra editBuy(Compra compra);
}
