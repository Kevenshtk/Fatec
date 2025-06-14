package br.edu.fateclins.web.prog.APIcastracao.Dto;

import jakarta.validation.constraints.NotBlank;

public record responsavelDto(
        @NotBlank String nome,
        String telefone,
        String tipo) {
}
