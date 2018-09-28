package controle;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

		FuncionarioDAO dao = new FuncionarioDAO();

		// obtendo dados do usuário do banco
		List<Funcionario> funcionarios = dao.lerTodos();

		boolean seguir = false;

		for (Funcionario func : funcionarios) {
			if (func.getCpf().equals(login)) {
				nome = (func.getNome());
				senha = convertStringToMD5(senha);
				if (func.getSenha().equals(senha)) {
					seguir = true;
				}
			}
		}

		if (!seguir) {

			// TODO alterar mensagem de erro
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuário não existe", null);
			FacesContext.getCurrentInstance().addMessage(null, message);

			// usuario não existe
			return CaminhoURL.REQUEST_PATH_LOGIN + CaminhoURL.FACES_REDIRECT;
		} else {
			if (seguir) {
				this.autenticado = true;
				// this.funcionario = funcBanco;

				funcionario.setNome(nome);
				return CaminhoURL.REQUEST_PATH_HOME + CaminhoURL.FACES_REDIRECT;
			} else {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário/Senha inválido!", null);
				FacesContext.getCurrentInstance().addMessage(null, message);

				return CaminhoURL.REQUEST_PATH_LOGIN;
			}

		}

	}

	private String convertStringToMD5(String valor) {
		MessageDigest messageDisgest;
		try {
			messageDisgest = MessageDigest.getInstance("MD5");
			byte[] valorMD5 = messageDisgest.digest(valor.getBytes("UTF-8"));
			StringBuffer sb = new StringBuffer();
			for (byte b : valorMD5) {
				sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
			}

			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}

	}

	public String acaoSair() {
		return CaminhoURL.REQUEST_PATH_LOGIN + CaminhoURL.FACES_REDIRECT;
	}

}
