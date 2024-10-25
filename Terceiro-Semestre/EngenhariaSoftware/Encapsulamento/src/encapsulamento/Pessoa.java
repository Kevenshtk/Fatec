package encapsulamento;

public class Pessoa {
    
    private String nome;
    private int idade;
    private String escolaridade;
    private double altura;

    public Pessoa(String nome, int idade, String escolaridade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.escolaridade = escolaridade;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", idade=" + idade + ", escolaridade=" + escolaridade + ", altura=" + altura + '}';
    }
    
}
