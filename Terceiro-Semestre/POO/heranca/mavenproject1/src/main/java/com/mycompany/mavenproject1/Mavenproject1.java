package com.mycompany.mavenproject1;

public class Mavenproject1 {

    public static void main(String[] args) {
        Aluno a = new Aluno("nome", 12, "ads");
        a.exibir();
        System.out.println("--------------------");
        Professor p = new Professor("v", 32, "dasda");
        p.exibir();
    }
}