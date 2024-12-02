package projeto_agenciabancaria.cartao;

import projeto_agenciabancaria.Senha;


public class Debito extends Cartao{

    public Debito(int idCartao, String numero, Senha senha, int cvc, double limite) {
        super(idCartao, numero, senha, cvc, limite);
    }
    
    public double limiteSaqueDiario(){
        return 1000.0;
    }
    
    @Override
    public void exibirDetalhesCartao(){
        System.out.println("Cartao: ID= "+idCartao+", Numero= "+numero+", CVC= "+cvc);
        System.out.println("Senha: "+senha.toString());
    }
}
