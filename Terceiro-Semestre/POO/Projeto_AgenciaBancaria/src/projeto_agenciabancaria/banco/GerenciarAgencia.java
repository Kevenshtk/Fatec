package projeto_agenciabancaria.banco;

import java.util.ArrayList;
import java.util.List;
import projeto_agenciabancaria.Agencia;

public class GerenciarAgencia {
    private List<Agencia> agencias = new ArrayList<>();
    
    
    public void executarAddAgencia(Agencia a){
        agencias.add(a);
        System.out.println("Agencia adicionada com sucesso !\n");
    }
    
    public void executarRmAgencia(Agencia a){
        agencias.remove(a);
        System.out.println("Agencia removida com sucesso !\n");
    }
    
    public void executarListAgencia(){
        for(Agencia agencia : agencias){
            agencia.exibir();
        }
        System.out.println("-----------------------------------------------------------\n");
    }
    
    public void executarBuscAgenciaCidade(String cidade){
        boolean achou = false;
        
        for(Agencia agencia : agencias){
            if(cidade == agencia.getCidade()){
                agencia.exibir();
            }
            System.out.println("-----------------------------------------------------------\n");
        }
        
        if(!achou){
            System.out.println("Nao possui agencia(s) nessa cidade....\n");
        }
    }
}
