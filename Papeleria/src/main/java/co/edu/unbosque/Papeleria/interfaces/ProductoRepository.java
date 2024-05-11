package co.edu.unbosque.Papeleria.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unbosque.Papeleria.modelo.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {
	
	@Transactional
    @Modifying
    @Query("UPDATE Producto p SET p.status = :status WHERE p.id_producto = :id")
    void deleteProduct(@Param("id") String id, @Param("status") int estado);
	
	@Query("SELECT p FROM Producto p  WHERE p.status = 1")
	List<Producto> productsActives();
}
