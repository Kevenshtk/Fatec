package br.edu.fateclins.web.prog.APIcastracao.repository;

import br.edu.fateclins.web.prog.APIcastracao.module.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface agendamentoRepository extends JpaRepository<Agendamento, Integer> {
}
