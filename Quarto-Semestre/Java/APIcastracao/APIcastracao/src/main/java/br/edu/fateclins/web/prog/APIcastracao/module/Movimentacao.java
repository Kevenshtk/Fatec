package br.edu.fateclins.web.prog.APIcastracao.module;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Movimentacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(precision = 2)
    private double qdte;
    @Column(nullable = false, length = 120)
    private String tipoES;

    @ManyToOne
    @JoinColumn(name = "idInsumo")
    private Insumo insumo;

    public Movimentacao() {
    }

    public Movimentacao(Integer id, Date data, double qdte, String tipoES, Insumo insumo) {
        this.id = id;
        this.data = data;
        this.qdte = qdte;
        this.tipoES = tipoES;
        this.insumo = insumo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getQdte() {
        return qdte;
    }

    public void setQdte(double qdte) {
        this.qdte = qdte;
    }

    public String getTipoES() {
        return tipoES;
    }

    public void setTipoES(String tipoES) {
        this.tipoES = tipoES;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }
}
