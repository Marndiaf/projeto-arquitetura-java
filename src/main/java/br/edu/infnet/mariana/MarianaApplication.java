package br.edu.infnet.mariana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class MarianaApplication implements CommandLineRunner {

    @Autowired
    private Loader loader;

    public static void main(String[] args) {
        SpringApplication.run(MarianaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Pessoa");
            System.out.println("2. Cadastrar Cargo");
            System.out.println("3. Cadastrar Trilha");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    loader.cadastrarPessoa(scanner);
                    break;
                case 2:
                    loader.cadastrarCargo(scanner);
                    break;
                case 3:
                    loader.cadastrarTrilha(scanner);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
