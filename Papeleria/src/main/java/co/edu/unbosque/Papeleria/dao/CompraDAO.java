package co.edu.unbosque.Papeleria.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Papeleria.interfaces.CompraRepository;
import co.edu.unbosque.Papeleria.interfacesService.CompraCRUD;
import co.edu.unbosque.Papeleria.modelo.Cliente;
import co.edu.unbosque.Papeleria.modelo.Compra;

@Service
public class CompraDAO implements CompraCRUD{

	@Autowired
	private CompraRepository buyRepo;
	
	@Override
	public List<Compra> listBuy() {
		// TODO Auto-generated method stub
		return buyRepo.buyActives();
	}

	@Override
	public Optional<Compra> searchBuy(Long id) {
		// TODO Auto-generated method stub
		return buyRepo.findById(id);
	}

	@Override
	public String deleteBuy(Long id) {
		// TODO Auto-generated method stub
		int status = 0;
		buyRepo.deleteBuy(id, status);
		return "ELIMINACION EXITOSA";
	}

	@Override
	public Compra insertBuy(Compra compra) {
		// TODO Auto-generated method stub
		Compra aux = buyRepo.save(compra);
		buyRepo.changeStatus(compra.getId_compra(), 1);
		return aux;
	}

	@Override
	public Compra editBuy(Compra compra) {
		// TODO Auto-generated method stub
		Compra aux = buyRepo.findById((long) compra.getId_compra()).orElse(null);
		aux.getId_compra();
		aux.setFecha_compra(compra.getFecha_compra());
		aux.setFecha_llegada(compra.getFecha_llegada());
		aux.setTotal_compra(compra.getTotal_compra());
		aux.setSaldo_pendiente(compra.getSaldo_pendiente());
		aux.setProveedor_id_proveedor(compra.getProveedor_id_proveedor());
		return buyRepo.save(aux);
	}

}
