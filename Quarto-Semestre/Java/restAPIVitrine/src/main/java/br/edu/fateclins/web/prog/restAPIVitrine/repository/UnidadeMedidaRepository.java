package br.edu.fateclins.web.prog.restAPIVitrine.repository;

import br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja.UnidadeMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeMedidaRepository extends JpaRepository<UnidadeMedida, Integer> {
}
