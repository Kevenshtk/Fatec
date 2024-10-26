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
public class Cartao {
    private String idCartao;
    private String numero;
    private Senha senha;
    private int cvc;
    private double limite;

    public Cartao(String idCartao, String numero, Senha senha, int cvc, double limite) {
        this.idCartao = idCartao;
        this.numero = numero;
        this.senha = senha;
        this.cvc = cvc;
        this.limite = limite;
    }

    public String getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(String idCartao) {
        this.idCartao = idCartao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Senha getSenha() {
        return senha;
    }

    public void setSenha(Senha senha) {
        this.senha = senha;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    
    public void exibirDetalhesCartao(){
        System.out.println("Cartao: ID= "+idCartao+", Numero= "+numero+", CVC= "+cvc);
        System.out.println("Senha: "+senha.toString());
    }
}
