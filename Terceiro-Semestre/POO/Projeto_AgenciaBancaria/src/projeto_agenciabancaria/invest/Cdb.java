package projeto_agenciabancaria.invest;

public class Cdb extends Investimento{
    private double redimento;
    private double imposto;
    private double saldoAtual;
    private double saldoLiquido;

    public Cdb(int id, String tipoInvestimento, double valorInvestido, double redimento, double imposto, String data) {
        super(id, tipoInvestimento, valorInvestido, data);
        this.redimento = redimento;
        this.imposto = imposto;
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
