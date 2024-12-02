package pkginterface;

public class CartaoCredito implements Pagamento, Autenticacao{
    private String status;

    @Override
    public void realizarPagamento(double valor) {
        System.out.println("Processando pagamento no valor de:"+ valor);
        status = "Pagamento no crédito com sucesso";
     
    }

    @Override
    public String oberStatus() {
        return status;
    }

    @Override
    public boolean autenticar(String usuario, String senha) {
        return usuario.equals("admin") && senha.equals("123");
    }
    
    
}
