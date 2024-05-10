package co.edu.unbosque.Papeleria.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.Papeleria.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
