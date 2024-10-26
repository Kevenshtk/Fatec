package projeto_agenciabancaria.invest;

public abstract class Investimento {
    protected int id;
    protected String tipoInvestimento;
    protected double valorInvestido;
    protected String data;

    public Investimento(int id, String tipoInvestimento, double valorInvestido, String data) {
        this.id = id;
        this.tipoInvestimento = tipoInvestimento;
        this.valorInvestido = valorInvestido;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public abstract void calcularRendimento();
}
