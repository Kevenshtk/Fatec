package javaapplication21;

public class JavaApplication21 {


    public static void main(String[] args) {
        contaBancaria c1 = new contaBancaria(1000, "noe");
        c1.deposito(200);
        c1.sacar(100);
        
        Circulo a1 = new Circulo(2);
        a1.calcularArea();
        
        Estudante aluno = new Estudante("keven", 21, "ADS");
        System.out.println(aluno.toString());
    }
    
}
