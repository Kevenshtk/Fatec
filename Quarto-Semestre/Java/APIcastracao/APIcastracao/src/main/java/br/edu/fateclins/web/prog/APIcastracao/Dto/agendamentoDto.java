package br.edu.fateclins.web.prog.APIcastracao.Dto;

import br.edu.fateclins.web.prog.APIcastracao.module.Animal;
import br.edu.fateclins.web.prog.APIcastracao.module.Responsavel;

import java.util.Date;
import java.util.List;

public record agendamentoDto(Date dataPrevista,
                             String observacao,
                             Integer idAnimal,
                             Integer idResponsavel,
                             List<ItensManejoDto> itens
                                ) {
}
