package co.edu.unbosque.Papeleria.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.Papeleria.modelo.DetalleVentas;

@Repository
public interface DetalleVentasRepository extends JpaRepository<DetalleVentas, Long>{

}
