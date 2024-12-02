package javaapplication24;

public class Professor extends Pessoa{
    private String materia;

    @Override
    public void apresentar(){
        System.out.println("Nome: "+nome+"e sou professor de "+materia);
    }
    
    public Professor(String nome, int idade, String materia) {
        super(nome, idade);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
