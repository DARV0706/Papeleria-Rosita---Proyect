package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;

import co.edu.unbosque.Papeleria.modelo.Cliente;

public interface ClienteCRUD {
	
	public List<Cliente> listCustom();
	public Cliente searchCustom(Long id);
	public String deleteCustom(Long id);
	public Cliente insertCustom(Cliente cliente);
	public Cliente editCustom(Cliente cliente);
	

}
