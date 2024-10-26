package umparaum;


public class Pessoa {
    private String nome;
    private String cpf;
    private Emprego emprego;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.emprego = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Emprego getEmprego() {
        return emprego;
    }

    public void setEmprego(Emprego emprego) {
        this.emprego = emprego;
    }
    
    public void mostrarDetalhes(){
        System.out.println("Nome: "+nome);
        System.out.println("CPF: "+cpf);
        
        if(emprego != null){
            System.out.println("Emprego: "+emprego.getCargo());
            System.out.println("Salario: $"+emprego.getSalario());
        } else {
            System.out.println("Sem emprego no momento");
        }
    }
}
