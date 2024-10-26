package polimorfismo;

public class Filha extends Pai{
    private String atributoFilha;

    public Filha(String atributoFilha) {
        this.atributoFilha = atributoFilha;
    }

    public String getAtributoFilha() {
        return atributoFilha;
    }

    public void setAtributoFilha(String atributoFilha) {
        this.atributoFilha = atributoFilha;
    }
    
    @Override
    public void metodo(){
        System.out.println("Metodo da classe Filha");
        System.out.println("Atributo da classe filha "+atributoFilha);
    }
}
