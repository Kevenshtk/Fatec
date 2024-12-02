package javaapplication24;


public class AlunoBolsista extends Aluno {
    private double valorBolsa;
    
    @Override
    public void apresentar(){
        System.out.println("Nome e: "+nome+"e o valor da bolsa e: "+valorBolsa);
    }

    public AlunoBolsista(String nome, int idade, int matricula, double valorBolsa) {
        super(nome, idade, matricula);
        this.valorBolsa = valorBolsa;
    }

    public double getValorBolsa() {
        return valorBolsa;
    }

    public void setValorBolsa(double valorBolsa) {
        this.valorBolsa = valorBolsa;
    }
    
    
}
