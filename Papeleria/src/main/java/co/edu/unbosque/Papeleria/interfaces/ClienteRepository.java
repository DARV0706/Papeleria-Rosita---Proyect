package co.edu.unbosque.Papeleria.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unbosque.Papeleria.modelo.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query("SELECT c FROM Cliente c WHERE c.status= 1")
	List<Cliente> customsActives();
	
	@Transactional
    @Modifying
    @Query("UPDATE Cliente c SET c.status = :status WHERE c.id_cliente = :id")
    void deleteCustom(@Param("id") Long id, @Param("status") int status);
	


}
