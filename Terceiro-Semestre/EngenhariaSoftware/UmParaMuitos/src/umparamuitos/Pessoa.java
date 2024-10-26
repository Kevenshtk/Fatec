/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umparamuitos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author keven
 */
public class Pessoa {
    private String nome;
    private List<Carro> carros;

    public Pessoa(String nome) {
        this.nome = nome;
        this.carros = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void adicionarCarro(Carro carro) {
        carros.add(carro);
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", quantidade de carros=" + carros.size() + '}';
    }
    
    
    
    
}
