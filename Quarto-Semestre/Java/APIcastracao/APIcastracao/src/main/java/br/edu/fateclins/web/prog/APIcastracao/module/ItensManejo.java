package br.edu.fateclins.web.prog.APIcastracao.module;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class ItensManejo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 500)
    private int  qtde;

    @ManyToOne
    @JoinColumn(name = "idagendamento")
    @JsonBackReference
    private Agendamento agendamento;

    @ManyToOne
    @JoinColumn(name = "idmanejo")
    @JsonBackReference
    private Manejo manejo;

    public ItensManejo() {
    }

    public ItensManejo(Integer id, int qtde, Agendamento agendamento, Manejo manejo) {
        this.id = id;
        this.qtde = qtde;
        this.agendamento = agendamento;
        this.manejo = manejo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public Manejo getManejo() {
        return manejo;
    }

    public void setManejo(Manejo manejo) {
        this.manejo = manejo;
    }
}
