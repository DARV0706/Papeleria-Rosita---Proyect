package co.edu.unbosque.Papeleria.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unbosque.Papeleria.interfaces.ProveedorRepository;
import co.edu.unbosque.Papeleria.interfacesService.ProveedorCRUD;
import co.edu.unbosque.Papeleria.modelo.Proveedor;

public class ProveedorDAO implements ProveedorCRUD {
	
	@Autowired
	ProveedorRepository provRepo;

	@Override
	public List<Proveedor> listProvider() {
		// TODO Auto-generated method stub
		return provRepo.providerActives();
	}

	@Override
	public Optional<Proveedor> searchProvider(Long id) {
		// TODO Auto-generated method stub
		return provRepo.findById(id);
	}

	@Override
	public String deleteProvider(Long id) {
		// TODO Auto-generated method stub
		String aux = "Eliminado";
		provRepo.deleteProvider(id, 0);
		return aux;
	}

	@Override
	public Proveedor insertProvider(Proveedor prov) {
		// TODO Auto-generated method stub
		return provRepo.save(prov); 

	}

	@Override
	public Proveedor editProvider(Proveedor prov) {
		Proveedor provider = provRepo.findById((long) prov.getId_proveedor()).orElse(null);
		provider.getId_proveedor();
		provider.setTipo_identificacion(prov.getTipo_identificacion());
		provider.setRazon_social(prov.getRazon_social());
		provider.setTelefono(prov.getTelefono());
		provider.setDireccion(prov.getDireccion());
		provider.setSaldo_pendiente(prov.getSaldo_pendiente());
		return provRepo.save(provider);
	}


}
