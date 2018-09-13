package modelo.dao;

import modelo.dominio.Usuario;

public class UsuarioDAO {
	
	public Usuario obter(String login, String senha) {
		Usuario novo = new Usuario();
		novo.setLogin(login);
		novo.setSenha(senha);
		
		return novo;
		
	}

}
