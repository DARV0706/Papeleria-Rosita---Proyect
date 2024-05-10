package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;

import co.edu.unbosque.Papeleria.modelo.Inventario;

public interface InventarioCRUD {
	public List<Inventario> listInventory();
	public Inventario searchInventory(Long id);
	public Inventario deleteInventory(Long id);
	public Inventario insertInventory(Inventario inventory);

}
