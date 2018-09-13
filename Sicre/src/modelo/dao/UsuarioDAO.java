package modelo.dao;

import modelo.dominio.Usuario;

public class UsuarioDAO {
	
	public Usuario obter(String matricula) {
		Usuario novo = new Usuario();
		novo.setMatricula(matricula);
		novo.setSenha("123");
		return novo;
	}
}
