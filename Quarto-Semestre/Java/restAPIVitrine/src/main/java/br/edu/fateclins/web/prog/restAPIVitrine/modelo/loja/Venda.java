package br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Vendas")
public class Venda implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date dataVenda;
    @Column(length = 100)
    private String notaFiscal;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    @Transient
    private List<ItensVendidos> listaItensVendidos;

    public Venda() {
    }

    public Venda(Integer id, Date dataVenda, String notaFiscal, Cliente cliente, List<ItensVendidos> listaItensVendidos) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.notaFiscal = notaFiscal;
        this.cliente = cliente;
        this.listaItensVendidos = listaItensVendidos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItensVendidos> getListaItensVendidos() {
        return listaItensVendidos;
    }

    public void setListaItensVendidos(List<ItensVendidos> listaItensVendidos) {
        this.listaItensVendidos = listaItensVendidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return Objects.equals(id, venda.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
