/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication25;

/**
 *
 * @author aluno
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Retangulo r = new Retangulo("Retangulo", "azul", 2, 1);
        r.calcularArea();
        
        Quadrado q = new Quadrado("Quadrado", "vermelho", 2);
        q.calcularArea();
        
        Circulo c = new Circulo("Circulo", "preto", 2);
        c.calcularArea();
    }
    
}
