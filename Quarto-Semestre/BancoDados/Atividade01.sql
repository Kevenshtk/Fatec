create table cliente(
    codigo number(7),
    nome varchar2(50),
    rg varchar2(11),
    cpf varchar2(11),
    cidade varchar2(10),

    constraint pkCliente primary key(codigo)
)

create table ordemServico(
    numos number(7),
    data Date,
    codCliente number(7),
    total number(7, 2),

    constraint pkOrdemServico primary key(numos),
    constraint fkCliente foreign key(codCliente)
     references cliente(codigo)
)

create table servico(
    codigo number(7),
    descricao varchar2(100),
    valorRef number(7, 2),

    constraint pkServico primary key(codigo)
)

create table itensOrdemServico(
    numItem number(7),
    numos number(7),
    codServico number(7),
    valor number(7, 2),

    constraint pkIntensOrdemServico primary key(numItem, numos),
    constraint fkOrdemServico foreign key(numos)
     references ordemServico(numos),
    constraint fkServico foreign key(codServico)
     references servico(codigo)
)