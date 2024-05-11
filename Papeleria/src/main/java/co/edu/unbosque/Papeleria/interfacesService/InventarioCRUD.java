package co.edu.unbosque.Papeleria.interfacesService;

import java.util.List;
import java.util.Optional;


import co.edu.unbosque.Papeleria.modelo.Inventario;

public interface InventarioCRUD {
	public List<Inventario> listInventory();
	public Optional<Inventario> searchInventory(String id);
	public String deleteInventory(String id);
	public Inventario insertInventory(Inventario inventory);
	public Inventario editInventory(Inventario inventory);

}
