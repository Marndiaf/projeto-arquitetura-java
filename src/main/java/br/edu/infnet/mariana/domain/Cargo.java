package br.edu.infnet.mariana.domain;

public class Cargo {
    private int id;
    private String nome;
    private String nivel;

    public Cargo(int id, String nome, String nivel) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
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