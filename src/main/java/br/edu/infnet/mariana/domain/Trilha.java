package br.edu.infnet.mariana.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Trilha {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(length = 255)
	private String descricao;

	@Column(nullable = false)
	private boolean ativa = true;
	
	@OneToMany(mappedBy = "trilha")
	private List<Conhecimento> conhecimentos;

	public Trilha(int id, String nome, String descricao, boolean ativa) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.ativa = ativa;
	}
	
	@Override
	public String toString() {
		return "Trilha: " + " | Id: " + id + " | Nome: " + nome + " | Descrição: " + descricao + " | Ativa: " + ativa;
	}
	
	public Trilha() {
		
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean getAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
}