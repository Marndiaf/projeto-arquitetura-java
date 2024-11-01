package br.edu.infnet.mariana;

import br.edu.infnet.mariana.domain.Cargo;
import br.edu.infnet.mariana.domain.Pessoa;
import br.edu.infnet.mariana.domain.Trilha;
import br.edu.infnet.mariana.service.CargoService;
import br.edu.infnet.mariana.service.PessoaService;
import br.edu.infnet.mariana.service.TrilhaService;

import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class Loader {
    private final PessoaService pessoaService;
    private final CargoService cargoService;
    private final TrilhaService trilhaService;

    public Loader(PessoaService pessoaService, CargoService cargoService, TrilhaService trilhaService) {
        this.pessoaService = pessoaService;
        this.cargoService = cargoService;
        this.trilhaService = trilhaService;
    }

    public void cadastrarPessoa(Scanner scanner) {
        System.out.print("Nome da pessoa: ");
        String nome = scanner.nextLine();
        Pessoa pessoa = new Pessoa(0, nome); 
        pessoaService.cadastrarPessoa(pessoa);
    }

    public void cadastrarCargo(Scanner scanner) {
        System.out.print("Nome do cargo: ");
        String nome = scanner.nextLine();
        
        System.out.print("Nível do cargo: ");
        String nivel = scanner.nextLine();
        Cargo cargo = new Cargo(0, nome, nivel);
        cargoService.cadastrarCargo(cargo);
    }

    public void cadastrarTrilha(Scanner scanner) {
        System.out.print("Nome da trilha: ");
        String nome = scanner.nextLine();
        
        System.out.print("Descrição da trilha: ");
        String descricao = scanner.nextLine();

        Trilha trilha = new Trilha(0, nome, descricao, true);
        trilhaService.cadastrarTrilha(trilha);
    }
}

