package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.dao.FuncaoDAO;
import modelo.dominio.Funcionario;

@ManagedBean(name = "FuncaoMB")
@SessionScoped
public class FuncaoMB {

	private FuncaoDAO dao = new FuncaoDAO();
	private Funcionario funcionario = new Funcionario();

	private List<Funcionario> funcionarios = null;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
