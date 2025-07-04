package br.edu.fateclins.web.prog.APIcastracao.Dto;

import jakarta.validation.constraints.NotBlank;

public record TutorDTO(@NotBlank String nome,
                       @NotBlank String celular,
                       String cep,
                       String bairro,
                       String rua,
                       String numero,
                       String complemento) {
}
