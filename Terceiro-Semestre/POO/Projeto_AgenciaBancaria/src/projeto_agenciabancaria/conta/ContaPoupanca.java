package projeto_agenciabancaria.conta;

import projeto_agenciabancaria.Senha;
import projeto_agenciabancaria.invest.Investimento;
import projeto_agenciabancaria.transacao.Transacao;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(int idConta, String numero, double saldo, double limite, Senha senha) {
        super(idConta, numero, saldo, limite, senha);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Conta salário: Id=" + idConta + ", saldo=" + saldo + ", limite=" + limite + ", numero=" + numero);
    }
    
    @Override
    public boolean verificarSaldo(double valor){
        if (saldo >= valor){
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void realizarTransacao(Transacao operacao){
        operacao.executarTransacao();
         trasacoes.registarTransacao(operacao);
    }
    
    @Override
    public void realizarInvestimento(Investimento produto, Conta conta){
        produto.aplicarInvestimento(conta);
        investimentos.registarInvestimento(produto);
    }
    
    @Override
    public void gerarExtrato(){
        trasacoes.listarTrasacoes();
        investimentos.listarInvestimentos();
    }
    
}
