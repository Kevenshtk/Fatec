# Livraria Alma do Saber

## Sobre o projeto

 O projeto foi desenvolvido no 3º semestre do curso, durante a disciplina de Estrutura de Dados, cursada no segundo semestre do ano de 2024 e ministrada pelo professor Júlio Fernando Lieira.
 
 O sistema trata-se de uma aplicação desktop, que busca simula o funcionamento de uma livraria, utilizando conceitos fundamentais de estrutura de dados.

### Objetivo

 O objetivo foi desenvolver um sistema de gestão para uma livraria usando conceitos estudados em aula, como:
 - **Structs**: para agrupar dados relacionados de livros, autores, clientes e vendas.
 - **Manipulação de arquivos**: leitura e escrita em arquivos binários como forma de guardar e recuperar dados.
 - **Modularização**: organização do código por funções específicas, facilitando a manutenção e leitura.
 - **Iteração sequencial**: uso de listas lineares para a leitura de dados armazenadas em arquivos.

## Tecnologia Utilizada

 <div>
    <img align="center" src="https://skillicons.dev/icons?i=c" alt="icons"/>
 </div>

## Funcionalidades

### Livros
- Cadastro de livros
- Listagem de livros com e sem autor
- Consulta por código, título, palavra-chave e autor
- Alteração de dados
- Aplicação de aumento de preço
- Exclusão de livros

### Autores
- Cadastro de autores
- Listagem
- Alteração de dados
- Relacionamento com livros

### Clientes
- Cadastro de clientes
- Listagem
- Consulta por nome
- Alteração e exclusão

### Vendas
- Efetuar vendas
- Listar vendas
- Fechamento de caixa (resumo de vendas por código)

## Observações

Este projeto utiliza arquivos `.dat` binários para simular um banco de dados. Cada operação de alteração ou exclusão recria o arquivo, garantindo a integridade dos dados.