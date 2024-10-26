package mavenproject2.carro;

public class Carro extends Veiculo{
    private String cor;

    public Carro(String modelo, int ano, String cor) {
        super(modelo, ano);
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    @Override
    public void exibir(){
        super.exibir();
        System.out.println("Cor: "+cor);
    }
}
