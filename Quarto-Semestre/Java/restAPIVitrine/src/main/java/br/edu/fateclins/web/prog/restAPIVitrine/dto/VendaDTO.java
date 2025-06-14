package br.edu.fateclins.web.prog.restAPIVitrine.dto;

import br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja.Cliente;
import br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja.ItensVendidos;

import java.util.Date;
import java.util.List;

public record VendaDTO(Date dataVenda, String notaFiscal, Cliente cliente, List<ItensVendidos> listaItensVendidos) {
}
