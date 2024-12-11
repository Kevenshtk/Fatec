package projeto_agenciabancaria.transacao;

import projeto_agenciabancaria.conta.Conta;

public class Saque extends Transacao{

    public Saque(int idTransacao, double valor, Conta destinatario, String data) {
        super(idTransacao, "Saque", valor, destinatario, data);
        
    }
    
    @Override
    public void executarTransacao(){
        double saldoAtual = destinatario.getSaldo();
        
        if(destinatario.verificarSaldo(valor)){
            destinatario.setSaldo(saldoAtual-= valor);
                
            System.out.println("Saque realizado com sucesso !\nSaldo atual: $"+saldoAtual+"\n");

        } else {
            throw new RuntimeException("Erro no saque: Saldo insuficiente, saldo atual: $"+saldoAtual+".\n");
        }    
    }
}
