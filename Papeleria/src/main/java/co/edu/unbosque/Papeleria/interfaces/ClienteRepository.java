package co.edu.unbosque.Papeleria.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.Papeleria.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
