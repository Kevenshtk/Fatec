package br.edu.fateclins.web.prog.restAPIVitrine.dto;

import br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja.UnidadeMedida;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoDTO(@NotBlank String nome, String descricao,
                         @NotNull BigDecimal valor, int qtdeEstoque,
                         int estoqueMinimo, String imagem, UnidadeMedida unidade) {
}
