package br.edu.fateclins.web.prog.APIcastracao.Dto;

import java.util.List;

public record ManejoDTO(String nome, String descricao, List<ItensInsumoDTO> itens) {
}
