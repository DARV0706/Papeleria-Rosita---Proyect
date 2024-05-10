package co.edu.unbosque.Papeleria.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.Papeleria.modelo.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Long>{

}
