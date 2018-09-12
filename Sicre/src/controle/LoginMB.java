package controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.dao.FuncionarioDAO;
import modelo.dominio.Funcionario;

@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB {
	/*
	 * Dados de controle da autenticação
	 */
	private Funcionario funcionario = new Funcionario();
	private boolean autenticado = false;

	/*
	 * Dados do formulário de login
	 */
	private String matricula;
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	/*
	 * Métodos
	 */
	public String exibirLogin() {
		return "login.jsf";
	}

	public String acaoAutenticar() {

		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario funcDoBanco = dao.obterLogin(this.matricula, this.senha);

		if (funcDoBanco == null) {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou Senha inválido!", null);
			FacesContext.getCurrentInstance().addMessage(null, mensagem);

			// Usuário não existe
			return "index.jsf";

		} else {
			if (funcDoBanco.isSenhaCorreta(this.senha)) {
				this.autenticado = true;
				this.funcionario = funcDoBanco;

				return "home.jsf";
			} else {
				FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou Senha inválido!",
						null);
				FacesContext.getCurrentInstance().addMessage(null, mensagem);

				return "index.jsf";
			}
		}

	}

}
