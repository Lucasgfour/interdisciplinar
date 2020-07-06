package banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class Comando {
	// Este Objeto � para tornar padr�o o sistema de relat�rios, tornando muito mais f�cil inserir relat�rios no sistema
	private String nome;
	private String descricao;
	private String comando;
	
	// Foi utilizado uma LinkedList pois � a mais vers�til e simples j� que o mesmo Objeto ser� utilizado diversa vezes e a Lista precisa ser percorrida em FOR
	private LinkedList<Parametro> parametros = new LinkedList<Parametro>(); 
	
	public Comando(String nome, String descricao, String comando) {
		this.nome = nome;
		this.descricao = descricao;
		this.comando = comando;
	}
	
	public Comando(String nome, String descricao, String comando, LinkedList<Parametro> parametros) {
		this.nome = nome;
		this.descricao = descricao;
		this.comando = comando;
		this.parametros = parametros;
	}
	
	// Chama o(s) inputDialog(s) para o usu�rio inserir os par�metros
	public void inputCall()  {
		for(Parametro par : parametros) {
			par.showInput();
		}
	}
	
	// Gerar Relat�rio e retornar resultado em LinkedList
	public LinkedList<LinkedList<String>> gerarRelatorio() {
		// Foi utilizado uma LinkedList pois trata-se de uma Lista bi-dimensional com n�mero indefinidos de dados.
		LinkedList<LinkedList<String>> resultado = new LinkedList<LinkedList<String>>();
		try {
			Conexao con = new Conexao();
			String sql = this.comando;
			PreparedStatement instrucao = con.getConexao().prepareStatement(sql);
			// Adicionar Par�metros
			if(parametros.size() > 0) {
				for(int i = 0;i < parametros.size(); i++) {
					try {
						Parametro par = parametros.get(i);
						String tipo = par.getTipo();
						if(tipo.equals("String")) { instrucao.setString((i + 1), par.getValorString());} // Inserir Par�metros String
						else if (tipo.equals("Int")) { instrucao.setInt((i + 1), par.getValorInt()); } // Inserir Par�metros Int
						else if (tipo.equals("Float")) { instrucao.setFloat((i + 1), par.getValorFloat()); } // Inserir Par�metro Float
						else if (tipo.equals("Date")) { instrucao.setDate((i + 1), java.sql.Date.valueOf(par.getValorData())); } // Inserir Par�metro Date
						else if (tipo.equals("Time")) { instrucao.setTime((i + 1), java.sql.Time.valueOf(par.getValorTime())); } // Inserir Par�metro Time
						else if (tipo.equals("Boolean")) { instrucao.setBoolean((i + 1), par.getValorBoolean()); } // Inserir Par�metro Boolean
						else if(tipo.equals("StringLike")) { instrucao.setString((i + 1), par.getValorLike());} // Inserir Par�metros String com Like
					} catch (Exception e) { e.printStackTrace(); }
				}
			}
			ResultSet res = instrucao.executeQuery();
			ResultSetMetaData rsmd = res.getMetaData();
			
			// Primeira linha � o nome das Colunas
			LinkedList<String> cols = new LinkedList<String>();
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				cols.add(rsmd.getColumnName((i + 1)));
			}
			resultado.add(cols);
			
			// Joga os Resultados na LinkedList
			while(res.next()) {
				LinkedList<String> temp = new LinkedList<String>(); 
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					temp.add(res.getString((i + 1)));
				}
				resultado.add(temp);
			}
		} catch (Exception e) { e.printStackTrace();}
		return resultado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getComando() {
		return comando;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}

	public LinkedList<Parametro> getParametros() {
		return parametros;
	}

	public void setParametros(LinkedList<Parametro> parametros) {
		this.parametros = parametros;
	}
	
	
}
