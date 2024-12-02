package javaapplication24;

public class Aluno extends Pessoa{
    private int matricula;

    @Override
    public void apresentar(){
        System.out.println("Nome e: "+nome+"e a matricula e: "+matricula);
    }
    
    public Aluno(String nome, int idade, int matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    
}
