/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication25;

/**
 *
 * @author aluno
 */
public class Retangulo extends Figura{
    private int base;
    private int altura;

    @Override
    public void calcularArea(){
        System.out.println("A area do "+nome+" e: "+base*altura);
    }
    
    public Retangulo(String nome, String cor, int base, int altura) {
        super(cor, nome);
        this.base = base;
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    
}
