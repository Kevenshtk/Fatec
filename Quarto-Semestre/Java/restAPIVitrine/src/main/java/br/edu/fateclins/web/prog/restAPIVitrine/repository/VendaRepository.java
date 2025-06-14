package br.edu.fateclins.web.prog.restAPIVitrine.repository;

import br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {
}
