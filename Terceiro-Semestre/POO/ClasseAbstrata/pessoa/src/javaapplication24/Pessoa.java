package javaapplication24;

public abstract class Pessoa {
    protected String nome;
    protected int idade;
    
    // obriga as filhas a sobrepor
    public abstract void apresentar();

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}