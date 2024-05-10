package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;

import co.edu.unbosque.Papeleria.modelo.Proveedor;

public interface ProveedorCRUD {
	public List<Proveedor> listProvider();
	public Proveedor searchProvider(Long id);
	public String deleteProvider(Long id);
	public Proveedor insertProvider(Proveedor prov);
	public Proveedor editProvider(Proveedor prov);

}
