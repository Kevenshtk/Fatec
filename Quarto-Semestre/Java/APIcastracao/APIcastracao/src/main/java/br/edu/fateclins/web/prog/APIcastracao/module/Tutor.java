package br.edu.fateclins.web.prog.APIcastracao.module;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Tutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, length = 120)
    private String nome;
    @Column(nullable = false, length = 14)
    private String celular;
    @Column(nullable = false, length = 9)
    private String cep;
    @Column(nullable = false, length = 120)
    private String bairro;
    @Column(nullable = false, length = 120)
    private String rua;
    @Column(nullable = false, length = 5)
    private String numero;
    @Column(length = 120)
    private String complemento;

    public Tutor() {
    }

    public Tutor(Integer id, String nome, String celular, String cep, String bairro, String rua, String numero, String complemento) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
