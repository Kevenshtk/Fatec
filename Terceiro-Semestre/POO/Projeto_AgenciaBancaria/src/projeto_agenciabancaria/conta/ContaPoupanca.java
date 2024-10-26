package projeto_agenciabancaria.conta;

import projeto_agenciabancaria.Cliente;
import projeto_agenciabancaria.Senha;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(String id, String numero, double saldo, double limite, Senha senha) {
        super(id, numero, saldo, limite, senha);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Conta salário: Id=" + id + ", saldo=" + saldo + ", limite=" + limite + ", numero=" + numero);
    }
    
}
