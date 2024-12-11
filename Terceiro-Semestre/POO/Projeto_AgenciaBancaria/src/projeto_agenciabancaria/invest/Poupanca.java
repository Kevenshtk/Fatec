package projeto_agenciabancaria.invest;

import projeto_agenciabancaria.conta.Conta;

public class Poupanca extends Investimento{

    public Poupanca(int idInvestimento, double valorInvestido, String data) {
        super(idInvestimento, "Poupanca", valorInvestido, data);
        this.redimento = 10;
    }

    @Override
    public void aplicarInvestimento(Conta conta){
        Poupanca produto = new Poupanca(idInvestimento, valorInvestido, data);
        
        if (conta.verificarSaldo(valorInvestido)){
            double saldoConta = conta.getSaldo();
            conta.setSaldo(saldoConta - valorInvestido);
            
            System.out.println("Investimento realizada com sucesso !\n");
        } else {
            System.out.println("Erro no investimento: Saldo insuficiente.\n");
        }
    }
    
    @Override
    public void calcularRendimento() {
        redimento = valorInvestido * (redimento / 100);
        saldoLiquido = valorInvestido + redimento;
        
        System.out.println("Rendimento Poupanca:");
        System.out.println("Saldo Liquido: "+saldoLiquido+ "\n");
    }
}
