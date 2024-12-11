package projeto_agenciabancaria.cliente;


import projeto_agenciabancaria.Endereco;
import projeto_agenciabancaria.conta.Conta;

public class Cliente {
    private int idCliente;
    private String nome;
    private String cpf;
    private Endereco endereco;
    private GerenciarConta GerenciarConta = new GerenciarConta();

    public Cliente(String nome, String cpf, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
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
    
    public void adicionarConta(Conta conta){
        GerenciarConta.execudatarAddConta(conta);
    }
    
    public void removerConta(Conta conta){
        GerenciarConta.executarRmConta(conta);
    }

    public void listarContas(){
        GerenciarConta.executarlistContas();
    } 

    public void exibir() {
        System.out.println("Nome: "+nome+"\nCPF: "+cpf);
        System.out.println("Endereco Cliente "+ endereco.toString());
        System.out.println("-----------------------------");
    }
}