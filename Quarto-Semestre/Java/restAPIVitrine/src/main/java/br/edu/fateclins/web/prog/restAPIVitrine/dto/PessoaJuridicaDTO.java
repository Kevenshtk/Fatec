package br.edu.fateclins.web.prog.restAPIVitrine.dto;

import br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja.Venda;

import java.util.List;

public record PessoaJuridicaDTO(String nome, String rua, String numero, String cep, String bairro, String cidade, String estado, String pais, String telefone, List<Venda> listaVendas, String cnpj, String inscricaoEstadual) {
}
