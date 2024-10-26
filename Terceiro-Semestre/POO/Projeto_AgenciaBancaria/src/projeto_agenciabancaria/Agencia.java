package projeto_agenciabancaria;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
    private int id;
    private String numero;
    private String cnpj;
    private Endereco enderecos;
    private List<Cliente> clientes;

    public Agencia(int id, String numero, String cnpj, Endereco enderecos) {
        this.id = id;
        this.numero = numero;
        this.cnpj = cnpj;
        this.enderecos = enderecos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getCidade(){
        return String.valueOf(enderecos.getCidade());
    }
    
    // MÉTODOS DE TESTE
    public void exibir(){
        System.out.println("ID "+ id + " Numero da agencia "+ numero + " CNPJ " + cnpj + " Edereco " + enderecos.toString());
    }
}
