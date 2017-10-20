package br.sceweb.teste_unitario;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.sceweb.model.Empresa;
import br.sceweb.model.EmpresaDAO;
import br.sceweb.servico.ConfiguraDB;
/**
 * Este script de teste verifica o comportamento do caso de uso UC01CadastrarEmpresa
 * @author professor
 * @version 1.0
 */
public class UC01CadastrarEmpresa {
	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	static ConfiguraDB configuraDB;
	static ConfiguraDB configuraDB1;
	
	/**
	 * Metodo que adiciona valores aos atributos de empresa antes da execução dos testes
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass(){
		String url = "jdbc:mysql://localhost/sceweb";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "alunofatec";
		configuraDB = new ConfiguraDB(url, driver,usuario,senha);
		empresaDAO = new EmpresaDAO(configuraDB);
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}
	/**
	 * ID - CT01UC01FBCadastra_com_sucesso
	 * Objetivo - verificar o comportamento do sistema na inclusao de empresa com 
	 * sucesso
	 * Pré-condiçao - O cnpj 89424232000180 nao esta cadastrado.
	 */
	@Test
	public void CT01UC01FBCadastra_com_sucesso() {
		String url = "jdbc:mysql://localhost/sceweb";
		assertEquals(1,empresaDAO.adiciona(empresa));
	}
	
	/**
	 * ID - CT02UC01FBCadastra_cnpj_invalido
	 * Objetivo - verificar o comportamento do sistema na inclusao de empresa com o cnpj invalido
	 */
	@Test
	public void CT02UC01FBCadastra_cnpj_invalido() {
		assertEquals("CNPJ invalido.",empresa.setCnpj("89424"));
	}
	
	/**
	 * ID - CT03UC01FBCadastra_cnpj_ja_cadastrado
	 * Objetivo - verificar o comportamento do sistema na inclusao de empresa com 
	 * um cnpj ja cadastrado
	 * Pré-condiçao - O cnpj 89424232000180 esta cadastrado.
	 */
	@Test
	public void CT03UC01FBCadastra_cnpj_ja_cadastrado() {
		empresaDAO.adiciona(empresa);
		assertEquals(0,empresaDAO.adiciona(empresa));
	}
	
	/**
	 * ID - CT04UC01FBCadastra_db_invalido
	 * Objetivo - verificar o comportamento do sistema na inclusao de empresa em 
	 * um banco de dados invalido
	 * Pré-condiçao - a senha do banco de dados esta em branco.
	 */
	@Test
	public void CT04UC01FBCadastra_db_invalido() {
		String url = "jdbc:mysql://localhost/sceweb1";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "";
		configuraDB1 = new ConfiguraDB(url, driver,usuario,senha);
		empresaDAO = new EmpresaDAO(configuraDB);
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
		empresaDAO.adiciona(empresa);
		
	}
	
	/**
	 * ID - CT05UC01Cadastra_cnpj_branco
	 * Objetivo - verificar o comportamento do sistema na inclusao de empresa 
	 * com um cnpj em branco
	 * Pré-condiçao - o cnpj deve estar em branco.
	 */
	@Test
	public void CT05UC01Cadastra_cnpj_branco(){
		assertEquals("CNPJ invalido.", empresa.setCnpj(""));
	}
	
	/**
	 * ID - CT06UC01FBCadastra_nomeFantasia_branco
	 * Objetivo - verificar o comportamento do sistema na inclusao de empresa 
	 * com um nome fantasia em branco
	 * Pré-condiçao - o nomeFantasia deve estar em branco.
	 */
	@Test
	public void CT06UC01FBCadastra_nomeFantasia_branco(){
		assertEquals("Nome Fantasia invalido.", empresa.setNomeFantasia(""));
	}
	
	/**
	 * ID - CT07UC01FBCadastra_nomeFantasia_ja_cadastrado
	 * Objetivo - verificar o comportamento do sistema na inclusao de empresa 
	 * com um nome fantasia ja cadastrado
	 * Pré-condiçao - o nome fantasia deve estar cadastrado.
	 */
	@Test
	public void CT07UC01FBCadastra_nomeFantasia_ja_cadastrado(){
		empresaDAO.adiciona(empresa);
		assertEquals(0,empresaDAO.adiciona(empresa));
	}
	
	/**
	 * ID - CT08UC01FBCadastra_telefone_branco
	 * Objetivo - verificar o comportamento do sistema na inclusao de empresa 
	 * com um telefone em branco
	 * Pré-condiçao - o telefone deve estar em branco.
	 */
	@Test
	public void CT08UC01FBCadastra_telefone_branco(){
		assertEquals("Telefone invalido.", empresa.setTelefone(""));
	}
	
	/**
	 * Metodo que exclui a empresa do banco de dados apos a execucao dos testes
	 * @throws Exception
	 */
	@After
	public void tearDownAfterClass() {
		empresaDAO.exclui(empresa.getCnpj());
	}
}



