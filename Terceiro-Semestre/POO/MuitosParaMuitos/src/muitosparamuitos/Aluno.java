package muitosparamuitos;

import java.util.ArrayList;
import java.util.List;


public class Aluno {
    private String nome;
    private List<Matricula> matriculas;

    public Aluno(String nome) {
        this.nome = nome;
        this.matriculas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void adicionarMatriculas(Matricula matricula) {
        matriculas.add(matricula);
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome=" + nome + '}';
    }

}
