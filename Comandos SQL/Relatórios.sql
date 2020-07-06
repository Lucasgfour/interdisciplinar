-- Relatório 1
SELECT dataAgendamento, horario, duracao, nomePaciente, valorConsulta FROM agendamento WHERE nomeProfissional = ? ORDER BY dataAgendamento, horario DESC;

-- Relatório 2
SELECT nomeProfissional, dataAgendamento, horario, duracao, nomePaciente FROM agendamento WHERE dataAgendamento BETWEEN ? AND ? ORDER BY nomeProfissional ASC;

-- Relatório 3
SELECT nomeProfissional, dataAgendamento, horario, duracao, nomePaciente FROM agendamento WHERE tipo = ? AND dataAgendamento BETWEEN ? AND ? ORDER BY dataAgendamento, horario ASC;

-- Relatório 4
SELECT cpf, nomePaciente, telefone, dataNasc, TIMESTAMPDIFF(YEAR, dataNasc, CURRENT_DATE()) AS idade FROM agendamento WHERE MONTH(dataNasc) = ?;

-- Relatório 5
SELECT DISTINCT nomeProfissional FROM agendamento WHERE nomeProfissional LIKE ? ORDER BY nomeProfissional ASC;

-- Relatório 6
SELECT COUNT(idAgendamento) AS Quant_Consultas_com_Desconto_e_sem_Convenio FROM agendamento WHERE porcDesconto > 0 AND convenio = 0;

-- Relatório 7 
SELECT tipo, AVG(valorConsulta) AS Media_Preco, COUNT(idAgendamento) AS Quantidade_Consultas FROM agendamento GROUP BY tipo ORDER BY tipo ASC;

-- Relatório 8
SELECT nomeProfissional, SUM(valorConsulta) AS Valor_Total_Consulta FROM agendamento GROUP BY nomeProfissional ASC HAVING SUM(valorConsulta) > 500

-- Relatório 9 
SELECT MONTH(dataAgendamento) AS Mes, COUNT(idAgendamento) AS Quantidade_Consulta, SUM(valorConsulta - (valorConsulta * (porcDesconto / 100))) AS Valor_Total_Com_Desconto FROM agendamento GROUP BY MONTH(dataAgendamento);

-- Relatório 10
SELECT nomeProfissional, COUNT(idAgendamento) AS Quantidade_Consultas FROM agendamento GROUP BY nomeProfissional HAVING COUNT(idAgendamento) >= 10