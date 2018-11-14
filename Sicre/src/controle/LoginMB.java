package controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.swing.plaf.synth.SynthSeparatorUI;

import componentes.CaminhoURL;
import modelo.dao.FuncionarioDAO;
import modelo.dominio.Funcionario;

@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB {

	// Dados de controle de autenticacao

	private Funcionario funcionario = new Funcionario();
	private boolean autenticado = false;
	
	FuncionarioDAO dao = new FuncionarioDAO();
	
	List<Funcionario> funcion = dao.lerTodos();

	// Dados do formulário de login
	private String login;
	private String senha;

	private String nome;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public boolean isAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// Métodos
	public String exibirLogin() {
		return CaminhoURL.REQUEST_PATH_LOGIN;
	}

	public String acaoAutenticar() {

		boolean seguir = false;
		
		String loginDefault = "000.000.000-00";
	
		
		for (Funcionario funcionario : funcion) {
			if((funcionario.getCpf().equals(login) && funcionario.getSenha().equals(senha)) 
					|| (login.equals(loginDefault)) && (senha.equals("admin"))) {
				seguir = true;
			}
		}
		
		
		/*if ((login.equals(loginDefault)) && (senha.equals("admin"))) {
			seguir = true;
			System.out.println("Caiu aqui 1");
		}else if ((login.equals( funcionario.getCpf())  ) && (  senha.equals(funcionario.getSenha())  )){
			seguir = true;
			System.out.println("Caiu aqui 2");
		}else {
			seguir = false;
			System.out.println("Caiu aqui 3");
		}*/

		if (seguir) {
			this.autenticado = true;
			// this.funcionario = funcBanco;

			return CaminhoURL.REQUEST_PATH_HOME + CaminhoURL.FACES_REDIRECT;
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário/Senha inválido!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);

			return CaminhoURL.REQUEST_PATH_LOGIN;
		}

	}

	public String acaoSair() {
		return CaminhoURL.REQUEST_PATH_LOGIN + CaminhoURL.FACES_REDIRECT;
	}

}
