/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package umparaum;

/**
 *
 * @author keven
 */
public class UmParaUm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Maria", "123546");
        
        Emprego e1 = new Emprego("Dono", 10000);
        
        p1.setEmprego(e1);
        e1.setPessoa(p1);
        
        System.out.println("Detalhes:");
        e1.mostrarDetalhes();
    }
    
}
