package co.edu.unbosque.Papeleria.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unbosque.Papeleria.modelo.DetalleVentas;

@Repository
public interface DetalleVentasRepository extends JpaRepository<DetalleVentas, Long>{

	@Query("SELECT c FROM detalle_venta c WHERE c.status= 1")
	List<DetalleVentas> saleReportActives();
	
	@Transactional
    @Modifying
    @Query("UPDATE detalle_venta c SET c.status = :status WHERE c.id_det_venta = :id")
    void deleteSalesReport(@Param("id") Long id, @Param("status") int status);
	


}
