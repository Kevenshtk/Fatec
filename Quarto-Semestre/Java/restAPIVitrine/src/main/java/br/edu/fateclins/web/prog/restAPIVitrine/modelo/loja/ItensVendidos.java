package br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ItensVendidos")
public class ItensVendidos implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int quantidade;
    private double precoUnitario;
    @ManyToOne
    @JoinColumn(name = "idVenda")
    private Venda venda;
    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Produto produto;

    public ItensVendidos() {
    }

    public ItensVendidos(Integer id, int quantidade, double precoUnitario, Venda venda, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.venda = venda;
        this.produto = produto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItensVendidos that = (ItensVendidos) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
