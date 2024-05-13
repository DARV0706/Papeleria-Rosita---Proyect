package co.edu.unbosque.Papeleria.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.Papeleria.modelo.DetalleCompra;
import co.edu.unbosque.Papeleria.modelo.DetalleCompraId;

@Repository
public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, DetalleCompraId> {
	

}
