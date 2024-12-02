/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package umparamuitos;

/**
 *
 * @author keven
 */
public class UmParaMuitos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pessoa p = new Pessoa("Keven");
        
        Carro c1 = new Carro("VW", "Saveiro G4", p);
        Carro c2 = new Carro("VW", "Saveiro G5", p);
        
        p.adicionarCarro(c1);
        p.adicionarCarro(c2);
        
        System.out.println(p.toString());
        
    }
    
}
