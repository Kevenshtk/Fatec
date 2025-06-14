package br.edu.fateclins.web.prog.APIcastracao.repository;

import br.edu.fateclins.web.prog.APIcastracao.module.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface insumoRepository extends JpaRepository<Insumo, Integer> {
}
