package modelo.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tab_empresa")
@SequenceGenerator(name = "EMPRESA_PK", sequenceName = "SEQ_EMPRESA_PK", allocationSize = 1, initialValue = 3000)
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPRESA_PK")
	private Integer id;

	@Column(name = "CNPJ", length = 18, unique = true, nullable = false)
	private String cnpj;

	@Column(name = "RAZAO_SOCIAL", unique = true, nullable = false)
	private String razaoSocial;

	@Column(name = "NOME_FANTASIA", nullable = true)
	private String nomeFantasia;

	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
	private List<Funcionario> funcionarios;

	public Empresa() {
		super();
	}

	public Empresa(Integer id, String cnpj, String razaoSocial, String nomeFantasia, List<Funcionario> funcionarios) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.funcionarios = funcionarios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {
		return id + "";
	}

}
