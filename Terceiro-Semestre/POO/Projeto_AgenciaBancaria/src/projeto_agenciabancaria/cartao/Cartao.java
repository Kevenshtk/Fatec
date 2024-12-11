package projeto_agenciabancaria.cartao;

import projeto_agenciabancaria.Senha;


public abstract class Cartao {
    protected int idCartao;
    protected String numero;
    protected Senha senha;
    protected int cvc;
    protected double limite;

    public Cartao(int idCartao, String numero, Senha senha, int cvc, double limite) {
        this.idCartao = idCartao;
        this.numero = numero;
        this.senha = senha;
        this.cvc = cvc;
        this.limite = limite;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Senha getSenha() {
        return senha;
    }

    public void setSenha(Senha senha) {
        this.senha = senha;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    public abstract void exibirDetalhesCartao();
}
