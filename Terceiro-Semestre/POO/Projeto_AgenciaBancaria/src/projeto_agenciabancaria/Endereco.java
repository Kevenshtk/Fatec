package projeto_agenciabancaria;

public class Endereco {
   private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String complemento;
    private String pontoReferencia;

    public Endereco(String cep, String rua, int numero, String bairro, String cidade, String estado) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    @Override
    public String toString() {
        return "Rua " + rua + ", N " + numero + " - Bairro " + bairro + " - Cidade " + cidade + " / " + estado + " - CEP: " + cep + " - Complemento: " + complemento + " - Ponto de Referencia: " + pontoReferencia;
    }
    
    
}
