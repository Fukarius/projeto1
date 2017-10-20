package br.sceweb.servico;

/**
 * Classe que configura as informações referentes ao banco de dados
 * @author Lab103
 * @version 1.0
 */
public class ConfiguraDB {
	String url = "";
	String driver = "";
	String usuario = "";
	String senha = "";
	
	/**
	 * Metodo construtor de ConfiguraDB
	 * @param url
	 * @param driver
	 * @param usuario
	 * @param senha
	 */
	public ConfiguraDB(String url, String driver, String usuario, String senha) {
		this.url = url;
		this.driver = driver;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	/**
	 * Propriedade GET de url
	 * @return url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Propriedade GET de driver
	 * @return driver
	 */
	public String getDriver() {
		return driver;
	}
	
	/**
	 * Propriedade GET de usuario
	 * @return usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	
	/**
	 * Propriedade GET de senha
	 * @return senha
	 */
	public String getSenha() {
		return senha;
	}
	
	
}