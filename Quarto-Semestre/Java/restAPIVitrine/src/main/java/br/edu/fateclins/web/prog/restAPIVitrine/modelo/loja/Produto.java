package br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Produtos")
public class Produto implements Serializable {
    private static final long serialVersion =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    @Column(name = "descricao", length = 250, nullable = true)
    private String descricao;
    @Column(name = "valor", precision = 5, scale = 2)
    private BigDecimal valor;
    @Column (name = "qtdeEstoque", length = 4)
    private int qtdeEstoque;
    @Column (name = "estoqueMinimo", length = 4, nullable = false)
    private int estoqueMinimo;
    @Column(name = "imagem", length = 250, nullable = true)
    private String imagem;
    @ManyToOne
    @JoinColumn(name = "idUnidadeMedida")
    private UnidadeMedida unidade;
//    @ManyToOne
//    @JoinColumn(name = "idSecao")
//    private Secao secao;
//    @Transient
//    private List<ItensVitrine> itensVitrine;
//    @Transient
//    private List<ItensComprados> itensComprados;


    public Produto() {
    }

    public Produto(Integer id, String nome, String descricao, BigDecimal valor, int qtdeEstoque, int estoqueMinimo, String imagem, UnidadeMedida unidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.qtdeEstoque = qtdeEstoque;
        this.estoqueMinimo = estoqueMinimo;
        this.imagem = imagem;
        this.unidade = unidade;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(int qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public UnidadeMedida getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeMedida unidade) {
        this.unidade = unidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}