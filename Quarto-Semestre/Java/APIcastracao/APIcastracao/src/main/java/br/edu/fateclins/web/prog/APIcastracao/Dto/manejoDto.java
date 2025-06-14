package br.edu.fateclins.web.prog.APIcastracao.Dto;

import java.util.List;

public record manejoDto(String nome, String descricao, List<ItensInsumoDto> itens) {
}
