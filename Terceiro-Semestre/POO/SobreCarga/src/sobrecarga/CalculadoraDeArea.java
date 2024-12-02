/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sobrecarga;

/**
 *
 * @author keven
 */
public class CalculadoraDeArea {
     public double calcular(double largura, double altura) {
        return largura * altura;
    }

    public double calcular(double raio) {
        return Math.PI * Math.pow(raio, 2);
    }

    public double calcular(String lado) {
        double i;
        i = Double.parseDouble(lado);
        return i * i;
    }

    public double calcular(double base, double altura, boolean isTriangulo) {
        if (isTriangulo) {
            return (base * altura) / 2;
        }
        return -1;
    }
}
