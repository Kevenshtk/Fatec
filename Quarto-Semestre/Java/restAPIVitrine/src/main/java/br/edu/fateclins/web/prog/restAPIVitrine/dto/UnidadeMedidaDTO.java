package br.edu.fateclins.web.prog.restAPIVitrine.dto;

import br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja.Produto;

import java.util.List;

public record UnidadeMedidaDTO(String descricao, String sigla, List<Produto> listaProdutos) {
}
