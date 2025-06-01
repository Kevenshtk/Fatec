create table clientes(
    codigo number(7),
    nome varchar2(50),
    rg varchar2(15),
    dtnasc Date,
    cpf varchar2(14),

    constraint pkClientes primary key(codigo)
)

create table compras(
    codigo number(7),
    total number(7, 2),
    dataCompra Date,
    codCliente number(7),

    constraint pkCompras primary key(codigo),
    constraint fkClientes foreign key(codCliente) references clientes(codigo)
)

create table categoria(
    codigo number(7),
    descricao varchar2(100),

    constraint pkCategoria primary key(codigo)
)

create table produtos(
    codigo number(7),
    descricao varchar2(100),
    total number(7, 2),
    estoque number(7),
    codCategoria number(7),

    constraint pkProdutos primary key(codigo),
    constraint fkCategoria foreign key(codCategoria) references categoria(codigo)
)

create table itensCompras(
    codCompra number(7),
    numItem number(7),
    codProduto number(7),
    qtde number(7),
    valorPago number(7,2),

    constraint pkItensCompras primary key(codCompra, numItem),
    constraint fkProdutos foreign key(codProduto) references produtos(codigo)
)

insert into clientes values (1, 'João Silva', '123456789', '1985-07-14', '123.456.789-00');
insert into clientes values (2, 'Maria Oliveira', '987654321', '1990-12-25', '987.654.321-00');
insert into clientes values (3, 'Carlos Souza', '555444333', '1982-03-10', '555.444.333-00');
insert into clientes values (4, 'Ana Costa', '112233445', '1995-09-30', '112.233.445-00');
insert into clientes values (5, 'Paulo Mendes', '667788990', '1988-06-18', '667.788.990-00');

insert into compras values (1, 150.00, '2025-05-15', 1);
insert into compras values (2, 200.00, '2025-05-16', 2);
insert into compras values (3, 120.00, '2025-05-17', 3);
insert into compras values (4, 180.00, '2025-05-18', 4);
insert into compras values (5, 220.00, '2025-05-19', 5);

insert into categoria values (1, 'Eletrônicos');
insert into categoria values (2, 'Roupas');
insert into categoria values (3, 'Alimentos');
insert into categoria values (4, 'Móveis');
insert into categoria values (5, 'Livros');


insert into produtos values (1, 'Smartphone', 999.90, 50, 1);
insert into produtos values (2, 'Camiseta', 49.90, 150, 2);
insert into produtos values (3, 'Arroz 5kg', 19.90, 100, 3);
insert into produtos values (4, 'Sofá', 899.90, 20, 4);
insert into produtos values (5, 'Livro de Tecnologia', 59.90, 30, 5);

insert into itenscompras values (1, 1, 1, 1, 999.90);
insert into itenscompras values (2, 1, 2, 2, 99.80);
insert into itenscompras values (3, 2, 3, 3, 59.70);
insert into itenscompras values (4, 3, 4, 1, 899.90);
insert into itenscompras values (5, 4, 5, 2, 119.80);
