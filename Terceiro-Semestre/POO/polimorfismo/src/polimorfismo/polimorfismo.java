package polimorfismo;

public class polimorfismo {

    public static void main(String[] args) {
        Pai p = new Pai();
        Filha f = new Filha("Filha");
        Neta n = new Neta(50, "Neta");
        
        p.metodo();
        f.metodo();
        n.metodo();
        
        Pai filha = new Filha("Pai Filha");
        Pai neta = new Neta(24, "Pai Neta");
    }
}
