package controle;

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
		this.dao.salvar(this.funcionario);

		return acaoListar();
	}

	public String acaoExcluir(Integer matricula) {
		this.funcionario = this.dao.lerPorId(matricula);
		if (this.funcionario != null)
			this.dao.excluir(this.funcionario);

		return acaoListar();
	}

}
