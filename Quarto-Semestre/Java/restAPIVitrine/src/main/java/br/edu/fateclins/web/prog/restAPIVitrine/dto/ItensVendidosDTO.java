package br.edu.fateclins.web.prog.restAPIVitrine.dto;

import br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja.Produto;
import br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja.Venda;

public record ItensVendidosDTO(int quantidade, double precoUnitario, Venda venda, Produto produto) {
}
