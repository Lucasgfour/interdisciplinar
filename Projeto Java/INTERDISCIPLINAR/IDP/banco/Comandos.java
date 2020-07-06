package banco;

import java.util.LinkedList;

public class Comandos {
	// Aqui s�o armazenados todos os relat�rios solicitados pela disciplina de Banco de Dados e distribuido para a tela relatorios.
	
	// LinkedList pois torna-se mais f�cil de setar os dados no formul�rio
	private LinkedList<Comando> comandos = new LinkedList<Comando>();
	
	public Comandos() {
		
		// Relat�rio 1 : Selecione a data, o hor�rio, a dura��o, o nome do paciente e o valor da consulta de um determinado profissional (Ex.:�Jos� da Silva�), exibindo primeiro os agendamentos mais recentes.
		Comando R1 = new Comando("01 - Consulta por Profissional", "Selecione a data, o hor�rio, a dura��o, o nome do paciente e o valor da consulta de um determinado profissional (Ex.:�Jos� da Silva�), exibindo primeiro os agendamentos mais recentes", "SELECT dataAgendamento AS data, horario, duracao, nomePaciente AS paciente, valorConsulta AS valor FROM agendamento WHERE nomeProfissional = ? ORDER BY dataAgendamento, horario DESC");
		R1.getParametros().add(new Parametro("Nome Profissional", "String"));
		comandos.add(R1);
		
		// Relat�rio 2 : Selecione o nome do profissional, a data, o hor�rio, a dura��o e o nome do paciente entre um determinado per�odo (data inicial e data final), ordenando pelo nome do profissional.
		Comando R2 = new Comando("02 - Consultas por Data de Agendamento", "Selecione o nome do profissional, a data, o hor�rio, a dura��o e o nome do paciente entre um determinado per�odo (data inicial e data final), ordenando pelo nome do profissional.", "SELECT nomeProfissional, dataAgendamento, horario, duracao, nomePaciente FROM agendamento WHERE dataAgendamento BETWEEN ? AND ? ORDER BY nomeProfissional ASC");
		R2.getParametros().add(new Parametro("Data inicial (dd/MM/yyyy)", "Date"));
		R2.getParametros().add(new Parametro("Data Final (dd/MM/yyyy)", "Date"));
		comandos.add(R2);
		
		// Relat�rio 3 : Selecione o nome do profissional, a data, o hor�rio, a dura��o e o nome do paciente dos agendamentos de uma consulta de um determinado tipo e entre um determinado per�odo (data inicial e data final), ordenando pela data, hor�rio (agendamento mais antigo devem ser exibidos primeiro).
		Comando R3 = new Comando("03 - Consultas por Data de Agendamento e Tipo", "Selecione o nome do profissional, a data, o hor�rio, a dura��o e o nome do paciente dos agendamentos de uma consulta de um determinado tipo e entre um determinado per�odo (data inicial e data final), ordenando pela data, hor�rio (agendamento mais antigo devem ser exibidos primeiro).", "SELECT nomeProfissional, dataAgendamento, horario, duracao, nomePaciente FROM agendamento WHERE tipo = ? AND dataAgendamento BETWEEN ? AND ? ORDER BY dataAgendamento, horario ASC");
		R3.getParametros().add(new Parametro("Tipo de Consulta [ Cl�nico Geral, Dentista, Fisioterapeuta, Cardiologista, Dermatologista ]", "String"));
		R3.getParametros().add(new Parametro("Data inicial (dd/MM/yyyy)", "Date"));
		R3.getParametros().add(new Parametro("Data Final (dd/MM/yyyy)", "Date"));
		comandos.add(R3);
		
		// Relat�rio 4 : Selecione o CPF, o nome do paciente, telefone, data de nascimento e a idade dos pacientes que nasceram em um determinado m�s
		Comando R4 = new Comando("04 - Busca de clientes por m�s de nascimento", "Selecione o CPF, o nome do paciente, telefone, data de nascimento e a idade dos pacientes que nasceram em um determinado m�s", "SELECT cpf, nomePaciente, telefone, dataNasc, TIMESTAMPDIFF(YEAR, dataNasc, CURRENT_DATE()) AS idade FROM agendamento WHERE MONTH(dataNasc) = ?");
		R4.getParametros().add(new Parametro("M�s nascimento (1 a 12)", "Int"));
		comandos.add(R4);
		
		// Relat�rio 5 : Selecione todos os profissionais que tem o nome t�m em seu nome parte do nome digitada pelo usu�rio, ordenando pelo nome em ordem crescente
		Comando R5 = new Comando("05 - Busca de profissionais por nome", "Selecione todos os profissionais que tem o nome t�m em seu nome parte do nome digitada pelo usu�rio, ordenando pelo nome em ordem crescente", "SELECT DISTINCT nomeProfissional FROM agendamento WHERE nomeProfissional LIKE ? ORDER BY nomeProfissional ASC");
		R5.getParametros().add(new Parametro("Nome (Contem)", "StringLike"));
		comandos.add(R5);
		
		// Relat�rio 6 : Exiba a quantidade total de agendamentos que tiveram de desconto e que n�o s�o de conv�nio.
		Comando R6 = new Comando("06 - Quantidade de consultas com desconto sem conv�nio", "Exiba a quantidade total de agendamentos que tiveram de desconto e que n�o s�o de conv�nio.", "SELECT COUNT(idAgendamento) AS Quant_Consultas_com_Desconto_e_sem_Convenio FROM agendamento WHERE porcDesconto > 0 AND convenio = 0");
		comandos.add(R6);
		
		// Relat�rio 7 : Exiba a m�dia de pre�os e a quantidade de consultas agendadas por cada tipo de profissional, agrupando por tipo e ordenando em ordem alfab�tica
		Comando R7 = new Comando("07 - M�dia de pre�os e quantidade de consultas por Tipo", "Exiba a m�dia de pre�os e a quantidade de consultas agendadas por cada tipo de profissional, agrupando por tipo e ordenando em ordem alfab�tica", "SELECT tipo, AVG(valorConsulta) AS Media_Preco, COUNT(idAgendamento) AS Quantidade_Consultas FROM agendamento GROUP BY tipo ORDER BY tipo ASC;");
		comandos.add(R7);
		
		// Relat�rio 8 : Mostre o valor total de consultas agendadas por profissional, agrupando por profissional, caso o valor total de consultas agendadas seja maior do que R$ 500,00, ordenando pelo nome do profissional
		Comando R8 = new Comando("08 - Valor total maior de R$ 500 de consultas por profissional", "Mostre o valor total de consultas agendadas por profissional, agrupando por profissional, caso o valor total de consultas agendadas seja maior do que R$ 500,00, ordenando pelo nome do profissional", "SELECT nomeProfissional, SUM(valorConsulta) AS Valor_Total_Consulta FROM agendamento GROUP BY nomeProfissional ASC HAVING SUM(valorConsulta) > 500");
		comandos.add(R8);
		
		// Relat�rio 9 : Exiba a quantidade e o valor total das consultas agendadas em um determinado m�s. Considere o porcentagem de desconto para obter o pre�o final da consulta.
		Comando R9 = new Comando("09 - Valor total e quantidade por m�s", "Exiba a quantidade e o valor total das consultas agendadas em um determinado m�s. Considere o porcentagem de desconto para obter o pre�o final da consulta.", "SELECT MONTH(dataAgendamento) AS Mes, COUNT(idAgendamento) AS Quantidade_Consulta, SUM(valorConsulta - (valorConsulta * (porcDesconto / 100))) AS Valor_Total_Com_Desconto FROM agendamento GROUP BY MONTH(dataAgendamento);");
		comandos.add(R9);
		
		// Relat�rio 10 : Selecione o nome do profissional e a quantidade de consultas agendadas, caso tiver no m�nimo 10 consultas agendadas em um determinado m�s, ordenando pelo maior n�mero de agendamentos.
		Comando R10 = new Comando("10 - Quantidade de consultas por profissional(Com no m�nimo de 10)", "Selecione o nome do profissional e a quantidade de consultas agendadas, caso tiver no m�nimo 10 consultas agendadas em um determinado m�s, ordenando pelo maior n�mero de agendamentos.", "SELECT nomeProfissional, COUNT(idAgendamento) AS Quantidade_Consultas FROM agendamento GROUP BY nomeProfissional HAVING COUNT(idAgendamento) >= 10");
		comandos.add(R10);
	}
	
	public LinkedList<Comando> getComands() {
		return comandos;
	}
}
