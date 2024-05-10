package co.edu.unbosque.Papeleria.dao;

import java.util.List;

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
		return null;
	}

	@Override
	public Proveedor searchProvider(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProvider(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proveedor insertProvider(Proveedor prov) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proveedor editProvider(Proveedor prov) {
		// TODO Auto-generated method stub
		return null;
	}

}
