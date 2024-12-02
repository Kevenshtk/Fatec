package pkginterface;

public class BoletoBancario implements Pagamento{
    private String status;
    
    @Override
    public void realizarPagamento(double valor) {
        System.out.println("Gerado boleto no valor de:"+ valor);
        status = "Boleto gerado, aguardando pagamento";
    }

    @Override
    public String oberStatus() {
     return status;
    }
    
}
