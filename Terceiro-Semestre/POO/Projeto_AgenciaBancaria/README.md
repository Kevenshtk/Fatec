# Agência Bancária

## Sobre o projeto

 O projeto foi desenvolvido no 3º semestre do curso, durante a disciplina de POO (Programação Orientada a Objetos), cursada no segundo semestre do ano de 2024 e ministrada pelo professor Diego Henrique Emygdio Lázaro.
 
 O sistema trata-se de uma aplicação que busca simula o funcionamento de uma agência bancária, utilizando conceitos fundamentais de POO e os princípios SOLID.

### Objetivo

 O objetivo foi desenvolver um sistema para uma agência bancária usando conceitos estudados em aula, como:
 - **Os Três pilares**
     - **Encapsulamento**: esconde os detalhes internos de um objeto.
     - **Herança**: capacidade de classes herdarem propriedades de uma superclasse.
     - **Polimorfismo de sobrescrita**: permite que uma subclasse forneça uma implementação específica de um método já definido na superclasse, mantendo sua assinatura.

 - **Classes Abstratas**: serve como base ou modelo para as classes filhas.
 - **Agregação**: uma classe (todo) contém outra (parte), porém a parte pode existir independentemente do todo.
 - **Composição**: uma classe (todo) contém outra (parte), porém a parte não pode existir independentemente do todo.

 - **Os princípios SOLID**
    - **S (Princípio da Responsabilidade Única)**: Cada classe deve ter apenas uma única
    responsabilidade. Escolhido por perceber que a grande maioria das classes estavam
    com muitas responsabilidades.
    - **O (Princípio Aberto/Fechado)**: As classes devem estar abertas para extensão, mas
    fechadas para modificação. Ao perceber classes que não era possível implementar
    novas funcionalidade sem modificar o que já tinha sido feito surgiu a ideia de aplicar o
    princípio O.
    - **L (Princípio da Substituição de Liskov)**: Uma subclasse deve poder substituir sua
    classe base sem alterar a funcionalidade do programa. O princípio L foi escolhido por
    conta da forte dependência que havia no projeto entre as classes filhas e a classe mãe.
    - **I (Princípio da Segregação de Interfaces)**: Uma classe não deve ser forçada a
    implementar interfaces que não utiliza. O princípio I não foi plenamente aplicado, já que o projeto não utilizou interfaces, mas é importante considerá-lo para evitar obrigar classes a implementarem métodos desnecessários em interfaces genéricas.
    - **D (Princípio da Inversão de Dependências)**: Embora não tenha sido implementado, o princípio D recomenda que módulos de alto nível não dependam diretamente de módulos de baixo nível, mas sim de abstrações, como interfaces ou classes abstratas.

## Tecnologia Utilizada

 <div>
    <img align="center" src="https://skillicons.dev/icons?i=java" alt="icone Java"/>
 </div>

## Funcionalidades

### Banco
- Cadastro
- Adição, remoção e listagem de agências
- Busca de agências por cidade
- Exibir informações

### Clientes
- Cadastro
- Adição e remoção de contas
- Listagem de contas
- Consultar informações

### Contas
- Tipos:
    - Corrente
    - Poupança
    - Salário
- Operações:
    - Depósito
    - Saque
    - Transferência
- Gerar extrato
- Realizar investimentos

### Cartões
- Tipos:
    - Debito
    - Crédito
- Cadastro
- Consultar informações

### Investimentos
- Tipos:
    - Poupança
    - CDB
    - Fundo de investimentos
- Cadastro de títulos
- Calculo de rendimento

## Diagrama de Classes

![Diagrama de Classes antes da aplicação do SOLID](https://kevenshtk.github.io/Fatec/Terceiro-Semestre/POO/Projeto_AgenciaBancaria/src/assets/antesSOLID.png)
*Diagrama de classe antes da aplicação do SOLID.*

![Diagrama de Classes depois da aplicação do SOLID](https://kevenshtk.github.io/Fatec/Terceiro-Semestre/POO/Projeto_AgenciaBancaria/src/assets/depoisSOLID.png)
*Diagrama de classe depois da aplicação do SOLID*

No diagrama acima, as cores possuem o seguinte significam: amarelo representa classes comuns, azul classes abstratas, verde classes filhas e cinza classes auxiliares. 
