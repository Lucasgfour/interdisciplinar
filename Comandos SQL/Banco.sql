CREATE DATABASE interdisciplinar; -- Criar Banco de Dados
USE interdisciplinar; -- Selecionar Banco de Dados

-- Criação da Tabela Agendamentos
CREATE TABLE agendamento (
	idAgendamento INT NOT NULL AUTO_INCREMENT,
	dataAgendamento DATE NOT NULL,
    horario TIME NOT NULL,
    duracao FLOAT DEFAULT 1,
    cpf VARCHAR(11) NOT NULL,
    nomePaciente VARCHAR(50) NOT NULL,
    telefone VARCHAR(20),
    dataNasc VARCHAR(10),
    nomeProfissional VARCHAR(50) NOT NULL,
    tipo VARCHAR(30) NOT NULL,
    valorConsulta FLOAT DEFAULT 200.00,
    porcDesconto INTEGER,
    convenio SMALLINT,
    PRIMARY KEY (idAgendamento)
);

INSERT INTO agendamento (dataAgendamento, horario, duracao, cpf, nomePaciente, telefone, dataNasc, nomeProfissional, tipo, valorConsulta, porcDesconto, convenio) VALUES('2020-07-15', '11:30:00', 1.5, '11122233344', 'Joaquim José da Silva', '35 9 9988 7750', '1986-03-25', 'Dr. Raul', 'Cardiologista', 596.5, 5, 0);
INSERT INTO agendamento (dataAgendamento, horario, duracao, cpf, nomePaciente, telefone, dataNasc, nomeProfissional, tipo, valorConsulta, porcDesconto, convenio) VALUES('2020-07-17', '09:00:00', 4, '22233344455', 'James Bond', '35 3221 3000', '1990-02-10', 'Dr. Raul', 'Clínico Geral', 236.5, 10, 1);
INSERT INTO agendamento (dataAgendamento, horario, duracao, cpf, nomePaciente, telefone, dataNasc, nomeProfissional, tipo, valorConsulta, porcDesconto, convenio) VALUES('2020-07-17', '13:00:00', 2.5, '88877799910', 'Lara Croft', '35 9 9977 4452', '1994-05-14', 'Dr. Raul', 'Fisioterapeuta', 437.9, 0, 0);
INSERT INTO agendamento (dataAgendamento, horario, duracao, cpf, nomePaciente, telefone, dataNasc, nomeProfissional, tipo, valorConsulta, porcDesconto, convenio) VALUES('2020-07-20', '07:00:00', 3, '47854314572', 'Jailton Ferreira da Silva', '35 9 9942 5435', '1986-08-22', 'Dra. Marcela', 'Dentista', 652.56, 10, 0);
INSERT INTO agendamento (dataAgendamento, horario, duracao, cpf, nomePaciente, telefone, dataNasc, nomeProfissional, tipo, valorConsulta, porcDesconto, convenio) VALUES('2020-07-20', '11:00:00', 2, '45644578912', 'Lucas Matheus Amaral Silva', '35 9876 1243', '2000-01-20', 'Dra. Marcela', 'Dentista', 163.5, 5, 1);
INSERT INTO agendamento (dataAgendamento, horario, duracao, cpf, nomePaciente, telefone, dataNasc, nomeProfissional, tipo, valorConsulta, porcDesconto, convenio) VALUES('2020-08-01', '10:00:00', 7.5, '65478534547', 'Hélio Alves de Figuereido', 'Não Informado', '1952-05-01', 'Dr. Raul', 'Cardiologista', 1532.5, 10, 1);
INSERT INTO agendamento (dataAgendamento, horario, duracao, cpf, nomePaciente, telefone, dataNasc, nomeProfissional, tipo, valorConsulta, porcDesconto, convenio) VALUES('2020-07-10', '12:00:00', 1.5, '78942165421', 'José Leonardo', '35 3874 4561', '1974-03-01', 'Dra. Jaqueline', 'Fisioterapeuta', 245.63, 0, 1);
INSERT INTO agendamento (dataAgendamento, horario, duracao, cpf, nomePaciente, telefone, dataNasc, nomeProfissional, tipo, valorConsulta, porcDesconto, convenio) VALUES('2020-07-11', '12:00:00', 2.5, '45678965432', 'Guilherme Ribeiro Borges', '35 9785 2143', '2001-05-01', 'Dra. Jaqueline', 'Fisioterapeuta', 345.28, 10, 0);
INSERT INTO agendamento (dataAgendamento, horario, duracao, cpf, nomePaciente, telefone, dataNasc, nomeProfissional, tipo, valorConsulta, porcDesconto, convenio) VALUES('2020-07-25', '10:30:00', 1.5, '54678924756', 'Maria José Barros', '35 3539 1800', '1970-05-26', 'Dr. Raul', 'Clínico Geral', 250.52, 0, 1);
INSERT INTO agendamento (dataAgendamento, horario, duracao, cpf, nomePaciente, telefone, dataNasc, nomeProfissional, tipo, valorConsulta, porcDesconto, convenio) VALUES('2020-07-19', '14:00:00', 2.5, '15843578932', 'Beatriz Silva', '35 87465 1213', '2003-03-12', 'Dra. Marcela', 'Dentista', 145.98, 10, 0);
