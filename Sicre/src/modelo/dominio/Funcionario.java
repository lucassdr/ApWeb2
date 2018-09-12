package modelo.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tab_funcionario")
@SequenceGenerator(name = "FUNCIONARIO_PK", sequenceName = "SEQ_FUNCIONARIO_PK", allocationSize = 1, initialValue = 3000)
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FUNCIONARIO_PK")
	private Integer id;

	@Column(name = "NOME", nullable = false)
	private String nome;

	@Column(name = "DATA_NASCIMENTO", nullable = false)
	private Date dataNascimento;

	@Column(name = "SEXO", length = 10, nullable = false)
	private String sexo;

	@Column(name = "CPF", length = 14, nullable = false, unique = true)
	private String cpf;

	@Column(name = "MATRICULA", length = 10, nullable = false, unique = true)
	private String matricula;

	@Column(name = "SENHA", nullable = false)
	private String senha;

	public Funcionario() {
		super();
	}

	public Funcionario(Integer id, String nome, Date dataNascimento, String sexo, String cpf, String matricula,
			String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.matricula = matricula;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
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

	public boolean isSenhaCorreta(String senhaDigitada) {
		if (this.senha.equals(senhaDigitada)) {
			return true;
		} else {
			return false;
		}
	}

}
