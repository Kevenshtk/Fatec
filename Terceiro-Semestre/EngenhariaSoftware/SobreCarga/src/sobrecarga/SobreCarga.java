package sobrecarga;


public class SobreCarga {


    public static void main(String[] args) {
         CalculadoraDeArea calc = new CalculadoraDeArea();
        
        System.out.println("Area do Retangulo: " + calc.calcular(5, 10));
        System.out.println("Area do Circulo: " + calc.calcular(7));
        System.out.println("Area do Quadrado: " + calc.calcular("4"));
        System.out.println("Area do Triangulo: " + calc.calcular(6, 8, true));
    }
    
}