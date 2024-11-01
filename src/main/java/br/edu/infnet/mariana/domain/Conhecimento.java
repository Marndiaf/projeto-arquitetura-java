package br.edu.infnet.mariana.domain;

public class Conhecimento {
    private int id;
    private String nome;
    private Trilha trilha;

    public Conhecimento(int id, String nome, Trilha trilha) {
        this.id = id;
        this.nome = nome;
        this.trilha = trilha;
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

    public Trilha getTrilha() {
        return trilha;
    }

    public void setTrilha(Trilha trilha) {
        this.trilha = trilha;
    }
}