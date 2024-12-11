package projeto_agenciabancaria.transacao;

import projeto_agenciabancaria.conta.Conta;

public class Transferencia extends Transacao{
    private Conta remetente;

    public Transferencia(int idTransacao, Conta remetente, double valor, Conta destinatario, String data) {
        super(idTransacao, "Transferencia", valor, destinatario, data);
        this.remetente = remetente;
    }

    public Conta getRemetente() {
        return remetente;
    }

    public void setRemetente(Conta remetente) {
        this.remetente = remetente;
    }

   @Override
    public void executarTransacao(){
        if (remetente == null || destinatario == null) {
            throw new RuntimeException("Erro: Conta de origem ou destino nao encontrada.\n");
        } else {
            double saldoRementente = remetente.getSaldo();
            
            if (remetente.verificarSaldo(valor)) {
                remetente.setSaldo(saldoRementente - valor);
             
                double saldoDestinatario = destinatario.getSaldo();
                destinatario.setSaldo(saldoDestinatario + valor);
                //remetente.registarTransacao(this);
                //destinatario.registarTransacao(this);
                
                System.out.println("Transferencia realizada com sucesso !\n");
            
            } else {
                throw new RuntimeException("Erro da transferencia: Saldo do remetente insuficiente para transferencia, saldo atual: $"+saldoRementente+"\n");
            }
        }
    }

}