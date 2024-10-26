package javaapplication24;

public class JavaApplication24 {

    public static void main(String[] args) {
        Professor p = new Professor("Pedro", 30, "Programacao");
        Aluno a = new Aluno("Maria", 25, 1234);
        AlunoBolsista ab = new AlunoBolsista("João", 20, 3333, 500);
        
        p.apresentar();
        System.out.println("-------------------");
        a.apresentar();
        System.out.println("-------------------");
        ab.apresentar();
    }
    
}
