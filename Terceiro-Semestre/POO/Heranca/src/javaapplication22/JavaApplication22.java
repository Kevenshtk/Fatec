package javaapplication22;

public class JavaApplication22 {

 
    public static void main(String[] args) {
        //Pessoa p = new Pessoa();
        Aluno a = new Aluno("João", 20, "111111", 1234, "Superior");
        Funcionario f = new Funcionario("Maria", 21, "11431111", "algum", 6);
        Professor pr = new Professor("Pedro", 24, "1131111", "todas", 1000);
        
        a.exibirAluno();
        System.out.println("------------------");
        f.exibirFuncionario();
        System.out.println("------------------");
        pr.exibirProfessor();
        
        /*p.setNome("a");
        p.setIdade(1);
        p.setCpf("123445");
        
        a.setNome("a");
        a.setEscolaridade("medip");
        a.setMatricula(12);
        
        f.setNome("tai");
        f.setCargo("engi");
        
        pr.setNome("dsad");
        pr.setSalario(2000);
        pr.receberAumento(400);
        
        System.out.println(p.toString());
        System.out.println(a.toString());
        System.out.println("Nome do aluno: "+ a.getNome());
        System.out.println(f.toString());
        System.out.println(pr.toString());*/
    }
    
}
