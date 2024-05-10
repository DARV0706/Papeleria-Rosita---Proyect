package co.edu.unbosque.Papeleria.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.Papeleria.modelo.Proveedor;
@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{

}
