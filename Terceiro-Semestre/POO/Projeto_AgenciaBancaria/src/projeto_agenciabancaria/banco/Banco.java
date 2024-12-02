package projeto_agenciabancaria.banco;

import java.util.ArrayList;
import java.util.List;
import projeto_agenciabancaria.Agencia;
import projeto_agenciabancaria.Endereco;

public class Banco {
    private int idBanco;
    private String nomeBanco;
    private String tipoBanco;
    private String cnpjBanco;
    private List<Endereco> enderecos;
    private GerenciarAgencia GerenciarAgencia = new GerenciarAgencia();
    

    public Banco(int idBanco, String nomeBanco, String tipoBanco, String cnpjBanco) {
        this.idBanco= idBanco;
        this.nomeBanco = nomeBanco;
        this.tipoBanco = tipoBanco;
        this.cnpjBanco = cnpjBanco;
        this.enderecos = new ArrayList<>();
    }

    public int getId() {
        return idBanco;
    }

    public void setId(int idBanco) {
        this.idBanco = idBanco;
    }
    
    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getTipoBanco() {
        return tipoBanco;
    }

    public void setTipoBanco(String tipoBanco) {
        this.tipoBanco = tipoBanco;
    }

    public String getCnpjBanco() {
        return cnpjBanco;
    }

    public void setCnpjBanco(String cnpjBanco) {
        this.cnpjBanco = cnpjBanco;
    }
    
    public void adicionarEndereco(Endereco e){
        enderecos.add(e);
    }
    
    public void adicionarAgencia(Agencia a){
        GerenciarAgencia.executarAddAgencia(a);
    }
    
    public void removerAgencia(Agencia a){
        GerenciarAgencia.executarRmAgencia(a);
    }
    
    public void listarAgencias(){
        GerenciarAgencia.executarListAgencia();
    }
    
    public void buscarAgenciaPorCidade(String cidade){
        GerenciarAgencia.executarBuscAgenciaCidade(cidade);
    }
    
    public void exibirBanco(){
        System.out.println("Dados do banco:\n");
        System.out.println("Nome Banco: " + nomeBanco +
                "\nTipo do Banco: " + tipoBanco +
                "\nCNPJ: " + cnpjBanco);
        
        for(Endereco endereco:enderecos){
            System.out.println("Endereco Banco:\n" + endereco.toString());
        }
        
        System.out.println("\nAgencias:");
        GerenciarAgencia.executarListAgencia();
    }
}
