package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.dao.EmpresaDAO;
import modelo.dominio.Empresa;

@ManagedBean(name="EmpresaMB")
@SessionScoped
public class EmpresaMB {

	private EmpresaDAO dao = new EmpresaDAO();
	private Empresa empresa = new Empresa();

	private List<Empresa> empresas = null;

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Empresa> getEmpresas() {
		if (this.empresas == null)
			this.empresas = this.dao.lerTodos();

		return dao.lerTodos();
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

}
