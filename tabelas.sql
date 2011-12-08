CREATE TABLE usuario
(
idUsuario INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nomeUsuario VARCHAR(1000) NOT NULL,
senha varchar(100),
CONSTRAINT primary_key PRIMARY KEY (idUsuario)
);

create table produto(
idProduto integer not null generated always as identity(start with 1, increment by 1),
nomeProduto varchar(100) not null,
valorUnitario float not null,
imagem varchar(100),
qtdeestoque integer not null,
constraint primary_key_produto PRIMARY KEY (idProduto)
);

create table notafiscal(
idNota integer not null generated always as identity (start with 1, increment by 1),
nomeCliente varchar(100) not null,
dataemissao date,
constraint primary_key_notafiscal primary key(idNota)
);

create table itemnota(
idNota integer not null,
idProduto integer not null,
qtde integer not null,
valorunitario float not null,
constraint foreign_key_notafiscal foreign key(idNota) references app.notafiscal(idNota),
constraint foreign_key_produto foreign key(idProduto) references app.produto(idProduto)
);