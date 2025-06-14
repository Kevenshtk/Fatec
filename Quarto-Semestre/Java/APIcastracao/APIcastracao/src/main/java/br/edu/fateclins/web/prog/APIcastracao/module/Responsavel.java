package br.edu.fateclins.web.prog.APIcastracao.module;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Responsavel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, length = 120)
    private String nome;
    @Column(nullable = false, length = 14)
    private String telefone;
    @Column(nullable = false, length = 100)
    private String tipo;

    @OneToMany(mappedBy = "responsavel")
    private List<Agendamento> agendamentos;

    public Responsavel() {
    }

    public Responsavel(Integer id, String nome, String telefone, String tipo) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.tipo = tipo;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
