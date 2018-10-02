package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.dao.FuncaoDAO;
import modelo.dominio.Funcao;

@ManagedBean(name = "FuncaoMB")
@SessionScoped
public class FuncaoMB {

	private FuncaoDAO dao = new FuncaoDAO();
	private Funcao funcao = new Funcao();

	private List<Funcao> funcoes = null;

	public void setDao(FuncaoDAO dao) {
		this.dao = dao;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public List<Funcao> getFuncoes() {
		if (this.funcoes == null)
			this.funcoes = this.dao.lerTodos();

		return funcoes;
	}

	public void setFuncoes(List<Funcao> funcoes) {
		this.funcoes = funcoes;
	}

}
