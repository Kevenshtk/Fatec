create table clientes(
    codigo number(7),
    nome varchar2(100),
    idade number(3),
    cidade varchar2(100)
)

alter table clientes add (UF varchar2(2), sexo varchar2(2))

alter table clientes add constraint pkClientes primary key(codigo)

alter table clientes modify nome not null

alter table clientes modify idade default 18

alter table clientes add constraint chkCidade check (cidade <> '')

desc clientes