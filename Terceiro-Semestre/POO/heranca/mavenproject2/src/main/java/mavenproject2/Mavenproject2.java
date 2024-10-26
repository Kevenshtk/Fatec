package mavenproject2;

import mavenproject2.carro.Carro;
import mavenproject2.animal.Mamifero;
import mavenproject2.animal.Cachorro;
import mavenproject2.pessoa.Estudante;
import mavenproject2.pessoa.Gerente;

public class Mavenproject2 {

    public static void main(String[] args) {
        Cachorro c1 = new Cachorro("Jubileu", 2.5, 2, "algum");
        c1.exibir();
        System.out.println("--------------------");
        
        Estudante e1 = new Estudante("Irineu", 25, "214356");
        e1.exibir();
        System.out.println("--------------------");
        
        Carro c11 = new Carro("Fusca", 1998, "preto");
        c11.exibir();
        System.out.println("--------------------");
        
        Gerente g1 = new Gerente("Tadeu", 22, 1500, "Logo ali");
        g1.exibir();
        System.out.println("--------------------");
        
        Mamifero mamifero = new Mamifero("Leoa", 150.0, 5, "Feminino");
        System.out.println("Mamifero");
        mamifero.fazerSom();
    }
}
