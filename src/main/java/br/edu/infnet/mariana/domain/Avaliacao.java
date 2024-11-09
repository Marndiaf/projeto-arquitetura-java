package br.edu.infnet.mariana.domain;

import jakarta.persistence.*;

@Entity
public class Avaliacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "conhecimento_id")
	private Conhecimento conhecimento;

	@Column(nullable = false, length = 50)
	private String tipo; 

	@Column(nullable = false)
	private float nota;

	public Avaliacao(int id, Funcionario funcionario, Conhecimento conhecimento, String tipo, float nota) {
		this.id = id;
		this.funcionario = funcionario;
		this.conhecimento = conhecimento;
		this.tipo = tipo;
		this.nota = nota;
	}
	
	public Avaliacao() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Funcionario gatFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Conhecimento getConhecimento() {
		return conhecimento;
	}

	public void setConhecimento(Conhecimento conhecimento) {
		this.conhecimento = conhecimento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}
}