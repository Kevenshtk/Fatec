package projeto_agenciabancaria.invest;

import projeto_agenciabancaria.conta.Conta;

public class FundosDeInvestimento extends Investimento{
    private double taxaAdministracao;
    private double imposto;
    private double saldoAtual;

    public FundosDeInvestimento(int idInvestimento, double valorInvestido, double taxaAdministracao, double imposto, double redimento,  String data) {
        super(idInvestimento, "Fundos de Investimento", valorInvestido, data);
        this.taxaAdministracao = taxaAdministracao;
        this.imposto = imposto;
        this.redimento = redimento;
    }

    @Override
    public void aplicarInvestimento(Conta conta){
        FundosDeInvestimento produto = new FundosDeInvestimento(idInvestimento, valorInvestido, taxaAdministracao, imposto, redimento, data);
        
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
        taxaAdministracao = valorInvestido * (taxaAdministracao / 100);
        saldoAtual = (valorInvestido - taxaAdministracao) + redimento;
        
        imposto = redimento * (imposto / 100);
        saldoLiquido = saldoAtual - imposto;
        
        System.out.println("Rendimento Fundos de Investimento:");
        System.out.println("Saldo Bruto: "+saldoAtual+" Saldo Liquido: "+saldoLiquido + "\n");
    }
}
