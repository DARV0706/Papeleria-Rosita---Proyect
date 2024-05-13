package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;
import java.util.Optional;

import co.edu.unbosque.Papeleria.dto.CompraDTO;

public interface CompraCRUD <clase>{

	public List<clase> listBuy();
	public clase searchBuy(int id);
	public int deleteBuy(int id);
	public int insertBuy(clase compraDTO);
	public int editBuy(clase compraDTO);
	public int changeStatus(clase compraDTO);
}
