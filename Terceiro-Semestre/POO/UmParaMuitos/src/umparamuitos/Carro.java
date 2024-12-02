package umparamuitos;


public class Carro {
    private String marca;
    private String modelo;
    private Pessoa proprietario;

    public Carro(String marca, String modelo, Pessoa proprietario) {
        this.marca = marca;
        this.modelo = modelo;
        this.proprietario = proprietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public String toString() {
        return "Carro{" + "marca=" + marca + ", modelo=" + modelo + ", proprietario=" + proprietario.getNome() + '}';
    }
    
    
}
