package br.edu.fateclins.web.prog.APIcastracao.Dto;

import java.util.Date;

public record MovimentacaoDTO(Date data,
                              double qdte,
                              String tipoES,
                              int insumo) {
}
