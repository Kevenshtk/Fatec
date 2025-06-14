package br.edu.fateclins.web.prog.APIcastracao.module;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class ItensInsumo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 500)
    private int  qtde;

    @ManyToOne
    @JoinColumn(name = "idmanejo")
    @JsonBackReference
    private Manejo manejo;

    @ManyToOne
    @JoinColumn(name = "idinsumo")
    @JsonBackReference
    private Insumo insumo;

    public ItensInsumo() {
    }

    public ItensInsumo(Integer id, int qtde, Manejo manejo, Insumo insumo) {
        this.id = id;
        this.qtde = qtde;
        this.manejo = manejo;
        this.insumo = insumo;
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

    public Manejo getManejo() {
        return manejo;
    }

    public void setManejo(Manejo manejo) {
        this.manejo = manejo;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }
}
