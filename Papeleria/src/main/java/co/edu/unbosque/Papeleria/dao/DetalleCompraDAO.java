package co.edu.unbosque.Papeleria.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Papeleria.interfaces.DetalleCompraRepository;
import co.edu.unbosque.Papeleria.interfacesService.DetalleCompraCRUD;
import co.edu.unbosque.Papeleria.modelo.DetalleCompra;

@Service
public class DetalleCompraDAO implements DetalleCompraCRUD{
	
	@Autowired 
	private DetalleCompraRepository buyRepo; 
	
	@Override
	public List<DetalleCompra> listBuyRep() {
		// TODO Auto-generated method stub
		return buyRepo.findAll();
	}

	@Override
	public Optional<DetalleCompra> searchBuyRep(Long id) {
		// TODO Auto-generated method stub
		return buyRepo.findById(id);
	}

	@Override
	public String deleteBuyRep(Long id) {
		// TODO Auto-generated method stub
		buyRepo.deleteById(id);
		return "Eliminacion realizada";
	}

	@Override
	public DetalleCompra insertBuyRep(DetalleCompra BuyRep) {
		// TODO Auto-generated method stub
		
		return buyRepo.save(BuyRep);
	}

	@Override
	public DetalleCompra editBuyRep(DetalleCompra BuyRep) {
		// TODO Auto-generated method stub
		DetalleCompra aux = buyRepo.findById((long) BuyRep.getId_det_compra()).orElse(null);
		aux.getId_det_compra();
		aux.setPrecio(BuyRep.getPrecio());
		aux.setCantidad(BuyRep.getCantidad());
		aux.setMonto_total(BuyRep.getMonto_total());
		aux.setSaldo_pendiente(BuyRep.getSaldo_pendiente());
		aux.setCompra_id_compra(BuyRep.getCompra_id_compra());
		aux.setProducto_id_producto(BuyRep.getProducto_id_producto());
		
		return buyRepo.save(aux);
	}
	

}