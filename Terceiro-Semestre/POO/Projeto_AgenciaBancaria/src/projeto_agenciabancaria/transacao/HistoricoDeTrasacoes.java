package projeto_agenciabancaria.transacao;

import java.util.ArrayList;
import java.util.List;
import projeto_agenciabancaria.GerenciarData;

public class HistoricoDeTrasacoes {
    private List<Transacao>transacoes;
    private GerenciarData GerenciarData = new GerenciarData();
    
    public HistoricoDeTrasacoes(){
        this.transacoes = new ArrayList<>();
    }
    
    
    public void registarTransacao(Transacao operacao){
        transacoes.add(operacao);
    }
    
    public void listarTrasacoes(){
        String msg, dataFormatada;
        
        System.out.println("Todas as transacoes:");
        
        transacoes.sort((t1, t2) -> t1.getData().compareTo(t2.getData()));
        
        for(Transacao t : transacoes) {
            dataFormatada = GerenciarData.formatarDada(t.getData());
            
            if(t.tipoTransacao == "Transferencia"){
                msg = "ID: " + t.getIdTransacao() + ", Tipo: " + t.getTipoTransacao() + ", Valor: R$" + t.getValor() + ", Conta de destino: " + t.getDestinatario() + ", Data: " + dataFormatada;
            } else {
                msg = "ID: " + t.getIdTransacao() + ", Tipo: " + t.getTipoTransacao() + ", Valor: R$" + t.getValor() + ", Data: " + dataFormatada;
            }
            System.out.println(msg);
        }
        System.out.println("----------------------------------------------------------");
    }
}
