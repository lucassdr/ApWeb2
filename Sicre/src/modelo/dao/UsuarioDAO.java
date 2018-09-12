package modelo.dao;

import modelo.dominio.Funcionario;

public class UsuarioDAO {
	
	public Funcionario obter(String matricula) {
		Funcionario novo = new Funcionario();
		novo.setMatricula(matricula);
		novo.setSenha("123");
		return novo;
	}
}
