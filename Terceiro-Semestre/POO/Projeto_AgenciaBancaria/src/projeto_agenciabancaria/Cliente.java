package projeto_agenciabancaria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import projeto_agenciabancaria.conta.Conta;
import projeto_agenciabancaria.conta.Transferencia;
import projeto_agenciabancaria.conta.Depositar;
import projeto_agenciabancaria.conta.Sacar;
import projeto_agenciabancaria.conta.Transacao;
import projeto_agenciabancaria.invest.Investimento;

public class Cliente {
    private String id;
    private String nome;
    private String cpf;
    private Endereco endereco;
    private List<Conta> contas = new ArrayList<>();
    private List<Transferencia> transferencias = new ArrayList<>();
    private List<Depositar> depositos = new ArrayList<>();
    private List<Sacar> saques = new ArrayList<>();
     private List<Investimento> investimentos = new ArrayList<>();

    public Cliente(String nome, String cpf, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public Conta getConta(String numConta) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numConta)) {
                return conta;
            }
        }
    System.out.println("Conta nao encontrada.");
    
    return null;
    }
    
    public Investimento getInvestimento(int id) {
        for (Investimento produto : investimentos) {
            if (produto.getIdInvestimento() == id) {
                return produto;
            }
        }
    System.out.println("Investimento nao encontrada.");
    
    return null;
    }
    
    public void adicionarConta(Conta conta){
        contas.add(conta);
    }
    
    public void removerConta(String numConta){
        boolean achou = false;
        
        for (Conta conta : contas) {
            if(conta.getNumero() == numConta){
                achou = true;
                contas.remove(conta);
                System.out.println("Conta removida com sucesso !\n");
                return;
            }
        }
        
        if(!achou){
            System.out.println("Conta nao encontrada....\n");
        }
    }
    
    public void registrarTransferencia(Conta remetente, Conta destinatario, double valor, String data) {
        Transferencia transferencia = new Transferencia(
            transferencias.size() + 1, "Transferencia da conta " + remetente.getNumero() + " para " + destinatario.getNumero(), remetente, destinatario, valor, data);
        
        transferencias.add(transferencia);
    }
    
    public void registrarDeposito(Conta destinatario, double valor, String data){
        Depositar deposito = new Depositar(depositos.size() + 1, destinatario, valor, data); 
        depositos.add(deposito);
    }
    
    public void registrarSaque(Conta destinatario, double valor, String data){
        Sacar saque = new Sacar(saques.size() + 1, destinatario, valor, data);
        saques.add(saque);
    }
    
    public void registarInvestimento(Investimento produto){
        investimentos.add(produto);
    }
    
    public void listarTransacoes(String numConta) {
        List<Transacao> todasTransacoes = new ArrayList<>();

        for(Transferencia t : transferencias) {
        Conta numContaTrans = t.getRemetente();
        if (numConta.equals(numContaTrans.getNumero())) {
            todasTransacoes.add(new Transacao(t.getId(), "Transferencia", t.getDescricao(), t.getValor(), t.getData()));
        }
    }

        for(Depositar d : depositos) {
        Conta numContaDepos = d.getDestinatario();
        if (numConta.equals(numContaDepos.getNumero())) {
            todasTransacoes.add(new Transacao(d.getId(), "Deposito", "Deposito na conta", d.getValor(), d.getData()));
        }
    }

        for(Sacar s : saques) {
        Conta numContaSaque = s.getDestinatario();
        if (numConta.equals(numContaSaque.getNumero())) {
            todasTransacoes.add(new Transacao(s.getId(), "Saque", "Saque na conta", s.getValor(), s.getData()));
        }
    }

        for(Investimento i : investimentos) {
        todasTransacoes.add(new Transacao(i.getIdInvestimento(), "Investimento", "Investimento do tipo " + i.getTipoInvestimento(), i.getValorInvestido(), i.getData()));
    }

        Collections.sort(todasTransacoes, Comparator.comparing(Transacao::getData));

        System.out.println("Historico de Transacoes:\n");
        for (Transacao transacao : todasTransacoes) {
            DateTimeFormatter formatoEUA = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate dataConvert = LocalDate.parse(transacao.getData(), formatoEUA);
            
            DateTimeFormatter formatoBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dataFormatada = dataConvert.format(formatoBR);
            
            System.out.println("ID: " + transacao.getId() + ", Tipo: " + transacao.getTipo() + ", Descricao: " + transacao.getDescricao() + ", Valor: R$" + transacao.getValor() + ", Data: " + dataFormatada);
        }
        System.out.println("-----------------------------");
}
    
    
    // MÉTODOS DE TESTE
    public void listarContas(){
        for (Conta conta : contas) {
            System.out.println("Identificador: "+conta.getId());
            System.out.println("Numero da conta: "+conta.getNumero());
            System.out.println("Saldo: $"+conta.getSaldo());
            System.out.println("-----------------------------");
        }
    }

    public void exibir() {
        System.out.println("Nome: "+nome+"\nCPF: "+cpf);
        System.out.println("Endereco Cliente "+ endereco.toString());
        System.out.println("-----------------------------");
    }
}