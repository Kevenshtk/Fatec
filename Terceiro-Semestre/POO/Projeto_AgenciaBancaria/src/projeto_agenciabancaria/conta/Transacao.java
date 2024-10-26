package projeto_agenciabancaria.conta;

public class Transacao {
    private int id;
    private String tipo;
    private String descricao;
    private double valor;
    private String data;

    public Transacao(int id, String tipo, String descricao, double valor, String data) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }
}
