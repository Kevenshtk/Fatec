package projeto_agenciabancaria.conta;

public class Transferencia {
    private int id;
    private String descricao;
    private Conta remetente;
    private Conta destinatario;
    private double valor;
    private String data;

    public Transferencia(int id, String descricao, Conta remetente, Conta destinatario, double valor, String data) {
        this.id = id;
        this.descricao = descricao;
        this.remetente = remetente;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Conta getRemetente() {
        return remetente;
    }

    public void setRemetente(Conta remetente) {
        this.remetente = remetente;
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