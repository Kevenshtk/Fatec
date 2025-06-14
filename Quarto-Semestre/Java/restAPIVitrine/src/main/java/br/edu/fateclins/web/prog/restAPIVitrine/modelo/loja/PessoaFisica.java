package br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "idCliente")
@Table(name = "PessoaFisica")
public class PessoaFisica extends Cliente {

    @Column(length = 15)
    private String cpf;
    @Column(length = 15)
    private String rg;
    @Column(length = 2)
    private String sexo;
    private Date dataNascimento;

    public PessoaFisica() {
    }

    public PessoaFisica(Integer id, String nome, String rua, String numero, String cep, String bairro, String cidade, String estado, String pais, String telefone, List<Venda> listaVendas, String cpf, String rg, String sexo, Date dataNascimento) {
        super(id, nome, rua, numero, cep, bairro, cidade, estado, pais, telefone, listaVendas);
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
