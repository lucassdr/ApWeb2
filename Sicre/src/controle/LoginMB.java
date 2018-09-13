package controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import componentes.ConstrutorURL;
import componentes.MensagensAlertas;
import modelo.dao.UsuarioDAO;
import modelo.dominio.Usuario;

@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB {
	/*
	 * Dados de controle da autenticação
	 */
	private Usuario usuario = new Usuario();
	private boolean autenticado = false;

	/*
	 * Dados do formulário de login
	 */
	private String matricula;
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
		return ConstrutorURL.REQUEST_PATH_LOGIN;
	}

	public String acaoAutenticar() {

		UsuarioDAO dao = new UsuarioDAO();

		Usuario usuarioDoBanco = dao.obter(matricula);

		if (usuarioDoBanco == null) {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, MensagensAlertas.NOT_AUTHORIZED, null);
			FacesContext.getCurrentInstance().addMessage(null, mensagem);

			// Usuário não existe
			return ConstrutorURL.REQUEST_PATH_INDEX;

		} else {
			if (usuarioDoBanco.isSenhaCorreta(this.senha)) {
				this.autenticado = true;
				this.usuario = usuarioDoBanco;

				return ConstrutorURL.REQUEST_PATH_HOME;
			} else {
				FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, MensagensAlertas.USER_NOT_FOUND,
						null);
				FacesContext.getCurrentInstance().addMessage(null, mensagem);

				return ConstrutorURL.REQUEST_PATH_INDEX;
			}
		}

	}

}
