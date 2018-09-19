package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tab_funcionario")
@SequenceGenerator(name = "FUNCIONARIO_PK", sequenceName = "SEQ_FUNCIONARIO_PK", allocationSize = 1, initialValue = 2000)
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FUNCIONARIO_PK")
	private Integer matricula;

	@Column(name = "NOME", nullable = false, length = 100)
	private String nome;

	@Column(name = "SOBRENOME", nullable = false)
	private String sobrenome;

	@Column(name = "TIPO_SANGUINEIO", nullable = false)
	private String tipoSanguineo;

	@Column(name = "DATA_NASCIMENTO", length = 10, nullable = false)
	private String dataNascimento;

	@Column(name = "SEXO", length = 10)
	private String sexo;

	@Column(name = "CPF", length = 14, nullable = false, unique = true)
	private String cpf;

	@Column(name = "RG", length = 50, unique = true)
	private String rg;

	@Column(name = "SENHA", length = 50, nullable = false)
	private String senha;

	// @Column(name = "MATRICULA", length = 20, unique = true, nullable = false,)
	// private String matricula;

	@ManyToOne
	@JoinColumn(name = "id_empresa_fk")
	private Empresa empresa;

	public Funcionario() {
		super();
	}

	public Funcionario(Integer matricula, String nome, String sobrenome, String tipoSanguineo, String dataNascimento,
			String sexo, String cpf, String rg, String senha, Empresa empresa) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.tipoSanguineo = tipoSanguineo;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.rg = rg;
		this.senha = senha;
		this.empresa = empresa;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	
}
