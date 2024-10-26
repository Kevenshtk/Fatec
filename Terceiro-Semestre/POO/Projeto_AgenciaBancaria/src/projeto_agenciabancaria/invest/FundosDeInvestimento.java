package projeto_agenciabancaria.invest;

public class FundosDeInvestimento extends Investimento{
    private double taxaAdministracao;
    private double imposto;
    private double redimento;
    private double saldoAtual;
    private double saldoLiquido;

    public FundosDeInvestimento(int id, String tipoInvestimento, double valorInvestido, double taxaAdministracao, double imposto, double redimento,  String data) {
        super(id, tipoInvestimento, valorInvestido, data);
        this.taxaAdministracao = taxaAdministracao;
        this.imposto = imposto;
        this.redimento = redimento;
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
