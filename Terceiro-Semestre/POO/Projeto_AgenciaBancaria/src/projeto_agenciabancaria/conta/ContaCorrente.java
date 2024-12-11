package projeto_agenciabancaria.conta;

import projeto_agenciabancaria.Senha;
import projeto_agenciabancaria.invest.HistoricoDeInvestimentos;
import projeto_agenciabancaria.invest.Investimento;
import projeto_agenciabancaria.transacao.HistoricoDeTrasacoes;
import projeto_agenciabancaria.transacao.Transacao;

public class ContaCorrente extends Conta{
    private double tarifa;

    public ContaCorrente(int idConta, String numero, double saldo, double limite, double tarifa, Senha senha){
        super(idConta, numero, saldo, limite, senha);
        this.tarifa = tarifa;
        this.trasacoes = new HistoricoDeTrasacoes();
        this.investimentos = new HistoricoDeInvestimentos();
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Conta corrente: Id=" + idConta + ", saldo=" + saldo + ", limite=" + limite + ", numero=" + numero + ", tarifas=" +tarifa);
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
