package projeto_agenciabancaria;


import projeto_agenciabancaria.banco.Banco;
import projeto_agenciabancaria.cliente.Cliente;
import projeto_agenciabancaria.conta.ContaSalario;
import projeto_agenciabancaria.conta.ContaPoupanca;
import projeto_agenciabancaria.conta.ContaCorrente;
import projeto_agenciabancaria.invest.Cdb;
import projeto_agenciabancaria.invest.FundosDeInvestimento;
import projeto_agenciabancaria.invest.Poupanca;
import projeto_agenciabancaria.transacao.Deposito;
import projeto_agenciabancaria.transacao.Saque;
import projeto_agenciabancaria.transacao.Transferencia;

public class Projeto_AgenciaBancaria {

    public static void main(String[] args) {
        //BANCO
        Banco caixa = new Banco(1, "Caixa", "Fisco", "2134567878-0");
        
        caixa.adicionarEndereco(new Endereco("16543-546", "Alvorada", 1500, "Aquela", "Nao sei", "SA"));
        
        Endereco endA1 = new Endereco("21435-980", "Alvaro", 123, "todos", "Sao Paulo", "SP");
        Endereco endA2 = new Endereco("21735-910", "Cabral", 132, "ali", "Lins", "SP");
        Endereco endA3 = new Endereco("21735-930", "Pedro", 213, "alguma", "Lins", "SP");
        
        Agencia a1 = new Agencia(1, "001", "231456457-0", endA1);
        Agencia a2 = new Agencia(2, "002", "231456457-1", endA2);
        Agencia a3 = new Agencia(3, "003", "231456457-2", endA3);
        
        caixa.adicionarAgencia(a1);
        caixa.adicionarAgencia(a2);
        caixa.adicionarAgencia(a3);
        caixa.removerAgencia(a3);
        caixa.buscarAgenciaPorCidade("Lins");
        caixa.exibirBanco();
        
        
        
        //CLIENTE
        Cliente cli1 = new Cliente("Arnaldo", "123445", new Endereco("1", "alguma", 24, "todos", "aquela", "rj"));
        
        ContaCorrente cc1 = new ContaCorrente(3, "3", 0, 0, 20, new Senha(1, "123"));      
        ContaPoupanca cp1 = new ContaPoupanca(2, "2", 4000, 1000, new Senha(2, "1234"));       
        ContaSalario cs1 = new ContaSalario(1, "1", 500, 500, new Senha(3, "12345"));
        
        cli1.adicionarConta(cc1);
        cli1.adicionarConta(cp1);
        cli1.adicionarConta(cs1);
        cli1.listarContas();
        
        //TRANSAÇÃO
        
        //deposito
        Deposito d1 = new Deposito(1, 50, cc1, "2024/02/12");
        Deposito d2 = new Deposito(2, 100, cp1, "2023/02/12");
        Deposito d3 = new Deposito(3, 1000, cs1, "2025/02/12");
        cc1.realizarTransacao(d1);
        cc1.realizarTransacao(d2);
        
        //saque
        Saque s1 = new Saque(4, 1, cc1, "2024/02/12");
        
        try{
            cc1.realizarTransacao(s1);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
        
        //transferencia
        Transferencia t1 = new Transferencia(5, cc1, 1, cp1, "2024/02/15");
        try{
            cc1.realizarTransacao(t1);
        }  catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
        
        
        //SENHA
        System.out.println(cc1.getSenha().criptografia("123"));
        
        System.out.println(cc1.getSenha().redefinirSenha(
            "scs", cc1.getSenha().validarSenha("scs"))
        );
        
        
        //CLIENTE 2
        Cliente cli2 = new Cliente("Noe", "134679", new Endereco("2", "ali", 36, "aquele", "nao sei", "sp"));
        
        ContaSalario cs2 = new ContaSalario(4, "4", 100, 100, new Senha(4, "12423"));
        ContaPoupanca cp2 = new ContaPoupanca(5, "5", 3000, 3000, new Senha(5, "13223"));    
        ContaCorrente cc2 = new ContaCorrente(6, "6", 5000, 5000, 50, new Senha(6, "1233"));
        
        // MÉTODOS DE TESTE
        //cli2.adicionarConta(cc2);
        //cli2.removerConta(cc2);
        //cli2.listarContas();
        
       
        
        //INVESTIMENTO
        Cdb cdb1 = new Cdb(1, 10, 100, 10, "2020/10/02");
        Cdb cdb2 = new Cdb(2, 10, 10, 10, "2021/05/20");
        Poupanca p1 = new Poupanca(3, 10, "2022/01/30");
        FundosDeInvestimento f1 = new FundosDeInvestimento(4, 500, 10, 10, 10, "2023/01/02");
        
        cc1.realizarInvestimento(cdb1, cc1);
        cc1.realizarInvestimento(p1, cc1);
        

        cc1.gerarExtrato();
    }   
}