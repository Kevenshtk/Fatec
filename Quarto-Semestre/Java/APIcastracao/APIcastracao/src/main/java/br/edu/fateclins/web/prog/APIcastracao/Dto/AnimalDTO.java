package br.edu.fateclins.web.prog.APIcastracao.Dto;

import br.edu.fateclins.web.prog.APIcastracao.module.Tutor;
import jakarta.validation.constraints.NotBlank;

public record AnimalDTO(@NotBlank String nome,
                        String especie,
                        String cor,
                        int idade,
                        double tamanho,
                        Tutor tutor) {
}
