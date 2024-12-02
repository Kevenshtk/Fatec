package pkginterface;

public class Interface {

    public static void main(String[] args) {
        CartaoCredito cc = new CartaoCredito();
        
        if(cc.autenticar("admin", "123")){
            cc.realizarPagamento(150.0);
            System.out.println(cc.oberStatus());
        } else {
            System.out.println("Falha de autenticacao");
        }
        
        System.out.println("-----------------------------");
        BoletoBancario b = new BoletoBancario();
        b.realizarPagamento(50.0);
        System.out.println(b.oberStatus());
    }
    
}
