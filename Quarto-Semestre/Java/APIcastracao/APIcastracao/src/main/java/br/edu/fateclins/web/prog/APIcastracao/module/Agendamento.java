package br.edu.fateclins.web.prog.APIcastracao.module;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Agendamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date dataPrevista;
    @Column(nullable = false, length = 120)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "idAnimal")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "idResponsavel")
    private Responsavel responsavel;


    @OneToMany(mappedBy = "agendamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItensManejo> itensManejo = new ArrayList<>();

    public Agendamento() {
    }

    public Agendamento(Integer id, Date dataPrevista, String observacao, Animal animal, Responsavel responsavel, List<ItensManejo> itensManejo) {
        this.id = id;
        this.dataPrevista = dataPrevista;
        this.observacao = observacao;
        this.animal = animal;
        this.responsavel = responsavel;
        this.itensManejo = itensManejo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public List<ItensManejo> getItensManejo() {
        return itensManejo;
    }

    public void setItensManejo(List<ItensManejo> itensManejo) {
        this.itensManejo = itensManejo;
    }
}
