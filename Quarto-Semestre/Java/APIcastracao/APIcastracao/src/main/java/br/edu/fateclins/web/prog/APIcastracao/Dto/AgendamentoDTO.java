package br.edu.fateclins.web.prog.APIcastracao.Dto;

import java.util.Date;
import java.util.List;

public record AgendamentoDTO(Date dataPrevista,
                             String observacao,
                             Integer idAnimal,
                             Integer idResponsavel,
                             List<ItensManejoDTO> itens
                                ) {
}
