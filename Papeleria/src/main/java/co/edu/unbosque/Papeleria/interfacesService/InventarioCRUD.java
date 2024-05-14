package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;

public interface InventarioCRUD <clase> {
	public List<clase> listInventory();
	public clase searchInventory(String id);
	public int deleteInventory(String id);
	public int insertInventory(clase inventory);
	public int editInventory(clase inventory);
}