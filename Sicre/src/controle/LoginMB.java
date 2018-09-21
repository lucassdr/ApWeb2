package controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import componentes.CaminhoURL;
import modelo.dao.UsuarioDAO;
import modelo.dominio.Usuario;

@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB {

	// Dados de controle de autenticacao
	private Usuario usuario = new Usuario();
	private boolean autenticado = false;

	// Dados do formulário de login
	private String login;
	private String senha;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		return CaminhoURL.REQUEST_PATH_INDEX;
		// TODO alterar tela index.jsf por login.jsf
	}

	public String acaoAutenticar() {

		UsuarioDAO dao = new UsuarioDAO();

		// obtendo dados do usuário do banco
		Usuario usuarioBanco = dao.obter(login, senha);

		if (usuarioBanco == null) {
			// TODO alterar mensagem de erro
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuário não existe", null);
			FacesContext.getCurrentInstance().addMessage(null, mensagem);

			// usuario não existe
			return CaminhoURL.REQUEST_PATH_INDEX;
		} else {
			if (usuarioBanco.senhaCorreta(this.senha)) {
				this.autenticado = true;
				this.usuario = usuarioBanco;
				return CaminhoURL.REQUEST_PATH_HOME;
			} else {
				FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usu�rio/Senha inv�lido!", null);
				FacesContext.getCurrentInstance().addMessage(null, mensagem);

				return CaminhoURL.REQUEST_PATH_INDEX;
			}

		}

	}

}
