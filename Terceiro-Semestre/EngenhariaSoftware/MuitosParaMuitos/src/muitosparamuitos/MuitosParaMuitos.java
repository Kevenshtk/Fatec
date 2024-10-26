package muitosparamuitos;


public class MuitosParaMuitos {


    public static void main(String[] args) {
        Aluno a1 = new Aluno("Keven");
        Aluno a2 = new Aluno("Tadeu");
        
        Curso c1 = new Curso("a");
        Curso c2 = new Curso("b");
        
        
        Matricula m1 = new Matricula(a1, c1);
        Matricula m2 = new Matricula(a1, c2);
        Matricula m3 = new Matricula(a2, c1);
        
        for(Matricula matricula : a1.getMatriculas()){
            System.out.println(matricula);
        }
        
        System.out.println("----------------------");
        
        for(Matricula matricula : a2.getMatriculas()){
            System.out.println(matricula);
        }
    }
    
}
