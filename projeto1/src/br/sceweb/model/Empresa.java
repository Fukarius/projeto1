package br.sceweb.model;

import java.util.InputMismatchException;
/**
 * Esta classe registra as informações das empresas que estao autorizadas
 * a oferecer estagio para alunos
 * @author professor
 * @version 1.0
 *
 */
public class Empresa {

	String cnpj;
	String nomeDaEmpresa;
	String nomeFantasia;
	String endereco;
	String telefone;

	/**
	 * Propriedade GET do CNPJ
	 * @return cnpj cnpj da empresa
	 */
	public String getCnpj() {
		return cnpj;
	}
	
	/**
	 * Propriedade SET do CNPJ que verifica se ele e valido
	 * @param cnpj cnpj da empresa
	 * @return CNPJ ou uma mensagem de erro caso ele seja invalido
	 */
	public String setCnpj(String cnpj) {
		String msg="";
		if(isValido(cnpj)){
			this.cnpj = cnpj;
		}else{
			msg = "CNPJ invalido.";
		}
		if(isBranco(cnpj)){
			msg = "CNPJ invalido.";
		}else{
			this.cnpj = cnpj;
		}
		return msg;
	}

	/**
	 * Propriedade GET do nome da empresa
	 * @return nomeDaEmpresa nome da empresa
	 */
	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}

	/**
	 * Propriedade SET do nome da empresa
	 * @param nomeDaEmpresa nome da empresa
	 */
	public void setNomeDaEmpresa(String nomeDaEmpresa) {
		this.nomeDaEmpresa = nomeDaEmpresa;
	}

	/**
	 * Propriedade get do nome fantasia
	 * @return nomeFantasia nome fantasia da empresa
	 */
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	/**
	 * Propriedade set do nome fantasia que verifica se ele e valido
	 * @param nomeFantasia nome fantasia da empresa
	 * @return nomeFantasia nome fantasia da empresa ou mensagem de erro caso invalido
	 */
	public String setNomeFantasia(String nomeFantasia) {
		String msg="";
		if(isBranco(nomeFantasia)){
			msg = "Nome Fantasia invalido.";
		}
		else{
			this.nomeFantasia = nomeFantasia;
		}
		return msg;
	}

	/**
	 * Propriedade get do endereco
	 * @return endereco endereco da empresa
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Propriedade set do endereco
	 * @param endereco endereco da empresa
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * Propriedade get do telefone
	 * @return telefone telefone da empresa
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Propriedade SET do telefone que verifica se ele e valido
	 * @param telefone telefone da empresa
	 * @return  telefone da empresa ou mensagem de erro caso invalido
	 */
	public String setTelefone(String telefone) {
		String msg="";
		if(isBranco(telefone)){
			msg = "Telefone invalido.";	
		}
		else{
			this.telefone = telefone;
		}
		return msg;
	}
	/**
	 * Metodo que valida o cnpj
	 * @param cnpj cnpj da empresa
	 * @return true se for valido ou false se for invalido
	 */
	public boolean isValido(String cnpj) {
		char dig13, dig14; 
		int sm, i, r, num, peso;
		if (cnpj.equals("00000000000000") || 
				cnpj.equals("11111111111111") || 
				cnpj.equals("22222222222222") || 
				cnpj.equals("33333333333333") || 
				cnpj.equals("44444444444444") || 
				cnpj.equals("55555555555555") ||
				cnpj.equals("66666666666666") || 
				cnpj.equals("77777777777777") || 
				cnpj.equals("88888888888888") || 
				cnpj.equals("99999999999999") || 
				(cnpj.length() != 14)) {
			return(false); 
		}
		// "try" - protege o código para eventuais erros de conversao de tipo (int) 
		try { // Calculo do 1o. Digito Verificador 
			sm = 0; 
			peso = 2; 
			for (i=11; i>=0; i--) { 
				// converte o i-ésimo caractere do CNPJ em um número: 
				// por exemplo, transforma o caractere '0' no inteiro 0 
				// (48 eh a posição de '0' na tabela ASCII) 
				num = (int)(cnpj.charAt(i) - 48); 
				sm = sm + (num * peso); 
				peso = peso + 1; if (peso == 10) 
					peso = 2; 
			} 
			r = sm % 11; 
			if ((r == 0) || (r == 1)) 
				dig13 = '0'; 
			else 
				dig13 = (char)((11-r) + 48);
		
		// Calculo do 2o. Digito Verificador 
		sm = 0; peso = 2; 
		for (i=12; i>=0; i--) { 
			num = (int)(cnpj.charAt(i)- 48); 
			sm = sm + (num * peso); peso = peso + 1; 
			if (peso == 10) peso = 2; 
			} 
		r = sm % 11; 
		if ((r == 0) || (r == 1)) dig14 = '0';
		else dig14 = (char)((11-r) + 48); 
		// Verifica se os dígitos calculados conferem com os dígitos informados. 
		if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13))) 
			return(true); else return(false);
		}
		
		catch (InputMismatchException erro) {
			erro.printStackTrace();
	        return(false);
	    }
	}
	
	/**
	 * Metodo que verifica se uma String esta em branco
	 * @param txt String a ser verificada
	 * @return true
	 */
	public boolean isBranco(String txt){
		if(txt.equals("")){
			return true;
		}
		else{
			return false;
		}
	}

}
