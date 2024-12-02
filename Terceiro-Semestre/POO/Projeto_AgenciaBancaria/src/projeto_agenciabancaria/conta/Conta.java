package projeto_agenciabancaria.conta;

import projeto_agenciabancaria.Senha;
import projeto_agenciabancaria.invest.HistoricoDeInvestimentos;
import projeto_agenciabancaria.invest.Investimento;
import projeto_agenciabancaria.transacao.HistoricoDeTrasacoes;
import projeto_agenciabancaria.transacao.Transacao;

public abstract class Conta {
    protected int idConta;
    protected String numero;
    protected double saldo;
    protected double limite;
    protected Senha senha;
    protected HistoricoDeTrasacoes trasacoes;
    protected HistoricoDeInvestimentos investimentos;

    public Conta(int idConta, String numero, double saldo, double limite, Senha senha) {
        this.idConta = idConta;
        this.numero = numero;
        this.saldo = saldo;
        this.limite = limite;
        this.senha = senha;
    }

    public int getId() {
        return idConta;
    }

    public void setId(int idConta) {
        this.idConta = idConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public Senha getSenha(){
     return senha;
    }
    
    public abstract void exibirDetalhes();
    
    public abstract boolean verificarSaldo(double valor);
    
    public abstract void realizarTransacao(Transacao operacao);
    
    public abstract void realizarInvestimento(Investimento produto, Conta conta);
    
    public abstract void gerarExtrato();
    
}