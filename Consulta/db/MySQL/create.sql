drop database if exists Consulta;

create database Consulta;

use Consulta

CREATE TABLE Usuarios (
  CPF VARCHAR(14),
  CRM VARCHAR(20),
  email VARCHAR(100) PRIMARY KEY,
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
  hora varchar(5)
);


INSERT INTO Usuarios (CPF, email, senha, nome, telefone, sexo, data_nascimento, papel)
VALUES ('12345678901', 'exemplo@email.com','paciente123' ,'João da Silva', '99999999999', 'M', '1990-01-01', 'pac');

INSERT INTO Usuarios (CRM, email, senha, nome, especialidade, papel)
VALUES ('123456789/SP','exemplo2@email.com', 'medico123', 'Fulano de Tal', 'Cardiologista', 'med');

INSERT INTO Usuarios (email, senha, nome, papel)
VALUES ('admin@email.com','admin', 'admin', 'adm');