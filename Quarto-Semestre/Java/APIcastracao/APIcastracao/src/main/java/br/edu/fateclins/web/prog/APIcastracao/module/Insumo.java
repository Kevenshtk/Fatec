package br.edu.fateclins.web.prog.APIcastracao.module;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
public class Insumo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, length = 120)
    private String nome;
    @Column(nullable = false, length = 100)
    private String tipo;
    @Column(precision = 2)
    private double precoCusto;
    @Column(precision = 2)
    private double qtde;

    @OneToMany(mappedBy = "insumo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ItensInsumo> itensInsumos;

    public Insumo() {
    }

    public Insumo(Integer id, String nome, String tipo, double precoCusto, double qtde, List<ItensInsumo> itensInsumos) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.precoCusto = precoCusto;
        this.qtde = qtde;
        this.itensInsumos = itensInsumos;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getQtde() {
        return qtde;
    }

    public void setQtde(double qtde) {
        this.qtde = qtde;
    }

    public List<ItensInsumo> getItensInsumos() {
        return itensInsumos;
    }

    public void setItensInsumos(List<ItensInsumo> itensInsumos) {
        this.itensInsumos = itensInsumos;
    }
}
