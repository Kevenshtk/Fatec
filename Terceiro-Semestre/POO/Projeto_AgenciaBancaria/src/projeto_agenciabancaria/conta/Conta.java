package projeto_agenciabancaria.conta;

import java.util.*;
import projeto_agenciabancaria.Cliente;
import projeto_agenciabancaria.Senha;
import projeto_agenciabancaria.invest.Investimento;

public abstract class Conta {
    protected String id;
    protected String numero;
    protected double saldo;
    protected double limite;
    protected Senha senha;

    public Conta(String id, String numero, double saldo, double limite, Senha senha) {
        this.id = id;
        this.numero = numero;
        this.saldo = saldo;
        this.limite = limite;
        this.senha = senha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    public void depositar(Conta contaDesposito, double valor, Cliente cliente, String data){
        saldo+= valor;
        cliente.registrarDeposito(contaDesposito, valor, data);
        
        System.out.println("Deposito realizado com sucesso !\n");
    }
    
    public void sacar(Conta contaSaque, double valor, Cliente cliente, String data){
        if(saldo >= valor){
            saldo-= valor;
            cliente.registrarSaque(contaSaque, valor, data);
            
            System.out.println("Saque realizado com sucesso !\n");
        } else {
            throw new RuntimeException("Saldo insuficiente\n");
        }
    }
    
    public void transferir(Conta destinatario, Conta remetente, double valor, Cliente clienteRemetente, String data){
        if (remetente == null || destinatario == null) {
            throw new RuntimeException("Erro: Conta de origem ou destino nao encontrada.\n");
        } else {
            if (remetente.getSaldo() >= valor) {
                double saldoRementente = remetente.getSaldo();
                remetente.setSaldo(saldoRementente - valor);
             
                double saldoDestinatario = destinatario.getSaldo();
                destinatario.setSaldo(saldoDestinatario + valor);
            
                clienteRemetente.registrarTransferencia(this, destinatario, valor, data);
            
                System.out.println("Transferencia realizada com sucesso !\n");
            
            } else {
                throw new RuntimeException("Saldo insuficiente para transferencia.\n");
            }
        }
    }
    
    public void Investir(Investimento produto, Conta conta, Cliente cliente){
        double valorInvest = produto.getValorInvestido();
        
        if (conta.getSaldo() >= valorInvest){
            double saldoAtual = conta.getSaldo();
            conta.setSaldo(saldoAtual - valorInvest);
            
            cliente.registarInvestimento(produto);
            System.out.println("Investimento realizada com sucesso !\n");
        } else {
            System.out.println("Saldo insuficiente.\n");
        }
        
    }
    
    public abstract void exibirDetalhes();
      
}