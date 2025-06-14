package br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "idCliente")
@Table(name = "PessoaJuridica")
public class PessoaJuridica extends Cliente {
    @Column(length = 50)
    private String cnpj;
    @Column(length = 100)
    private String inscricaoEstadual;

    public PessoaJuridica() {
    }

    public PessoaJuridica(Integer id, String nome, String rua, String numero, String cep, String bairro, String cidade, String estado, String pais, String telefone, List<Venda> listaVendas, String cnpj, String inscricaoEstadual) {
        super(id, nome, rua, numero, cep, bairro, cidade, estado, pais, telefone, listaVendas);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
}
