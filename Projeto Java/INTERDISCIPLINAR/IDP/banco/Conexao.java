package banco;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private Connection conexao;

	// Obter Conexão
	public Connection getConexao() {
		return conexao;
	}

	// Definir Conexão
	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	// Construtor para definir conexão
	@SuppressWarnings("deprecation")
	public Conexao() {
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			String url = "jdbc:mariadb://127.0.0.1/interdisciplinar";
			conexao = DriverManager.getConnection(url, "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
