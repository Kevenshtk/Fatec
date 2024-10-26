/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication25;

/**
 *
 * @author aluno
 */
public class Quadrado extends Figura{
    private int lado;

    @Override
    public void calcularArea(){
        System.out.println("A area do "+nome+" e: "+lado*lado);
    }
    
    public Quadrado(String nome, String cor, int lado) {
        super(cor, nome);
        this.lado = lado;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }
}
