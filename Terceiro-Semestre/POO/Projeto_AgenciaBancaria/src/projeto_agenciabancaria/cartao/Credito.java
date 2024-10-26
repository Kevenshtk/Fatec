/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_agenciabancaria.cartao;

import projeto_agenciabancaria.Senha;

/**
 *
 * @author keven
 */
public class Credito extends Cartao{
    private double juros;

    public Credito(double juros, String idCartao, String numero, Senha senha, int cvc, double limite) {
        super(idCartao, numero, senha, cvc, limite);
        this.juros = juros;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }
    
    public void exibirDadosCCartao(){
    super.exibirDetalhesCartao();
        System.out.println("Juros: "+juros);
    }
}
