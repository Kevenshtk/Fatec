package br.edu.fateclins.web.prog.restAPIVitrine.repository;

import br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja.ItensVendidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensVendidosRepository extends JpaRepository<ItensVendidos, Integer> {
}
