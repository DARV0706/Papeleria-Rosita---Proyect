package co.edu.unbosque.Papeleria.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Papeleria.interfaces.InventarioRepository;
import co.edu.unbosque.Papeleria.interfacesService.InventarioCRUD;
import co.edu.unbosque.Papeleria.modelo.Inventario;

@Service
public class InventarioDAO implements InventarioCRUD {

	@Autowired
	private InventarioRepository inventoryRepo;

	@Override
	public List<Inventario> listInventory() {
		// TODO Auto-generated method stub
		return inventoryRepo.findAll();
	}

	@Override
	public Optional<Inventario> searchInventory(String id) {
		// TODO Auto-generated method stub
		return inventoryRepo.findById(id);
	}

	@Override
	public String deleteInventory(String id) {
		// TODO Auto-generated method stub
		inventoryRepo.deleteById(id);
		return "ELIMINACION EXITOSA";
	}

	@Override
	public Inventario insertInventory(Inventario inventory) {
		// TODO Auto-generated method stub
		return inventoryRepo.save(inventory);
	}

	@Override
	public Inventario editInventory(Inventario inventory) {
		// TODO Auto-generated method stub
		Inventario aux = inventoryRepo.findById(inventory.getId_inventario()).orElse(null);
		aux.getId_inventario();
		aux.setDescripcion(inventory.getDescripcion());
		aux.setCantidad(inventory.getCantidad());
		aux.setProducto_id_producto(inventory.getProducto_id_producto());

		return inventoryRepo.save(aux);
	}

}
