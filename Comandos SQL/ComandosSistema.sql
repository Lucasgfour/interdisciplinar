-- Funcao listar() - AgendamentoDao
SELECT * FROM agendamento ORDER BY dataAgendamento, horario;

-- Funcao listarProfissionais() - AgendamentoDao
SELECT nomeProfissional FROM agendamento GROUP BY nomeProfissional;

-- Funcao inserir() - AgendamentoDao
INSERT INTO agendamento (dataAgendamento, horario, duracao, cpf, nomePaciente, telefone, dataNasc, nomeProfissional, tipo, valorConsulta, porcDesconto, convenio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

-- Funcao alterar() - AgendamentoDao
UPDATE agendamento SET dataAgendamento = ?, horario = ?, duracao = ?, cpf = ?, nomePaciente = ?, telefone = ?, dataNasc = ?, nomeProfissional = ?, tipo = ?, valorConsulta = ?, porcDesconto = ?, convenio = ? WHERE idAgendamento = ?

-- Funcao deletar() - AgendamentoDao
DELETE FROM agendamento WHERE idAgendamento = ?