create table clientes (
    codigo number(7),
    nome varchar2(100),
    sexo varchar2(1),

    constraint pkclientes primary key(codigo)
)

alter table clientes add cidade varchar2(20)
alter table clientes modify cidade not null
alter table clientes add bairro varchar2(20)
alter table clientes add constraint cksexo check(sexo in ('F', 'M'))

insert into clientes values (1, 'teste1', 'M', 'cidade1', 'bairro1');
insert into clientes values (2, 'teste2', 'M', 'cidade2', 'bairro2');
insert into clientes values (3, 'teste3', 'F', 'cidade3', 'bairro3');

update clientes set sexo = 'F';
update clientes set cidade = 'cidade3' where codigo = 2;
update clientes set bairro = 'bairro2' where codigo = 3;

delete from clientes where nome = 'teste1';
delete from clientes where cidade = 'cidade3';
delete from clientes;