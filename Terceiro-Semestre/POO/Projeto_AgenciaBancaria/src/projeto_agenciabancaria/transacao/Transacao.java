package projeto_agenciabancaria.transacao;

import projeto_agenciabancaria.conta.Conta;

public abstract class Transacao {
    protected int idTransacao;
    protected String tipoTransacao;
    protected double valor;
    protected Conta destinatario;
    protected String data;

    public Transacao(int idTransacao, String tipoTransacao, double valor, Conta destinatario, String data) {
        this.idTransacao = idTransacao;
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.destinatario = destinatario;
        this.data = data;
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public String getDestinatario() {
        return destinatario.getNumero();
    }
    
    public void setDestinatario(Conta destinatario) {
        this.destinatario = destinatario;
    }
    
    public double getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }
    
    public abstract void executarTransacao();
}
