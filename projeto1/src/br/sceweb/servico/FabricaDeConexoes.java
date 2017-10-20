package br.sceweb.servico;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;


/**
 * Classe que gerencia as conexões com o banco de dados
 * @author Lab103
 * @version 1.0
 */
public class FabricaDeConexoes {

	String url = "jdbc:mysql://localhost/sceweb";
	String driver = "com.mysql.jdbc.Driver";
	String usuario = "root";
	String senha = "alunofatec";

	/**
	 * Metodo construtor da FabricaDeConexoes que configura a conexao ao banco de dados
	 * @param configura
	 */
	public FabricaDeConexoes(ConfiguraDB configura) {
		this.url = configura.getUrl();
		this.driver = configura.getDriver();
		this.usuario = configura.getUsuario();
		this.senha = configura.getSenha();
	}

	/**
	 * Metodo construtor vazio da FabricaDeConexoes
	 */
	public FabricaDeConexoes() {

	}

	/**
	 * Metodo que adquire a conexao com o banco de dados
	 * @return Connection
	 */
	public Connection getConnection() {
		try {
			Class.forName(driver);
			return (Connection) DriverManager.getConnection(url, usuario, senha);
		} catch (CommunicationsException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
			
		}
	}
}
