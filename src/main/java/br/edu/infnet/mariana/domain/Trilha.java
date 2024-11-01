package br.edu.infnet.mariana.domain;

public class Trilha {
    private int id;
    private String nome;
    private String descricao;
    private boolean ativa;

    public Trilha(int id, String nome, String descricao, boolean ativa) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ativa = ativa;
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