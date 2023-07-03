drop database if exists Login;

create database Login;

use Login

CREATE TABLE Usuario (
  CPF VARCHAR(14) unique,
  CRM VARCHAR(20) unique,
  login VARCHAR(100) PRIMARY KEY,
  senha VARCHAR(100),
  nome VARCHAR(100),
  telefone VARCHAR(20),
  sexo CHAR(1),
  data_nascimento DATE,
  especialidade VARCHAR(100),
  papel VARCHAR(50)
);

CREATE TABLE Consulta (
  CPFpaciente VARCHAR(14),
  CRMmedico VARCHAR(20),
  data_consulta DATE,
  hora TIME
);


INSERT INTO Usuario (CPF, login, senha, nome, telefone, sexo, data_nascimento, papel)
VALUES ('12345678901', 'exemplo@email.com','paciente123' ,'João da Silva', '99999999999', 'M', '2002-06-06', 'pac');

INSERT INTO Usuario (CRM, login, senha, nome, especialidade, papel)
VALUES ('123456789/SP','exemplo2@email.com', 'medico123', 'Fulano de Tal', 'Cardiologista', 'med');

INSERT INTO Usuario (login, senha, nome, papel)
VALUES ('admin','admin', 'admin', 'adm');