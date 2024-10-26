package mavenproject2.pessoa;

public class Gerente extends Funcionario{
    private String setor;

    public Gerente(String nome, int idade, double salario, String setor) {
        super(nome, idade, salario);
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public void exibir(){
    System.out.println("Gerente");
    super.exibir();
    System.out.println("Setor: "+setor);
    }
}