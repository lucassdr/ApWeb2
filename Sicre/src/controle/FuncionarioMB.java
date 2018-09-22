package controle;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import componentes.CaminhoURL;
import modelo.dao.FuncionarioDAO;
import modelo.dominio.Funcionario;

@ManagedBean(name = "FuncionarioMB")
@SessionScoped
public class FuncionarioMB {

	// Atributos
	private FuncionarioDAO dao = new FuncionarioDAO();
	private Funcionario funcionario = new Funcionario();

	private List<Funcionario> funcionarios = null;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		if (this.funcionarios == null)
			this.funcionarios = this.dao.lerTodos();

		return dao.lerTodos();

	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	// Métodos
	public String acaoListar() {
		return CaminhoURL.REQUEST_PATH_EMPLOYEE_LIST + CaminhoURL.FACES_REDIRECT;
	}

	public String abrirInclusao() {
		this.funcionario = new Funcionario();

		return CaminhoURL.REQUEST_PATH_EMPLOYEE;
	}

	public String acaoAbrirAlteracao(Integer matricula) {
		this.funcionario = this.dao.lerPorId(matricula);

		return CaminhoURL.REQUEST_PATH_EMPLOYEE;
	}

	public String acaoSalvar() {
		String senhaTemporaria = funcionario.getSenha();
		convertStringToMD5(funcionario.getSenha());
		funcionario.setSenha(convertStringToMD5(senhaTemporaria));		
		this.dao.salvar(this.funcionario);
		return acaoListar();
	}

	public String acaoExcluir(Integer matricula) {
		this.funcionario = this.dao.lerPorId(matricula);
		if (this.funcionario != null)
			this.dao.excluir(this.funcionario);

		return acaoListar();
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

}
