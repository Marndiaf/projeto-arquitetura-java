package br.edu.infnet.mariana.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false, length = 50)
	private String nivel;

	@OneToMany(mappedBy = "cargo")
	private List<Funcionario> funcionarios;

	public Cargo(int id, String nome, String nivel) {
		this.id = id;
		this.nome = nome;
		this.nivel = nivel;
	}
	
	public Cargo() {
		
	}

	@Override
	public String toString() {
		return "Cargo: " + " | Id: " + id + " | Nome: '" + nome + " | Nível: " + nivel;
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

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
}