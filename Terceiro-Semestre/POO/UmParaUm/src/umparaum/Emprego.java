package umparaum;


public class Emprego {
    private String cargo;
    private double salario;
    private Pessoa pessoa;

    public Emprego(String cargo, double salario) {
        this.cargo = cargo;
        this.salario = salario;
        this.pessoa = null;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public void mostrarDetalhes(){
        System.out.println("Cargo: "+cargo);
        System.out.println("Salario: $"+salario);
        
        if(pessoa != null){
            System.out.println("Nome: "+pessoa.getNome());
            System.out.println("CPF: "+pessoa.getCpf());
        } else {
            System.out.println("Sem pessoa vinculada no momento");
        }
    }
}
