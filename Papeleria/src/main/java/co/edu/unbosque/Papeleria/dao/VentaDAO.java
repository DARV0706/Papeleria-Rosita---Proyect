package co.edu.unbosque.Papeleria.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unbosque.Papeleria.interfacesService.VentaCRUD;

@Service
public class VentaDAO implements VentaCRUD {
//
//	@Autowired
//	private VentaRepository salesRepo;
//
//	@Override
//	public List<Venta> listSale() {
//		// TODO Auto-generated method stub
//		return salesRepo.salesActives();
//	}
//
//	@Override
//	public Optional<Venta> searchSale(int id) {
//		// TODO Auto-generated method stub
//		return salesRepo.findById(id);
//	}
//
//	@Override
//	public String deleteSale(Long id) {
//		// TODO Auto-generated method stub
//		int status = 0;
//		salesRepo.deleteSales(id, status);
//		return "ELIMINACION EXITOSA";
//	}
//
//	@Override
//	public Venta insertSale(Venta sale) {
//		// TODO Auto-generated method stub
//		Venta aux = salesRepo.save(sale);
//		salesRepo.changeStatus(sale.getId_venta(), 1);
//		return aux;
//	}
//
//	@Override
//	public Venta editSale(Venta sale) {
//		// TODO Auto-generated method stub
//		Venta aux = salesRepo.findById( sale.getId_venta()).orElse(null);
//		aux.getId_venta();
//		aux.setFecha_venta(sale.getFecha_venta());
//		aux.setTotalizado(sale.getTotalizado());
//		aux.setSaldo(sale.getSaldo());
//		aux.setCliente_id_cliente(sale.getCliente_id_cliente());
//
//		return salesRepo.save(aux);
//	}

}
