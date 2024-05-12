package co.edu.unbosque.Papeleria.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unbosque.Papeleria.modelo.DetalleVentaId;
import co.edu.unbosque.Papeleria.modelo.DetalleVentas;

@Repository
public interface DetalleVentasRepository extends JpaRepository<DetalleVentas, DetalleVentaId>{

	@Query("SELECT c FROM DetalleVentas c WHERE c.status= 1")
	List<DetalleVentas> saleReportActives();
	
//	@Transactional
//    @Modifying
//    @Query("UPDATE DetalleVentas c SET c.status = :status WHERE c.id_det_venta = :id.id_det_venta AND c.venta_id_venta = id.venta_id_venta AND c.producto_id_producto = id.producto_id_producto")
//    void deleteSalesReport(@Param("id") DetalleVentaId id, @Param("status") int status);
//	
//	@Transactional
//    @Modifying
//    @Query("UPDATE DetalleVentas c SET c.status = :status WHERE c.id_det_venta = :id.id_det_venta AND c.venta_id_venta = id.venta_id_venta AND c.producto_id_producto = id.producto_id_producto")
//	void changeStatus(@Param("id") DetalleVentaId id, @Param("status") int status);
//	

}
