package projeto_agenciabancaria.cartao;

import projeto_agenciabancaria.Senha;


public class Debito extends Cartao{

    public Debito(String idCartao, String numero, Senha senha, int cvc, double limite) {
        super(idCartao, numero, senha, cvc, limite);
    }
    
    public double limiteSaqueDiario(){
        return 1000.0;
    }
    
    public void exibirDadosCDebito(){
        super.exibirDetalhesCartao();
    }
}
