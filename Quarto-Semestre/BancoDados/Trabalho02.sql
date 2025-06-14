create table Clientes(
    codigo number(7),
    nome varchar2(100),
    rg varchar2(9),
    cpf varchar2(11),
    idade varchar2(3),
    altura number(4, 2),

    constraint pkCliente primary key (codigo)
)

create table Brinquedos(
    codigo number(7),
    nome varchar2(100),
    alturaminima number(4, 2),
    idademinima varchar2(3),
    
    constraint pkBrinquedo primary key (codigo)
)

create table Ingressos(
    codigo number(7),
    data Date,
    valor number(5,2),
    codcliente number(7),
    codbrinquedo number(7),
    datacompra Date,

    constraint pkIngressos primary key (codigo),
    constraint fkCliente foreign key (codcliente) references Clientes(codigo),
    constraint fkBrinquedo foreign key (codbrinquedo) references Brinquedos(codigo)
)


alter table Clientes modify cpf not null;
alter table Brinquedos modify nome varchar2(150);
alter table Ingressos add horario varchar2(5);
alter table Clientes rename column idade to faixa_etaria;


insert into Clientes values (1, 'Ana Paula da Silva', '123456789', '12345678901', '25', 1.65);
insert into Clientes values (2, 'Bruno Souza', '987654321', '98765432100', '30', 1.80);
insert into Clientes values (3, 'Carlos Mendes', '456789123', '45678912345', '12', 1.40);

insert into Brinquedos values (101, 'Montanha Russa', 1.50, '12');
insert into Brinquedos values (102, 'Carrossel', 0.90, '5');
insert into Brinquedos values (103, 'Roda Gigante', 1.20, '10');

insert into Ingressos values (1001, TO_DATE('2025-06-01', 'YYYY-MM-DD'), 30.00, 1, 101, TO_DATE('2025-05-30', 'YYYY-MM-DD'), '14:00');
insert into Ingressos values (1002, TO_DATE('2025-06-01', 'YYYY-MM-DD'), 15.00, 2, 102, TO_DATE('2025-05-31', 'YYYY-MM-DD'), '15:30');
insert into Ingressos values (1003, TO_DATE('2025-06-01', 'YYYY-MM-DD'), 20.00, 3, 103, TO_DATE('2025-06-01', 'YYYY-MM-DD'), '13:45');


update Clientes set altura = 1.70 where codigo = 1;
update Clientes set nome = 'Carlos Henrique Mendes' where codigo = 3;

update Brinquedos set alturaminima = 1.60 where codigo = 101;
update Brinquedos set nome = 'Carrossel Encantado' where codigo = 102;

update Ingressos set valor = 35.00 where codigo = 1001;
update Ingressos set datacompra = TO_DATE('2025-06-02', 'YYYY-MM-DD') where codigo = 1002;


select * from Clientes;
select * from Clientes where faixa_etaria > 13;

select c.codigo, c.faixa_etaria, i.valor, b.nome, b.idademinima 
    from Clientes c, Brinquedos b, Ingressos i 
    where c.codigo = i.codcliente and b.codigo = i.codbrinquedo;
    
select b.nome, b.alturaminima, i.valor 
    from Brinquedos b, Ingressos i
	where b.codigo = i.codbrinquedo;


delete from Clientes where codigo = 2;
delete from Brinquedos where codigo = 102;
delete from Ingressos where codcliente = 2;
