package projeto_agenciabancaria.cartao;

import projeto_agenciabancaria.Senha;

public class Credito extends Cartao{
    private double juros;

    public Credito(double juros, int idCartao, String numero, Senha senha, int cvc, double limite) {
        super(idCartao, numero, senha, cvc, limite);
        this.juros = juros;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }
    
    @Override
    public void exibirDetalhesCartao(){
        System.out.println("Cartao: ID= "+idCartao+", Numero= "+numero+", CVC= "+cvc);
        System.out.println("Senha: "+senha.toString());
        System.out.println("Juros: "+juros);
    }
}
