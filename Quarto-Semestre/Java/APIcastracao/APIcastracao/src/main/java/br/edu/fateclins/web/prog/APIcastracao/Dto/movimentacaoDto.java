package br.edu.fateclins.web.prog.APIcastracao.Dto;

import br.edu.fateclins.web.prog.APIcastracao.module.Insumo;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record movimentacaoDto(Date data,
                              double qdte,
                              String tipoES,
                              int insumo) {
}
