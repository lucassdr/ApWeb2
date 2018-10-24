package controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import componentes.CaminhoURL;
import modelo.dominio.Funcionario;

@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB {

	// Dados de controle de autenticacao

	private Funcionario funcionario = new Funcionario();
	private boolean autenticado = false;

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

		if ((login.equals(login)) && (senha.equals(senha))) {
			seguir = true;
		}

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
