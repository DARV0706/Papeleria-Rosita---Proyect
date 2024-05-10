package co.edu.unbosque.Papeleria.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.Papeleria.modelo.Venta;
@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{

}
