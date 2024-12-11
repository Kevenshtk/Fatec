package projeto_agenciabancaria.invest;

import java.util.ArrayList;
import java.util.List;
import projeto_agenciabancaria.GerenciarData;

public class HistoricoDeInvestimentos {
    private List<Investimento>investimentos;
    private GerenciarData GerenciarData = new GerenciarData();
    
     public HistoricoDeInvestimentos() {
        this.investimentos = new ArrayList<>();
    }
     
    public void registarInvestimento(Investimento produto){
        investimentos.add(produto);
    }
    
    public void listarInvestimentos(){
        String dataFormatada;
        
        System.out.println("Todas os investimentos:");
        
        investimentos.sort((i1, i2) -> i1.getData().compareTo(i2.getData()));
        
        for(Investimento i : investimentos) {
            dataFormatada = GerenciarData.formatarDada(i.getData());
            
            System.out.println(i.getIdInvestimento() + " Investimento do tipo: " + i.getTipoInvestimento()+ ", Valor: R$" + i.getValorInvestido() + ", Data: " + dataFormatada);
        }
        System.out.println("----------------------------------------------------------");
    }
}
