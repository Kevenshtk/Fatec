package javaapplication22;

public class Funcionario extends Pessoa{
    private String cargo;
    private int horasTrabalho;

    public Funcionario(String nome, int idade, String cpf, String cargo, int horasTrabalho) {
        // Ref. ao construtor da classe mãe
        super(nome, idade, cpf);
        this.cargo = cargo;
        this.horasTrabalho = horasTrabalho;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getHorasTrabalho() {
        return horasTrabalho;
    }

    public void setHorasTrabalho(int horasTrabalho) {
        this.horasTrabalho = horasTrabalho;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "cargo=" + cargo + ", horasTrabalho=" + horasTrabalho + '}';
    }
    
    public void exibirFuncionario(){
        System.out.println("Nome do professor: "+this.getNome());
        System.out.println("Idade: "+this.getIdade());
        System.out.println("CPF: "+this.getCpf());
        System.out.println("Cargo: "+this.getCargo());
        System.out.println("Horas trabalhadas: "+this.getHorasTrabalho());
    }
}
