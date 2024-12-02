package javaapplication22;

public class Aluno extends Pessoa{
    private int matricula;
    private String escolaridade;

    public Aluno(String nome, int idade, String cpf, int matricula, String escolaridade) {
        // Ref. ao construtor da classe mãe
        super(nome, idade, cpf);
        this.matricula = matricula;
        this.escolaridade = escolaridade;
    }
    
    
    
    public void cancelarMatricula(){
        System.out.println("Matrícula cancelada com sucesso!!");
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    @Override
    public String toString() {
        return "Aluno{" + "matricula=" + matricula + ", escolaridade=" + escolaridade + '}';
    }
    
    public void exibirAluno(){
        System.out.println("Nome do aluno: "+this.getNome());
        System.out.println("Idade: "+this.getIdade());
        System.out.println("CPF: "+this.getCpf());
        System.out.println("Matricula: "+this.getMatricula());
        System.out.println("Escolaridade: "+this.getEscolaridade());
    }
}
