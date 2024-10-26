package javaapplication22;


public class Professor extends Pessoa{
    private String especialidade;
    private float salario;

    public Professor(String nome, int idade, String cpf, String especialidade, float salario) {
        // Ref. ao construtor da classe mãe
        super(nome, idade, cpf);
        this.especialidade = especialidade;
        this.salario = salario;
    }
    
    public void receberAumento(float aum){
        this.salario += aum;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Professor{" + "especialidade=" + especialidade + ", salario=" + salario + '}';
    }
    
     public void exibirProfessor(){
        System.out.println("Nome do professor: "+this.getNome());
        System.out.println("Idade: "+this.getIdade());
        System.out.println("CPF: "+this.getCpf());
        System.out.println("Especialidade: "+this.getEspecialidade());
        System.out.println("Sálario: "+this.getSalario());
    }
}
