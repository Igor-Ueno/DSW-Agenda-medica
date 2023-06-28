DROP DATABASE IF EXISTS Consultorio;

CREATE DATABASE Consultorio;

USE Consultorio;

CREATE TABLE Medico (
  email VARCHAR(256) NOT NULL,
  senha VARCHAR(20) NOT NULL,
  CRM VARCHAR(13) NOT NULL,
  nome VARCHAR(50) NOT NULL,
  especialidade VARCHAR(50) NOT NULL,
  papel varchar(3) NOT NULL ,
  sexo VARCHAR(1),
  PRIMARY KEY (CRM)
);

CREATE TABLE Paciente (
  email VARCHAR(256) NOT NULL,
  senha VARCHAR(20) NOT NULL,
  CPF VARCHAR(11) NOT NULL,
  nome VARCHAR(50) NOT NULL,
  telefone VARCHAR(11) NOT NULL,
  sexo VARCHAR(1) NOT NULL,
  data_nascimento DATE NOT NULL,
  papel varchar(3) NOT NULL ,
  PRIMARY KEY (CPF)
);

CREATE TABLE Consulta (
  ID integer NOT NULL ,
  CPF VARCHAR(20) NOT NULL,
  CRM VARCHAR(20) NOT NULL,
  data_hora TIMESTAMP NOT NULL,
  papel varchar(3) NOT NULL ,
  FOREIGN KEY (CPF) REFERENCES Paciente(CPF),
  FOREIGN KEY (CRM) REFERENCES Medico(CRM),
  PRIMARY KEY(ID)
);

-- Inserindo dados na tabela Medico
INSERT INTO Medico (email, senha, CRM, nome, especialidade, sexo)
VALUES ('medico1@example.com', 'senha123', 'CRM123456789', 'Dr. João', 'Cardiologia', 'M');

INSERT INTO Medico (email, senha, CRM, nome, especialidade, sexo)
VALUES ('medico2@example.com', 'senha456', 'CRM987654321', 'Dra. Maria', 'Dermatologia', 'F');


-- Inserindo dados na tabela Paciente
INSERT INTO Paciente (email, senha, CPF, nome, telefone, sexo, data_nascimento)
VALUES ('paciente1@example.com', 'senha789', 'CPF123456789', 'José Silva', '999999999', 'M', '1980-01-01');

INSERT INTO Paciente (email, senha, CPF, nome, telefone, sexo, data_nascimento)
VALUES ('paciente2@example.com', 'senha987', 'CPF987654321', 'Ana Souza', '888888888', 'F', '1990-02-02');


-- Inserindo dados na tabela Consulta
INSERT INTO Consulta (CPF, CRM, data_hora)
VALUES ('CPF123456789', 'CRM123456789', '2023-06-19 09:00:00');

INSERT INTO Consulta (CPF, CRM, data_hora)
VALUES ('CPF987654321', 'CRM987654321', '2023-06-20 10:30:00');