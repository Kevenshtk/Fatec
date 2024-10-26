package mavenproject2.animal;

public class Cachorro extends Animal {
    private String raca;

    public Cachorro(String nome, double peso, int idade, String raca) {
        super(nome, peso, idade);
        this.raca = raca;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
    
    @Override
    public void exibir(){
        System.out.println("Cachorro");
        super.exibir();
        System.out.println("Raca: "+raca);
    }
}
