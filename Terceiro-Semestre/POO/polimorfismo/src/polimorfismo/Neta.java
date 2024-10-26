package polimorfismo;

public class Neta extends Filha{
    private int atributoNeta;

    public Neta(int atributoNeta, String atributoFilha) {
        super(atributoFilha);
        this.atributoNeta = atributoNeta;
    }
    
    @Override
    public void metodo(){
        System.out.println("Metodo da classe Neta");
        System.out.println("Atributo da classe neta: "+atributoNeta);
        System.out.println("Atributo da classe filha: "+this.getAtributoFilha());
    }
}
