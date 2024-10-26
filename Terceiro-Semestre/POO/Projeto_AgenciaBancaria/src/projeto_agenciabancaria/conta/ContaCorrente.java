package projeto_agenciabancaria.conta;

import projeto_agenciabancaria.Cliente;
import projeto_agenciabancaria.Senha;

public class ContaCorrente extends Conta{
    private double tarifa;

    public ContaCorrente(String id, String numero, double saldo, double limite, double tarifa, Senha senha){
        super(id, numero, saldo, limite, senha);
        this.tarifa = tarifa;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Conta corrente: Id=" + id + ", saldo=" + saldo + ", limite=" + limite + ", numero=" + numero + ", tarifas=" +tarifa);
    }
    
    
    
}
