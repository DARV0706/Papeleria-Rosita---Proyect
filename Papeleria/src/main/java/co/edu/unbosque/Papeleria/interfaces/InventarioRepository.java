package co.edu.unbosque.Papeleria.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.Papeleria.modelo.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, String>{

}
