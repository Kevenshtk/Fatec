package br.edu.fateclins.web.prog.restAPIVitrine.repository;

import br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Integer> {
}
