package controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import componentes.CaminhoURL;
import modelo.dao.FuncionarioDAO;
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

	// Métodos
	public String exibirLogin() {
		return CaminhoURL.REQUEST_PATH_LOGIN;
	}

	public String acaoAutenticar() {

		FuncionarioDAO dao = new FuncionarioDAO();

		// obtendo dados do usuário do banco
		List<Funcionario> funcionarios = dao.lerTodos();

		boolean seguir = false;

		for (Funcionario func : funcionarios) {
			if (func.getCpf().equals(login)) {
				// password = DigestUtils.sha256Hex(password);
				if (func.getSenha().equals(senha)) {
					seguir = true;
				}
			}
		}

		if (!seguir) {

			// TODO alterar mensagem de erro
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuário não existe", null);
			FacesContext.getCurrentInstance().addMessage(null, mensagem);

			// usuario não existe
			return CaminhoURL.REQUEST_PATH_LOGIN + CaminhoURL.FACES_REDIRECT;
		} else {
			if (seguir) {
				this.autenticado = true;
				// this.funcionario = funcBanco;

				return CaminhoURL.REQUEST_PATH_HOME + CaminhoURL.FACES_REDIRECT;
			} else {
				FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário/Senha inválido!", null);
				FacesContext.getCurrentInstance().addMessage(null, mensagem);

				return CaminhoURL.REQUEST_PATH_LOGIN;
			}

		}

	}

}
