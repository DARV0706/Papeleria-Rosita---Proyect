package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;
import java.util.Optional;

import co.edu.unbosque.Papeleria.modelo.Proveedor;

public interface ProveedorCRUD {
	public List<Proveedor> listProvider();
	public Optional<Proveedor> searchProvider(int id);
	public String deleteProvider(Long id);
	public Proveedor insertProvider(Proveedor prov);
	public Proveedor editProvider(Proveedor prov);

}
