package projeto_agenciabancaria.conta;

public class Sacar {
    private int id;
    private Conta destinatario;
    private double valor;
    private String data;

    public Sacar(int id, Conta destinatario, double valor, String data) {
        this.id = id;
        this.destinatario = destinatario;
        this.valor = valor;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Conta getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Conta destinatario) {
        this.destinatario = destinatario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }
    
}
