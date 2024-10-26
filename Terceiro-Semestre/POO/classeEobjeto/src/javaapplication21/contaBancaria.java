package javaapplication21;

public class contaBancaria {
    private double saldo;
    private String titular;

    public contaBancaria(double saldo, String titular) {
        this.saldo = saldo;
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    public void deposito(double valorDeposito){
        saldo += valorDeposito;
        System.out.println(titular +" seu saldo e R$ " +saldo);
    }
    
    public void sacar(double valorSaque){
        saldo -= valorSaque;
        System.out.println(titular +" seu saldo e R$ " +saldo);
    }
}
