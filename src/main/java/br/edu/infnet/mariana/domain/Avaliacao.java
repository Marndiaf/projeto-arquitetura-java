package br.edu.infnet.mariana.domain;

public class Avaliacao {
    private int id;
    private Pessoa pessoa;
    private Conhecimento conhecimento;
    private String tipo;
    private float nota;

    public Avaliacao(int id, Pessoa pessoa, Conhecimento conhecimento, String tipo, float nota) {
        this.id = id;
        this.pessoa = pessoa;
        this.conhecimento = conhecimento;
        this.tipo = tipo;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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