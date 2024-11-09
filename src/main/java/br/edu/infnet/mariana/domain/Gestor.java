package br.edu.infnet.mariana.domain;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Gestor extends Pessoa {

    @OneToMany(mappedBy = "gestor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Funcionario> funcionariosGerenciados;

    public Gestor() {
        super();
    }

    public Gestor(String nome, List<Funcionario> funcionariosGerenciados) {
        super(0, nome);
        this.funcionariosGerenciados = funcionariosGerenciados;
    }

    @Override
    public String toString() {
        return "Gestor: " + super.getNome() + " | Id: " + super.getId() + " | Total de funcionários gerenciados: " 
                + (funcionariosGerenciados != null ? funcionariosGerenciados.size() : 0);
    }

    public List<Funcionario> getFuncionariosGerenciados() {
        return funcionariosGerenciados;
    }

    public void setFuncionariosGerenciados(List<Funcionario> funcionariosGerenciados) {
        this.funcionariosGerenciados = funcionariosGerenciados;
    }
}
