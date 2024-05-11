package co.edu.unbosque.Papeleria.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.Papeleria.interfaces.DetalleVentasRepository;
import co.edu.unbosque.Papeleria.interfacesService.DetalleVentasCRUD;
import co.edu.unbosque.Papeleria.modelo.DetalleVentas;

@Service
public class DetalleVentasDAO implements DetalleVentasCRUD{

	@Autowired
	private DetalleVentasRepository saleRepRepo;
	
	@Override
	public List<DetalleVentas> listSaleRep() {
		// TODO Auto-generated method stub
		return saleRepRepo.saleReportActives();
	}

	@Override
	public Optional<DetalleVentas> searchSaleRep(Long id) {
		// TODO Auto-generated method stub
		return saleRepRepo.findById(id);
	}

	@Override
	public String deleteSaleRep(Long id) {
		// TODO Auto-generated method stub
		int status = 0;
		saleRepRepo.deleteSalesReport(id, status);
		return "ELIMINACION EXITOSA";
	}

	@Override
	public DetalleVentas insertSaleRep(DetalleVentas SaleRep) {
		// TODO Auto-generated method stub
		return saleRepRepo.save(SaleRep);
	}

	@Override
	public DetalleVentas editSaleRep(DetalleVentas SaleRep) {
		// TODO Auto-generated method stub
		DetalleVentas aux = saleRepRepo.findById((long) SaleRep.getId_det_venta()).orElse(null);
		aux.getId_det_venta();
		aux.setPrecio(SaleRep.getPrecio());
		aux.setCantidad(SaleRep.getCantidad());
		aux.setMonto_total(SaleRep.getMonto_total());
		aux.setVenta_id_venta(SaleRep.getVenta_id_venta());
		aux.setSaldo_pendiente(SaleRep.getSaldo_pendiente());
		aux.setProducto_id_producto(SaleRep.getProducto_id_producto());
		
		return saleRepRepo.save(aux);
	}

}
