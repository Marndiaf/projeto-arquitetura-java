package br.edu.infnet.mariana.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Funcionario extends Pessoa {
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gestor_id")
    private Gestor gestor;

    @OneToMany(mappedBy = "funcionario")
    private List<Avaliacao> avaliacoes;

    public Funcionario(String nome, Cargo cargo, Gestor gestor) {
        super(0, nome);
        this.cargo = cargo;
        this.gestor = gestor;
    }

    public Funcionario() {
        super();
    }

    @Override
    public String toString() {
        return "Funcionário: " + super.getNome() + " | Id:" + super.getId() + " | Cargo: " 
                + (cargo != null ? cargo.getNome() : "Sem cargo") 
                + " | Gestor Id: " + (gestor != null ? gestor.getId() : "Sem gestor");
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }
}
