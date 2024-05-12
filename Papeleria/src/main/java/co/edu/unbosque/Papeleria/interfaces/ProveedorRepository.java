package co.edu.unbosque.Papeleria.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unbosque.Papeleria.modelo.Proveedor;
@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{
	@Query("SELECT p FROM Proveedor p  WHERE p.status = 1")
	List<Proveedor> providerActives();
	
	@Transactional
    @Modifying
    @Query("UPDATE Proveedor p SET p.status = :status WHERE p.id_proveedor = :id")
    void deleteProvider(@Param("id") Long id, @Param("status") int status);
	
	@Query("SELECT p FROM Proveedor p  WHERE p.status = 0")
	List<Proveedor> providersDeleted();
	
	@Transactional
    @Modifying
    @Query("UPDATE Proveedor c SET c.status = :status WHERE c.id_proveedor = :id")
	void changeStatus(@Param("id") int i, @Param("status") int status);

}
