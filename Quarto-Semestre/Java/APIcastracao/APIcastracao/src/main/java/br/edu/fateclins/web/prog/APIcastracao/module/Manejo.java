package br.edu.fateclins.web.prog.APIcastracao.module;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Manejo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 120)
    private String nome;

    @Column(length = 500)
    private String descricao;

    @OneToMany(mappedBy = "manejo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ItensManejo> itensManejo;

    @OneToMany(mappedBy = "manejo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ItensInsumo> itensInsumos = new ArrayList<>();

    public Manejo() {}

    public Manejo(Integer id, String nome, String descricao, List<ItensManejo> itensManejo, List<ItensInsumo> itensInsumos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.itensManejo = itensManejo;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ItensManejo> getItensManejo() {
        return itensManejo;
    }

    public void setItensManejo(List<ItensManejo> itensManejo) {
        this.itensManejo = itensManejo;
    }

    public List<ItensInsumo> getItensInsumos() {
        return itensInsumos;
    }

    public void setItensInsumos(List<ItensInsumo> itensInsumos) {
        this.itensInsumos = itensInsumos;
    }
}
