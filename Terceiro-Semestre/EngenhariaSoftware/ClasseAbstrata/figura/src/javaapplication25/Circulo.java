/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication25;

/**
 *
 * @author aluno
 */
public class Circulo extends Figura{
    private int raio;
    
    @Override
    public void calcularArea(){
        System.out.println("A area do "+nome+" e: "+Math.PI*Math.pow(raio, 2));
    }
    
    public Circulo(String nome, String cor, int raio) {
        super(cor, nome);
        this.raio = raio;
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }
    
    
}
