package projeto_agenciabancaria;


import projeto_agenciabancaria.conta.ContaSalario;
import projeto_agenciabancaria.conta.Conta;
import projeto_agenciabancaria.conta.ContaPoupanca;
import projeto_agenciabancaria.conta.ContaCorrente;
import projeto_agenciabancaria.invest.Cdb;
import projeto_agenciabancaria.invest.FundosDeInvestimento;
import projeto_agenciabancaria.invest.Poupanca;

public class Projeto_AgenciaBancaria {

    public static void main(String[] args) {
        //BANCO
        Banco caixa = new Banco("1", "Caixa", "Fisco", "2134567878-0");
        caixa.adicionarEndereco(new Endereco("16543-546", "Alvorada", 1500, "Aquela", "Nao sei", "SA"));
        caixa.adicionarAgencia(new Agencia(1, "001", "231456457-0", new Endereco("21435-980", "Alvaro", 123, "todos", "Sao Paulo", "SP")));
        caixa.adicionarAgencia(new Agencia(2, "002", "231456457-1", new Endereco("21735-910", "Cabral", 132, "ali", "Lins", "SP")));
        caixa.adicionarAgencia(new Agencia(3, "003", "231456457-2", new Endereco("21735-930", "Pedro", 213, "alguma", "Lins", "SP")));
        
        caixa.exibirBanco();
        
        // MÉTODOS DE TESTE
        //caixa.removerAgencia("002");
        //caixa.buscarAgenciaPorCidade("Lins");
        //caixa.exibirBanco();
        
        
        //CLIENTE
        Cliente cli1 = new Cliente("Arnaldo", "123445", new Endereco("1", "alguma", 24, "todos", "aquela", "rj"));
        cli1.adicionarConta(new ContaCorrente("3", "3", 1000, 0, 20, new Senha("1", "123")));
        cli1.adicionarConta(new ContaPoupanca("2", "2", 4000, 1000, new Senha("2", "1234")));
        cli1.adicionarConta(new ContaSalario("1", "1", 500, 500, new Senha("3", "12345")));
        
        cli1.getConta("3").depositar(cli1.getConta("3"), 1000, cli1, "2024/02/12");
        cli1.getConta("2").depositar(cli1.getConta("3"), 2000, cli1, "2023/02/12");
        cli1.getConta("1").depositar(cli1.getConta("3"), 2000, cli1, "2025/02/12");
        
        try{
            cli1.getConta("3").sacar(cli1.getConta("3"), 100000, cli1, "2022/03/15");
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
        
        try{
            cli1.getConta("3").sacar(cli1.getConta("3"), 500, cli1, "2020/03/15");
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
        
        cli1.getConta("3").getSenha().redefinirSenha("scs");
        System.out.println(cli1.getConta("3").getSenha().criptografia("scs"));
        
        
        Cliente cli2 = new Cliente("Noe", "134679", new Endereco("2", "ali", 36, "aquele", "nao sei", "sp"));
        cli2.adicionarConta(new ContaSalario("4", "4", 100, 100, new Senha("4", "12423")));
        cli2.adicionarConta(new ContaPoupanca("5", "5", 3000, 3000, new Senha("5", "13223")));
        cli2.adicionarConta(new ContaCorrente("6", "6", 5000, 5000, 50, new Senha("6", "1233")));
        
        cli2.removerConta("6");
        
        try{
            cli1.getConta("3").transferir(cli1.getConta("2"), cli1.getConta("3"), 500, cli1, "2025/01/02");
        }  catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
        
        
        // MÉTODOS DE TESTE
       /*cli1.exibir();
        cli1.listarContas();*/
        
       
        //INVESTIMENTO
        cli1.getConta("3").Investir(new Cdb(1, "CDB", 10000, 10, 10, "2020/10/02"), cli1.getConta("3"), cli1);
        cli1.getConta("2").Investir(new Cdb(2, "CDB", 100, 10, 10, "2021/05/20"), cli1.getConta("2"), cli1);
        cli1.getConta("3").Investir(new Poupanca(3, "Poupanca", 8000, "2022/01/30"), cli1.getConta("3"), cli1);
        cli1.getConta("2").Investir(new FundosDeInvestimento(4, "Fundos de Investimento", 500, 10, 10, 10, "2023/01/02"), cli1.getConta("2"), cli1);
        
        
        cli1.getInvestimento(4).calcularRendimento();
        
        // MÉTODOS DE TESTE
        //cli1.getInvestimento(1).calcularRendimento();
        
        
        //RELATORIO
        cli1.listarTransacoes("3");
        
    }   
}