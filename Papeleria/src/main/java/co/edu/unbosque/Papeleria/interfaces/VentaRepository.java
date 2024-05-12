package co.edu.unbosque.Papeleria.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unbosque.Papeleria.modelo.DetalleVentas;
import co.edu.unbosque.Papeleria.modelo.Venta;
@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{

	@Query("SELECT c FROM Venta c WHERE c.status= 1")
	List<Venta> salesActives();
	
	@Transactional
    @Modifying
    @Query("UPDATE Venta c SET c.status = :status WHERE c.id_venta = :id")
    void deleteSales(@Param("id") Long id, @Param("status") int status);
	
	@Transactional
    @Modifying
    @Query("UPDATE Venta c SET c.status = :status WHERE c.id_venta = :id")
	void changeStatus(@Param("id") int i, @Param("status") int status);
	
	
}
