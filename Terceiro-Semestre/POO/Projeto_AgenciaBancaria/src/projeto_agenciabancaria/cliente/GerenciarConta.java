package projeto_agenciabancaria.cliente;

import java.util.ArrayList;
import java.util.List;
import projeto_agenciabancaria.conta.Conta;

public class GerenciarConta {
    private List<Conta> contas = new ArrayList<>();
    
    public void execudatarAddConta(Conta conta){
        contas.add(conta);
        System.out.println("\nConta adicionada com sucesso !\n");
    }
    
    public void executarRmConta(Conta conta){
        contas.remove(conta);
        System.out.println("\nConta removida com sucesso !\n");
    }
    
    public void executarlistContas(){
        System.out.println("Relacao de contas:\n");
        for (Conta conta : contas) {
            System.out.println("Identificador: "+conta.getId());
            System.out.println("Numero da conta: "+conta.getNumero());
            System.out.println("Saldo: $"+conta.getSaldo());
            System.out.println("-----------------------------");
        }
    }
}
