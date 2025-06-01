create table cliente(
    codigo number(7),
    nome varchar2(20),
    rg varchar2(10),
    cidade varchar2(20),

    constraint pkCliente primary key(codigo)
)

create table listaDesejo(
    codigo number(7),
    nome varchar2(20),
    data Date,
    codCliente number(7),

    constraint pkListaDesejo primary key(codigo),
    constraint fkCliente foreign key(codCliente) references cliente(codigo)  
)

create table categoria(
    codigo number(7),
    decricao varchar2(100),

    constraint pkCategoria primary key(codigo)
)

create table produto(
    codigo number(7),
    nome varchar2(20),
    codCategoria number(7),

    constraint pkProduto primary key(codigo),
    constraint fkCategoria foreign key(codCategoria) references categoria(codigo) 
)

create table produtoDesejo(
    codProduto number(7),
    codListaDesejo number(7),

    constraint fkProduto foreign key(codProduto) references produto(codigo),
    constraint fkListaDesejo foreign key(codListaDesejo) references listaDesejo(codigo)
)

alter table produtoDesejo add constraint pkProdutoDesejo primary key(codProduto, codListaDesejo)
alter table cliente modify nome not null
alter table produto add check (nome <> '')

insert into cliente values (1, "teste1", "rg1", "cidade1");
insert into cliente values (2, "teste2", "rg2", "cidade2");
insert into cliente values (3, "teste3", "rg3", "cidade3");

insert into listaDesejo values (1, "teste1", 2001/01/01, 1);
insert into listaDesejo values (2, "teste2", 2002/02/02, 2);
insert into listaDesejo values (3, "teste3", 2003/03/03, 3);

insert into categoria values (1, "categoria1");
insert into categoria values (2, "categoria 2");
insert into categoria values (3, "categoria3");

insert into produto values (1, "produto", 1);
insert into produto values (2, "produto2", 2);
insert into produto values (3, "produto3", 3);

update cliente set nome = "nome1" where id = 1;
update listaDesejo set nome = "lista3" where id = 3;
update categoria set descricao = "categoria2" where id = 2;
update produto set nome = "produto1" where id = 1;