package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;

import co.edu.unbosque.Papeleria.dto.ClienteDTO;


public interface ClienteCRUD {
	
	public List<ClienteDTO> listCustom();
	public ClienteDTO searchCustom(int id);
	public int deleteCustom(int id);
	public int insertCustom(ClienteDTO cliente);
	public int editCustom(ClienteDTO cliente);
	public List<ClienteDTO> listDeletedCustom();
	

}
