package muitosparamuitos;

import java.time.LocalDate;


public class Matricula {
    private Aluno aluno;
    private Curso curso;
    private LocalDate dataMatricula;

    public Matricula(Aluno aluno, Curso curso) {
        this.aluno = aluno;
        this.curso = curso;
        this.dataMatricula = LocalDate.now();
        
        aluno.adicionarMatriculas(this);
        curso.adicionarMatriculas(this);
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    @Override
    public String toString() {
        return "Matricula{" + "aluno=" + aluno + ", curso=" + curso + ", dataMatricula=" + dataMatricula + '}';
    }
    
    
}
