create database dbGerCli;

use dbGerCli;

create table tbusuario(
	cpf int primary key,
    nome varchar(50) not null,
    endereco varchar(50),
    numero varchar(5),
    bairro varchar(50),
    cep varchar(15),
    cidade varchar(20),
    estado varchar(20),
    telefone varchar(15),
    email varchar(30) unique,
    ativo varchar(20) not null
);
select * from tbusuario;



insert into tbusuario(cpf, nome, endereco, numero, bairro, cep, cidade, 
estado, telefone, email, ativo) values(1, 'José alves', 'Rua 1', '123', 'centro', '1900000', 'Ourinhos', 'SP',
 '9999-9999', '', 1);

insert into tbusuario(cpf, nome, endereco, numero, bairro, cep, cidade, 
estado, telefone, email, ativo) values(2, 'Administrador', 'Rua 1', '123', 'centro', '1900000', 'Ourinhos', 'SP', 
'9999-9999', 'admin@hotmail.com', 1);


