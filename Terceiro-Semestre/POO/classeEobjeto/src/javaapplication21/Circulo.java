package javaapplication21;

public class Circulo {
    private double raio;
    private double area;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
    
    public void calcularArea(){
        area = Math.PI * Math.pow(raio, 2);
        System.out.println(area);
    }
}
