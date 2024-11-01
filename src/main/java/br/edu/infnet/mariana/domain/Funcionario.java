package br.edu.infnet.mariana.domain;

public class Funcionario extends Pessoa {
    private Cargo cargo;

    public Funcionario(int id, String nome, Cargo cargo) {
        super(id, nome);
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}