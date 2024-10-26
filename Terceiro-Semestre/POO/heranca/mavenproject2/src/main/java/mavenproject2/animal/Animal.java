package mavenproject2.animal;

public class Animal {
    private String nome;
    private double peso;
    private int idade;

    public Animal(String nome, double peso, int idade) {
        this.nome = nome;
        this.peso = peso;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public void exibir(){
        System.out.println("Nome: "+nome);
        System.out.println("Peso: "+peso);
    }
    
    public void fazerSom() {
        System.out.println("Som tipico de um mamifero.....");
    }
}
