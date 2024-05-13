package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;
import java.util.Optional;

public interface DetalleCompraCRUD<clase> {
	public List<clase> listBuyRep();
	public clase searchBuyRep(int id, int id2, String id3);
	public int deleteBuyRep(int id, int id2, String id3);
	public int insertBuyRep(clase BuyRep);
	public int editBuyRep(clase BuyRep);

}
