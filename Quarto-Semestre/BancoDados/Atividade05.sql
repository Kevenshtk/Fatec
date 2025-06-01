create table categoria(
    codigo number(7),
    nome varchar2(20) not null
);

create table livros(
    codigo number(7),
    titulo varchar2(50),
    autor varchar2(20),
    editora varchar2(20),
    anoPublicacao varchar2(4),
    codCategoria number(7),

    constraint pkLivro primary key(codigo),
    constraint fkCategoria foreign key(codCategoria) references categoria(codigo)
);

create table edicoes(
    numeroEdicao number(7),
    anoImpressao varchar2(4),
    quantidadeExemplares number(7),
    codLivro number(7),

    constraint pkEdicao primary key(numeroEdicao),
    constraint fkLivro foreign key(codLivro) references livros(codigo)
);

create table alunos(
    matricula number(7),
    nome varchar2(20) not null,
    curso varchar2(20),
    telefone varchar2(12),

    constraint pkAluno primary key(matricula)
);

create table emprestimo(
    dataEmpestimo varchar2(11),
    dataPrevistaDevolucao varchar2(11),
    dataDevolucao varchar2(11),
    codLivro number(7),
    matriAluno number(7),
    codFunc number(7),

    constraint fkLivro foreign key(codLivro) references livros(codigo),
    constraint fkAluno foreign key(matriAluno) references alunos(matricula),
    constraint fkFunc foreign key(codFunc) references funcionarios(codigo)
);

create table funcionario(
    codigo number(7),
    nome varchar2(20),

    constraint pkFunc primary key(codigo)
);

alter table categoria add constraint pkCategoria primary key(codigo);
alter table livros modify titulo not null;
alter table edicoes add constraint ckQuantExem check(quantidadeExemplares > 0);
alter table alunos modify curso not null;
alter table emprestimo modify dataEmpestimo not null;
alter table funcionario modify nome not null;

insert into categoria values (1, 'Acao');
insert into categoria values (1, 'Literatura');
insert into livros values (1, 'teste1', 'autor1', 'editora1', '2000');
insert into livros values (2, 'teste2', 'autor2', 'editora2', '2002');
insert into edicoes values (1, '2000', 5);
insert into edicoes values (2, '2002', 6);
insert into alunos values (1, 'aluno1', 'curso1', '1472588-1');
insert into alunos values (2, 'aluno2', 'curso2', '1472588-2');
insert into emprestimo values ('01/01/2001', '02/02/2002', '03/03/2003');
insert into emprestimo values ('04/04/2004', '05/05/2005', '06/06/2006');
insert into funcionario values (1, 'func1');
insert into funcionario values (2, 'func2');

update categoria set nome = 'Ação' where nome = 'Acao';
update livros set titulo = 'teste';
update edicoes set numeroEdicao = 1 where quantidadeExemplares = 6;
update alunos set nome = 'aluno' where matricula = 1;
update emprestimo set nome = 'Ação' where nome = 'Acao';
update funcionario set nome = 'func' where codigo = 1;
