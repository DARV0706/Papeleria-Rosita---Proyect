package co.edu.unbosque.Papeleria.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unbosque.Papeleria.modelo.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer>{

	@Query("SELECT c FROM Compra c WHERE c.status= 1")
	List<Compra> buyActives();
	
	@Transactional
    @Modifying
    @Query("UPDATE Compra c SET c.status = :status WHERE c.id_compra = :id")
    void deleteBuy(@Param("id") Long id, @Param("status") int status);
	


}
