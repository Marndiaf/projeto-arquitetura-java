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
            System.out.println("--------------------------");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Editar Funcionário");
            System.out.println("3. Exibir Funcionários");
            System.out.println("4. Excluir Funcionário");
            System.out.println("--------------------------");
            System.out.println("5. Cadastrar Gestor");
            System.out.println("6. Editar Gestor");
            System.out.println("7. Exibir Gestores");
            System.out.println("8. Excluir Gestor");
            System.out.println("--------------------------");
            System.out.println("9. Cadastrar Cargo");
            System.out.println("10. Editar Cargo");
            System.out.println("11. Exibir Cargos");
            System.out.println("12. Excluir Cargo");
            System.out.println("--------------------------");
            System.out.println("13. Cadastrar Trilha");
            System.out.println("14. Editar Trilha");
            System.out.println("15. Exibir Trilhas");
            System.out.println("16. Excluir Trilha");
            System.out.println("--------------------------");
            System.out.println("17. Cadastrar Conhecimento");
            System.out.println("18. Editar Conhecimento");
            System.out.println("19. Exibir Conhecimentos");
            System.out.println("20. Excluir Conhecimento");
            System.out.println("--------------------------");
            System.out.println("21. Enviar Avaliação");
            System.out.println("22. Exibir média de conhecimento de um funcionário");
            System.out.println("--------------------------");
            System.out.println("23. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    loader.cadastrarFuncionario(scanner);
                    break;
                case 2:
                    loader.editarFuncionario(scanner);
                    break;
                case 3:
                    loader.listarFuncionarios();
                    break;
                case 4:
                    loader.excluirFuncionario(scanner);
                    break;
                case 5:
                    loader.cadastrarGestor(scanner);
                    break;
                case 6:
                    loader.editarGestor(scanner);
                    break;
                case 7:
                    loader.listarGestores();
                    break;
                case 8:
                    loader.excluirGestor(scanner);
                    break;
                case 9:
                    loader.cadastrarCargo(scanner);
                    break;
                case 10:
                    loader.editarCargo(scanner);
                    break;
                case 11:
                    loader.listarCargos();
                    break;
                case 12:
                    loader.excluirCargo(scanner);
                    break;
                case 13:
                    loader.cadastrarTrilha(scanner);
                    break;
                case 14:
                    loader.editarTrilha(scanner);
                    break;
                case 15:
                    loader.listarTrilhas();
                    break;
                case 16:
                    loader.excluirTrilha(scanner);
                    break;
                case 17:
                    loader.cadastrarConhecimento(scanner);
                    break;
                case 18:
                    loader.editarConhecimento(scanner);
                    break;
                case 19:
                    loader.listarConhecimentos();
                    break;
                case 20:
                    loader.excluirConhecimento(scanner);
                    break;
                case 21:
                    System.out.print("Informe o caminho do arquivo CSV de avaliações: ");
                    String caminhoArquivo = scanner.nextLine();
                    loader.salvarAvaliacoesDeArquivo(caminhoArquivo);
                    break;
                case 22:
                    System.out.print("ID do funcionário: ");
                    int funcionarioId = scanner.nextInt();
                    System.out.print("ID do conhecimento: ");
                    int conhecimentoId = scanner.nextInt();
                    loader.exibirMediaConhecimentoFuncionario(funcionarioId, conhecimentoId);
                    break;
                case 23:
                	System.out.println("Saindo...");
                	scanner.close();
                	return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }

            System.out.println("Deseja realizar outra ação? (S/N)");
            String continuar = scanner.nextLine().trim().toUpperCase();
            if (!continuar.equals("S")) {
                System.out.println("Encerrando o sistema...");
                scanner.close();
                System.exit(0);
            }
        }
    }
}
