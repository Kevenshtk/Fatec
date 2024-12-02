package projeto_agenciabancaria.invest;

import projeto_agenciabancaria.conta.Conta;

public abstract class Investimento {
    protected int idInvestimento;
    protected String tipoInvestimento;
    protected double valorInvestido;
    protected double redimento;
    protected double saldoLiquido;
    protected String data;

    public Investimento(int idInvestimento, String tipoInvestimento, double valorInvestido, String data) {
        this.idInvestimento = idInvestimento;
        this.tipoInvestimento = tipoInvestimento;
        this.valorInvestido = valorInvestido;
        this.data = data;
    }

    public int getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(int idInvestimento) {
        this.idInvestimento = idInvestimento;
    }

    public String getTipoInvestimento() {
        return tipoInvestimento;
    }

    public void setTipoInvestimento(String tipoInvestimento) {
        this.tipoInvestimento = tipoInvestimento;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }  
    
    public String getData() {
        return data;
    }
    
    public abstract void aplicarInvestimento(Conta conta);
    public abstract void calcularRendimento();
}
