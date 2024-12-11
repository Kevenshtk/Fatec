package projeto_agenciabancaria.transacao;

import projeto_agenciabancaria.conta.Conta;

public class Deposito extends Transacao{

    public Deposito(int idTransacao, double valor, Conta destinatario, String data) {
        super(idTransacao, "Deposito", valor, destinatario, data);
        
    }

    @Override
    public void executarTransacao(){
        double saldoAtual = destinatario.getSaldo();
        destinatario.setSaldo(saldoAtual+= valor);
        //destinatario.registarTransacao(this);
        
        System.out.println("Deposito realizado com sucesso !\nSaldo atual: $"+saldoAtual+"\n");
    }
    
}
