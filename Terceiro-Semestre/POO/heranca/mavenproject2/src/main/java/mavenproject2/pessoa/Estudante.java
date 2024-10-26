package mavenproject2.pessoa;

public class Estudante extends Pessoa{
    private String matricula;

    public Estudante(String nome, int idade, String matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }

    public String getCurso() {
        return matricula;
    }

    public void setCurso(String matricula) {
        this.matricula = matricula;
    }
    
    @Override
    public void exibir(){
        System.out.println("Estudante");
        super.exibir();
        System.out.println("Matricula: "+matricula);
    }
}