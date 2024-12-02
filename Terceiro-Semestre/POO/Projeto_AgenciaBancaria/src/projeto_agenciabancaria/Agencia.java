package projeto_agenciabancaria;

import projeto_agenciabancaria.cliente.Cliente;
import java.util.List;

public class Agencia {
    private int idAgencia;
    private String numero;
    private String cnpj;
    private Endereco enderecos;
    private List<Cliente> clientes;

    public Agencia(int idAgencia, String numero, String cnpj, Endereco enderecos) {
        this.idAgencia = idAgencia;
        this.numero = numero;
        this.cnpj = cnpj;
        this.enderecos = enderecos;
    }

    public int getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(int idAgencia) {
        this.idAgencia = idAgencia;
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
        System.out.println("ID "+ idAgencia + " Numero da agencia "+ numero + " CNPJ " + cnpj + " Edereco " + enderecos.toString());
    }
}
