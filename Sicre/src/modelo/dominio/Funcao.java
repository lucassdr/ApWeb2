package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table()
@SequenceGenerator(name = "FUNCAO_PK", sequenceName = "SEQ_FUNCAO_PK", allocationSize = 1, initialValue = 4000)
public class Funcao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FUNCAO_PK")
	private Integer id;

	@Column(name = "NOME", nullable = false, unique = true)
	private String nome;

	@Column(name = "CARGA_HORARIA_DIA", nullable = false)
	private Float cargaHorariaDia;

	@Column(name = "DIAS_POR_SEMANA", nullable = false)
	private Integer diasPorSemana;

	@Column(name = "HORAS_POR_SEMANA", nullable = false)
	private Float horasPorSemana;

	@Column(name = "DIAS_FOLGA_POR_SEMANA", nullable = false)
	private Integer diasFolgaPorSemana;

	@Column(name = "VALOR_POR_HORA", nullable = false)
	private Float valorPorHora;

	@Column(name = "SALARIO", nullable = false)
	private Float salario;

	public Funcao() {
		super();
	}

	public Funcao(Integer id, String nome, Float cargaHorariaDia, Integer diasPorSemana, Float horasPorSemana,
			Integer diasFolgaPorSemana, Float valorPorHora, Float salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargaHorariaDia = cargaHorariaDia;
		this.diasPorSemana = diasPorSemana;
		this.horasPorSemana = horasPorSemana;
		this.diasFolgaPorSemana = diasFolgaPorSemana;
		this.valorPorHora = valorPorHora;
		this.salario = salario;
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

	public Float getCargaHorariaDia() {
		return cargaHorariaDia;
	}

	public void setCargaHorariaDia(Float cargaHorariaDia) {
		this.cargaHorariaDia = cargaHorariaDia;
	}

	public Integer getDiasPorSemana() {
		return diasPorSemana;
	}

	public void setDiasPorSemana(Integer diasPorSemana) {
		this.diasPorSemana = diasPorSemana;
	}

	public Float getHorasPorSemana() {
		return horasPorSemana;
	}

	public void setHorasPorSemana(Float horasPorSemana) {
		this.horasPorSemana = horasPorSemana;
	}

	public Integer getDiasFolgaPorSemana() {
		return diasFolgaPorSemana;
	}

	public void setDiasFolgaPorSemana(Integer diasFolgaPorSemana) {
		this.diasFolgaPorSemana = diasFolgaPorSemana;
	}

	public Float getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Float valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

}