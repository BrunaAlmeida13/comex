create table Cliente (
	id bigint not null auto_increment primary key,
	id_endereco bigint not null,
	nome varchar(45),
	cpf varchar(45),
	telefone varchar(45)
);

create table Endereco (
	id bigint not null auto_increment primary key,
	rua varchar(45),
	numero int,
	complemento varchar(50),
	bairro varchar(45),
	cidade varchar(45),
	estado varchar(20)
);

alter table Cliente
add constraint fk_endereco_cliente 
foreign key (id_endereco) references Endereco(id);

create table Categoria (
	id bigint not null auto_increment primary key,
	nome varchar(45),
	cpf varchar(45),
	`status` tinyint
);

create table Produto (
	id bigint not null auto_increment primary key,
	id_categoria bigint not null,
	nome varchar(45),
	descricao varchar(45),
	preco_unitario double,
	quantidade_estoque int
);

alter table Produto 
add constraint fk_categoria_produto
foreign key (id_categoria) references Categoria(id);

create table Pedido (
	id bigint not null auto_increment primary key,
	id_cliente bigint not null,
	data date,
	desconto double,
	tipo_desconto enum('FIDELIDADE', 'NENHUM')
);

alter table Pedido
add constraint fk_cliente_produto
foreign key (id_cliente) references Cliente(id);

create table Item_Pedido (
	id bigint not null auto_increment primary key,
	id_pedido bigint not null,
	id_produto bigint not null,
	preco_unitario double,
	quantidade int,
	desconto double,
	tipo_desconto enum('QUANTIDADE', 'PROMOCAO', 'NENHUM')
);

alter table Item_Pedido
add constraint fk_pedido_item_pedido
foreign key (id_pedido) references Pedido(id);

alter table Item_Pedido
add constraint fk_produto_item_pedido
foreign key (id_produto) references Produto(id);