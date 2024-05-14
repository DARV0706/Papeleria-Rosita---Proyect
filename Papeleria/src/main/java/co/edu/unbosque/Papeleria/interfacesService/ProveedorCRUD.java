package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;

public interface ProveedorCRUD <clase>{
	public List<clase> listProvider();
	public clase searchProvider(int id);
	public int deleteProvider(int id);
	public int insertProvider(clase provider);
	public int editProvider(clase provider);
}