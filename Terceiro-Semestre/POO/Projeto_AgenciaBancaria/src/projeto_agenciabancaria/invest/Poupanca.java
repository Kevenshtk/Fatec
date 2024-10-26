package projeto_agenciabancaria.invest;

public class Poupanca extends Investimento{
    private double redimento;
    private double saldoLiquido;

    public Poupanca(int id, String tipoInvestimento, double valorInvestido, String data) {
        super(id, tipoInvestimento, valorInvestido, data);
        this.redimento = 10;
    }

    @Override
    public void calcularRendimento() {
        redimento = valorInvestido * (redimento / 100);
        saldoLiquido = valorInvestido + redimento;
        
        System.out.println("Rendimento Poupanca:");
        System.out.println("Saldo Liquido: "+saldoLiquido + "\n");
    }
}
