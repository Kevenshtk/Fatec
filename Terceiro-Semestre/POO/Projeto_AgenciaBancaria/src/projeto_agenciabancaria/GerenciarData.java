package projeto_agenciabancaria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class GerenciarData {
    
    public String formatarDada(String data){
        DateTimeFormatter formatoEUA = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate dataConvert = LocalDate.parse(data, formatoEUA);
            
        DateTimeFormatter formatoBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataConvert.format(formatoBR);
        
        return dataFormatada;
    }
}
