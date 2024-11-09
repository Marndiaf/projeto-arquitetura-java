package br.edu.infnet.mariana.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Conhecimento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false)
	private int nivel;

	@ManyToOne
	@JoinColumn(name = "trilha_id")
	private Trilha trilha;

	@OneToMany(mappedBy = "conhecimento")
	private List<Avaliacao> avaliacoes;

	public Conhecimento(int id, String nome, Trilha trilha) {
		this.id = id;
		this.nome = nome;
		this.trilha = trilha;
	}
	
	public Conhecimento() {
		
	}
	
	@Override
	public String toString() {
		return "Conhecimento: " + " | Id: " + id + " | Nome: '" + nome + " | Nível: " + nivel + " | Trilha Id: " + trilha;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Trilha getTrilha() {
		return trilha;
	}

	public void setTrilha(Trilha trilha) {
		this.trilha = trilha;
	}
}