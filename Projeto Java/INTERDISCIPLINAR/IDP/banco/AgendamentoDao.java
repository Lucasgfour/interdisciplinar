package banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import classes.Agendamento;

public class AgendamentoDao {

	// Retorna uma List com todos os registros do Banco de dados
	public List<Agendamento> listar() {
		List<Agendamento> tempList = new LinkedList<Agendamento>(); 
		try {
			Conexao con = new Conexao();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
			Statement instrucao = con.getConexao().createStatement();
			String sql = "SELECT * FROM agendamento ORDER BY dataAgendamento, horario";
			ResultSet res = instrucao.executeQuery(sql);
			while (res.next()) {
				Agendamento tempAgenda = new Agendamento();
				tempAgenda.setId(res.getInt("idAgendamento"));
				tempAgenda.setData(LocalDate.parse(res.getString("dataAgendamento"), formatter));
				tempAgenda.setHorario(LocalTime.parse(res.getString("horario"), formatterHora));
				tempAgenda.setDuracao(res.getFloat("duracao"));
				tempAgenda.setCpf(res.getString("cpf"));
				tempAgenda.setNomePaciente(res.getString("nomePaciente"));
				tempAgenda.setTelefone(res.getString("telefone"));
				tempAgenda.setDataNascimento(LocalDate.parse(res.getString("dataNasc"), formatter));
				tempAgenda.setNomeProfissional(res.getString("nomeProfissional"));
				tempAgenda.setTipo(res.getString("tipo"));
				tempAgenda.setValorConsulta(res.getFloat("valorConsulta"));
				tempAgenda.setPorcDesconto(res.getInt("porcDesconto"));
				tempAgenda.setConvenio(res.getInt("convenio"));
				tempList.add(tempAgenda);
			}
			con.getConexao().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempList;
	}
	
	// Retorna uma List com os profissionais localizados no banco
	public List<String> listarProfissionais() {
		List<String> tempList = new LinkedList<String>(); 
		try {
			Conexao con = new Conexao();
			Statement instrucao = con.getConexao().createStatement();
			String sql = "SELECT nomeProfissional FROM agendamento GROUP BY nomeProfissional";
			ResultSet res = instrucao.executeQuery(sql);
			while (res.next()) {
				tempList.add(res.getString("nomeProfissional"));
			}
			con.getConexao().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempList;
	}
	
	// Novo registro
	public void inserir(Agendamento a) {
		try {
			Conexao con = new Conexao();
			String SQL = "INSERT INTO agendamento (dataAgendamento, horario, duracao, cpf, nomePaciente, telefone, dataNasc, nomeProfissional, tipo, valorConsulta, porcDesconto, convenio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement prep = con.getConexao().prepareStatement(SQL);
			prep.setDate(1, java.sql.Date.valueOf(a.getData())); // dataAgendamento
			prep.setTime(2, java.sql.Time.valueOf(a.getHorario())); // Horario
			prep.setFloat(3, a.getDuracao()); // Duracao
			prep.setString(4, a.getCpf()); // CPF
			prep.setString(5, a.getNomePaciente()); // nomePaciente
			prep.setString(6, a.getTelefone()); // telefone
			prep.setDate(7, java.sql.Date.valueOf(a.getDataNascimento())); // dataNascimento
			prep.setString(8, a.getNomeProfissional()); // nomeProfissional
			prep.setString(9, a.getTipo()); // Tipo
			prep.setFloat(10, a.getValorConsulta()); // ValorConsulta
			prep.setInt(11, a.getPorcDesconto()); // PorcDesconto
			prep.setInt(12, a.getConvenio()); // Convenio
			prep.execute();
			con.getConexao().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Alterar Agendamento
	public void alterar(Agendamento a) {
		try {
			Conexao con = new Conexao();
			String SQL = "UPDATE agendamento SET dataAgendamento = ?, horario = ?, duracao = ?, cpf = ?, nomePaciente = ?, telefone = ?, dataNasc = ?, nomeProfissional = ?, tipo = ?, valorConsulta = ?, porcDesconto = ?, convenio = ? WHERE idAgendamento = ?";
			PreparedStatement prep = con.getConexao().prepareStatement(SQL);
			prep.setDate(1, java.sql.Date.valueOf(a.getData())); // dataAgendamento
			prep.setTime(2, java.sql.Time.valueOf(a.getHorario())); // Horario
			prep.setFloat(3, a.getDuracao()); // Duracao
			prep.setString(4, a.getCpf()); // CPF
			prep.setString(5, a.getNomePaciente()); // nomePaciente
			prep.setString(6, a.getTelefone()); // telefone
			prep.setDate(7, java.sql.Date.valueOf(a.getDataNascimento())); // dataNascimento
			prep.setString(8, a.getNomeProfissional()); // nomeProfissional
			prep.setString(9, a.getTipo()); // Tipo
			prep.setFloat(10, a.getValorConsulta()); // ValorConsulta
			prep.setInt(11, a.getPorcDesconto()); // PorcDesconto
			prep.setInt(12, a.getConvenio()); // Convenio
			prep.setInt(13, a.getId()); // Id Agendamento
			prep.execute();
			con.getConexao().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Deletar Agendamento
	public void deletar(Agendamento a) {
		try {
			Conexao con = new Conexao();
			String SQL = "DELETE FROM agendamento WHERE idAgendamento = ?";
			PreparedStatement prep = con.getConexao().prepareStatement(SQL);
			prep.setInt(1, a.getId()); // Id Agendamento
			prep.execute();
			con.getConexao().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
