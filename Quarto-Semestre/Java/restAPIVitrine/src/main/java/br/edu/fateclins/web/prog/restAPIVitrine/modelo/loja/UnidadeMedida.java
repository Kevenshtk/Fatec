package br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "UnidadesMedida")
public class UnidadeMedida implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;
    @Column(name = "sigla", length = 4, nullable = false)
    private String sigla;
//    @OneToMany(mappedBy = "unidade", cascade = CascadeType.ALL)
    @Transient
    private List<Produto> listaProdutos;

    public UnidadeMedida() {
    }

    public UnidadeMedida(Integer id, String descricao, String sigla, List<Produto> listaProdutos) {
        this.id = id;
        this.descricao = descricao;
        this.sigla = sigla;
        this.listaProdutos = listaProdutos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnidadeMedida that = (UnidadeMedida) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
