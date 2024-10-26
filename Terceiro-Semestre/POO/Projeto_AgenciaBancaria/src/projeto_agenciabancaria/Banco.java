package projeto_agenciabancaria;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String id;
    private String nomeBanco;
    private String tipoBanco;
    private String cnpjBanco;
    private List<Endereco> enderecos;
    private List<Agencia> agencias;
    

    public Banco(String id, String nomeBanco, String tipoBanco, String cnpjBanco) {
        this.id= id;
        this.nomeBanco = nomeBanco;
        this.tipoBanco = tipoBanco;
        this.cnpjBanco = cnpjBanco;
        this.enderecos = new ArrayList<>();
        this.agencias = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        agencias.add(a);
    }
    
    public void removerAgencia(String numAgencia){
        boolean achou = false;
        
        for (Agencia agencia : agencias) {
            if(agencia.getNumero() == numAgencia){
                achou = true;
                agencias.remove(agencia);
                System.out.println("Agencia removida com sucesso !\n");
                return;
            }
        }
        
        if(!achou){
            System.out.println("Agencia nao encontrada....\n");
        }
    }
    
    public void buscarAgenciaPorCidade(String cidade){
        boolean achou = false;
        
        for(Agencia agencia : agencias){
            if(cidade == agencia.getCidade()){
                agencia.exibir();
            }
        }
        
        if(!achou){
            System.out.println("Agencia nao encontrada....\n");
        }
    }
    
    // MÉTODOS DE TESTE
    public void exibirBanco(){
        System.out.println("Dados do banco:\n");
        System.out.println("Nome Banco: " + nomeBanco +
                "\nTipo do Banco: " + tipoBanco +
                "\nCNPJ: " + cnpjBanco);
        
        for(Endereco endereco:enderecos){
            System.out.println("Endereco Banco:\n" + endereco.toString());
        }
        
        System.out.println("\nAgencias:");
        for(Agencia agencia: agencias){
            agencia.exibir();
        }
        System.out.println("-----------------------------------------------");
    }
}
