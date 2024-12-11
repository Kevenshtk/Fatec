package projeto_agenciabancaria.invest;

import projeto_agenciabancaria.conta.Conta;

public class Cdb extends Investimento{
    private double imposto;
    private double saldoAtual;

    public Cdb(int idInvestimento, double valorInvestido, double redimento, double imposto, String data) {
        super(idInvestimento, "CDB", valorInvestido, data);
        this.redimento = redimento;
        this.imposto = imposto;
    }
    
    @Override
    public void aplicarInvestimento(Conta conta){
        Cdb produto = new Cdb(idInvestimento, valorInvestido, redimento, imposto, data);
        
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
        saldoAtual = valorInvestido + redimento;
        imposto = redimento * (imposto / 100);
        saldoLiquido = saldoAtual - imposto;
        
        System.out.println("Rendimento CDB:");
        System.out.println("Saldo Bruto: "+saldoAtual+" Saldo Liquido: "+saldoLiquido + "\n");
    }
    
    
}
