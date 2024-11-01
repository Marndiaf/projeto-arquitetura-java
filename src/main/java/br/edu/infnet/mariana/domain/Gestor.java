package br.edu.infnet.mariana.domain;

import java.util.List;

public class Gestor extends Pessoa {
    private List<Funcionario> funcionariosGerenciados;

    public Gestor(int id, String nome, List<Funcionario> funcionariosGerenciados) {
        super(id, nome);
        this.funcionariosGerenciados = funcionariosGerenciados;
    }

    public List<Funcionario> getFuncionariosGerenciados() {
        return funcionariosGerenciados;
    }

    public void setFuncionariosGerenciados(List<Funcionario> funcionariosGerenciados) {
        this.funcionariosGerenciados = funcionariosGerenciados;
    }
}