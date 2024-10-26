package mavenproject2.animal;

public class Mamifero extends Animal{
    private String genero;

    public Mamifero(String nome, double peso, int idade, String genero) {
        super(nome, peso, idade);
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
