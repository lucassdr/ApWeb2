package modelo.dao;

import modelo.dominio.Funcionario;

public class FuncionarioDAO extends JPADAO<Funcionario> {

	public Funcionario obterLogin(String matricula, String senha) {
		Funcionario novo = new Funcionario();
		novo.setMatricula(matricula);
		novo.setSenha(senha);
		return novo;
	}

}
