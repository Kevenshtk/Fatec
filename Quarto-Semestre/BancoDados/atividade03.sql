create table clientes (
    codigo number(7),
    nome varchar2(100),
    sexo varchar2(2),

    constraint pkclientes primary key(codigo)
)

alter table clientes add cidade varchar2(20)
alter table clientes modify cidade not null
alter table clientes add bairro varchar2(20)
alter table clientes add constraint cksexo check(sexo in ('F', 'M'))

desc clientes

create table pedido (
    codigo number(7),
    data Date,
    valor number(7,2),
    codCliente number(7),

    constraint pkpedido primary key(codigo),
    constraint fkclientes foreign key(codCliente) references clientes(codigo)
)

alter table pedido add constraint ckvalor(pedido >= 0)
alter table pedido modify valor not null
alter table pedido rename data to dataPedido
