-- Active: 1668471960202@@127.0.0.1@3306@wassabi
use wassabi;

CREATE TABLE Produto (
	produto_id int(30) NOT NULL AUTO_INCREMENT,
	produto_imagem varchar(100),
	produto_nome varchar(30) NOT NULL,
	produto_preco double(30,2) NOT NULL,
	produto_descricao varchar(200) NOT NULL,
	produto_categoria int(30) NOT NULL,
	PRIMARY KEY (produto_id)
);

CREATE TABLE Categoria (
	categoria_id int(30) NOT NULL AUTO_INCREMENT,
	categoria_nome varchar(30) NOT NULL UNIQUE,
	categoria_descricao varchar(60) NOT NULL,
	PRIMARY KEY (categoria_id)
);

CREATE TABLE Cliente (
	cliente_id int(30) NOT NULL AUTO_INCREMENT,
	cliente_nome varchar(30) NOT NULL,
	cliente_sobrenome varchar(60) NOT NULL,
	cliente_cpf varchar(14) NOT NULL,
	cliente_telefone varchar(15) NOT NULL,
	PRIMARY KEY (cliente_id)
);

CREATE TABLE Usuario (
	usuario_id int(30) NOT NULL AUTO_INCREMENT,
	usuario_email varchar(40) NOT NULL UNIQUE,
	usuario_senha varchar(71) NOT NULL,
	usuario_tipo enum('ADMINISTRADOR','CONSUMIDOR') NOT NULL,
	usuario_cliente int(30) UNIQUE,
	PRIMARY KEY (usuario_id)
);

CREATE TABLE Endereco (
	endereco_id int(30) NOT NULL AUTO_INCREMENT,
    endereco_cliente int(30) NOT NULL,
	endereco_rua varchar(30) NOT NULL,
	endereco_bairro varchar(30) NOT NULL,
	endereco_cidade varchar(30) NOT NULL,
	endereco_estado varchar(30) NOT NULL,
    endereco_pais varchar(30) NOT NULL,
    endereco_cep varchar(10) NOT NULL,
	PRIMARY KEY (endereco_id, endereco_cliente)
);

CREATE TABLE Venda (
	venda_id int(30) NOT NULL AUTO_INCREMENT,
	venda_cliente int(30) NOT NULL,
	venda_total double(30,2) NOT NULL DEFAULT 0.0,
    venda_data DATETIME NOT NULL,
	PRIMARY KEY (venda_id)
);

CREATE TABLE venda_has_produto (
	venda_id int(30) NOT NULL,
	produto_id int(30) NOT NULL,
	quantidade int(30) NOT NULL DEFAULT '1',
	PRIMARY KEY (venda_id,produto_id)
);

CREATE TABLE Cartao (
	cartao_id int(30) NOT NULL AUTO_INCREMENT,
	cartao_cliente int(30) NOT NULL,
	cartao_numero varchar(19) NOT NULL,
	PRIMARY KEY (cartao_id,cartao_cliente)
);


ALTER TABLE Produto ADD CONSTRAINT Produto_fk0 FOREIGN KEY (produto_categoria) REFERENCES Categoria(categoria_id);

ALTER TABLE Endereco ADD CONSTRAINT Endereco_fk0 FOREIGN KEY (endereco_cliente) REFERENCES Cliente(cliente_id);

ALTER TABLE Cartao ADD CONSTRAINT Cartao_fk0 FOREIGN KEY (cartao_cliente) REFERENCES Cliente(cliente_id);

ALTER TABLE Venda ADD CONSTRAINT Venda_fk0 FOREIGN KEY (venda_cliente) REFERENCES Cliente(cliente_id);

ALTER TABLE venda_has_produto ADD CONSTRAINT venda_has_produto_fk0 FOREIGN KEY (venda_id) REFERENCES Venda(venda_id);
ALTER TABLE venda_has_produto ADD CONSTRAINT venda_has_produto_fk1 FOREIGN KEY (produto_id) REFERENCES Produto(produto_id);

ALTER TABLE Usuario ADD CONSTRAINT Usuario_fk0 FOREIGN KEY (usuario_cliente) REFERENCES Cliente(cliente_id);
