package br.edu.fateclins.web.prog.APIcastracao.module;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, length = 120)
    private String nome;
    @Column(nullable = false, length = 120)
    private String especie;
    @Column(length = 120)
    private String cor;
    @Column(nullable = false, length = 3)
    private int idade;
    @Column(precision = 2)
    private double tamanho;

    @ManyToOne
    @JoinColumn(name = "idTutor")
    private Tutor tutor;

    @OneToMany(mappedBy = "animal")
    private List<Agendamento> agendamentos;

    public Animal() {
    }

    public Animal(Integer id, String nome, String especie, String cor, int idade, double tamanho, Tutor tutor) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.cor = cor;
        this.idade = idade;
        this.tamanho = tamanho;
        this.tutor = tutor;
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
