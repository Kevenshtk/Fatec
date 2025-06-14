package br.edu.fateclins.web.prog.restAPIVitrine.repository;

import br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
