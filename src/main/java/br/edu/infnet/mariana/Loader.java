package br.edu.infnet.mariana;

import br.edu.infnet.mariana.domain.Avaliacao;
import br.edu.infnet.mariana.domain.Cargo;
import br.edu.infnet.mariana.domain.Gestor;
import br.edu.infnet.mariana.domain.Funcionario;
import br.edu.infnet.mariana.domain.Trilha;
import br.edu.infnet.mariana.domain.Conhecimento;
import br.edu.infnet.mariana.service.CargoService;
import br.edu.infnet.mariana.service.FuncionarioService;
import br.edu.infnet.mariana.service.GestorService;
import br.edu.infnet.mariana.service.TrilhaService;
import br.edu.infnet.mariana.service.ConhecimentoService;
import br.edu.infnet.mariana.service.AvaliacaoService;

import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loader {
    private final GestorService gestorService;
    private final FuncionarioService funcionarioService;
    private final CargoService cargoService;
    private final TrilhaService trilhaService;
    private final ConhecimentoService conhecimentoService;
    private final AvaliacaoService avaliacaoService;

    public Loader(GestorService gestorService, FuncionarioService funcionarioService, CargoService cargoService,
                  TrilhaService trilhaService, ConhecimentoService conhecimentoService, AvaliacaoService avaliacaoService) {
        this.gestorService = gestorService;
        this.funcionarioService = funcionarioService;
        this.cargoService = cargoService;
        this.trilhaService = trilhaService;
        this.conhecimentoService = conhecimentoService;
        this.avaliacaoService = avaliacaoService;
    }
    
    // Métodos para Funcionario
    public void cadastrarFuncionario(Scanner scanner) {
        System.out.print("Nome do funcionário: ");
        String nome = scanner.nextLine();

        System.out.print("ID do cargo: ");
        int cargoId = scanner.nextInt();
        scanner.nextLine();

        Cargo cargo = cargoService.buscarCargoPorId(cargoId);
        if (cargo == null) {
            System.out.println("Cargo não encontrado. Verifique o ID e tente novamente.");
            return;
        }

        System.out.print("ID do gestor: ");
        int gestorId = scanner.nextInt();
        scanner.nextLine();

        Gestor gestor = gestorService.buscarGestorPorId(gestorId);
        if (gestor == null) {
            System.out.println("Gestor não encontrado. Verifique o ID e tente novamente.");
            return;
        }

        Funcionario funcionario = new Funcionario(nome, cargo, gestor);
        funcionarioService.salvarFuncionario(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public void listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.listarTodosFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            funcionarios.forEach(System.out::println);
        }
    }

    public void editarFuncionario(Scanner scanner) {
        System.out.print("ID do funcionário a ser editado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(id);
        if (funcionario != null) {
            System.out.print("Novo nome do funcionário: ");
            String novoNome = scanner.nextLine();
            funcionario.setNome(novoNome);

            System.out.print("Novo ID do cargo: ");
            int novoCargoId = scanner.nextInt();
            scanner.nextLine();

            Cargo novoCargo = cargoService.buscarCargoPorId(novoCargoId);
            if (novoCargo != null) {
                funcionario.setCargo(novoCargo);
            } else {
                System.out.println("Cargo não encontrado. Mantendo o cargo atual.");
            }

            System.out.print("Novo ID do gestor: ");
            int novoGestorId = scanner.nextInt();
            scanner.nextLine();

            Gestor novoGestor = gestorService.buscarGestorPorId(novoGestorId);
            if (novoGestor != null) {
                funcionario.setGestor(novoGestor);
            } else {
                System.out.println("Gestor não encontrado. Mantendo o gestor atual.");
            }

            funcionarioService.salvarFuncionario(funcionario);
            System.out.println("Funcionário atualizado com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public void excluirFuncionario(Scanner scanner) {
        System.out.print("ID do funcionário a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(id);
        if (funcionario != null) {
            funcionarioService.excluirFuncionarioPorId(id);
            System.out.println("Funcionário excluído com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    // Métodos para Gestor
    public void cadastrarGestor(Scanner scanner) {
        System.out.print("Nome do gestor: ");
        String nome = scanner.nextLine();

        List<Funcionario> funcionariosGerenciados = new ArrayList<>();
        System.out.print("Deseja adicionar funcionários gerenciados? (s/n): ");
        String resposta = scanner.nextLine().toLowerCase();

        while (resposta.equals("s")) {
            System.out.print("ID do funcionário gerenciado: ");
            int funcionarioId = scanner.nextInt();
            scanner.nextLine();

            Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(funcionarioId);
            if (funcionario != null) {
                funcionariosGerenciados.add(funcionario);
                System.out.println("Funcionário adicionado.");
            } else {
                System.out.println("Funcionário não encontrado. Verifique o ID.");
            }

            System.out.print("Deseja adicionar outro funcionário? (s/n): ");
            resposta = scanner.nextLine().toLowerCase();
        }

        Gestor gestor = new Gestor(nome, funcionariosGerenciados);
        gestorService.salvarGestor(gestor);
        System.out.println("Gestor cadastrado com sucesso!");
    }

    public void listarGestores() {
        List<Gestor> gestores = gestorService.listarTodosGestores();
        if (gestores.isEmpty()) {
            System.out.println("Nenhum gestor cadastrado.");
        } else {
            gestores.forEach(System.out::println);
        }
    }

    public void editarGestor(Scanner scanner) {
        System.out.print("ID do gestor a ser editado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Gestor gestor = gestorService.buscarGestorPorId(id);
        if (gestor != null) {
            System.out.print("Novo nome do gestor: ");
            String novoNome = scanner.nextLine();
            gestor.setNome(novoNome);
            gestorService.salvarGestor(gestor);
            System.out.println("Gestor atualizado com sucesso!");
        } else {
            System.out.println("Gestor não encontrado.");
        }
    }

    public void excluirGestor(Scanner scanner) {
        System.out.print("ID do gestor a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Gestor gestor = gestorService.buscarGestorPorId(id);
        if (gestor != null) {
            gestorService.excluirGestorPorId(id);
            System.out.println("Gestor excluído com sucesso!");
        } else {
            System.out.println("Gestor não encontrado.");
        }
    }

    // Métodos para Cargo
    public void cadastrarCargo(Scanner scanner) {
        System.out.print("Nome do cargo: ");
        String nome = scanner.nextLine();

        System.out.print("Nível do cargo: ");
        String nivel = scanner.nextLine();
        Cargo cargo = new Cargo(0, nome, nivel);
        cargoService.salvarCargo(cargo);
        System.out.println("Cargo cadastrado com sucesso!");
    }

    public void listarCargos() {
        List<Cargo> cargos = cargoService.listarTodosCargos();
        if (cargos.isEmpty()) {
            System.out.println("Nenhum cargo encontrado.");
        } else {
            cargos.forEach(System.out::println);
        }
    }

    public void editarCargo(Scanner scanner) {
        System.out.print("ID do cargo a ser editado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Cargo cargo = cargoService.buscarCargoPorId(id);
        if (cargo != null) {
            System.out.print("Novo nome do cargo: ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo nível do cargo: ");
            String novoNivel = scanner.nextLine();

            cargo.setNome(novoNome);
            cargo.setNivel(novoNivel);
            cargoService.salvarCargo(cargo);
            System.out.println("Cargo atualizado com sucesso!");
        } else {
            System.out.println("Cargo não encontrado.");
        }
    }

    public void excluirCargo(Scanner scanner) {
        System.out.print("ID do cargo a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Cargo cargo = cargoService.buscarCargoPorId(id);
        if (cargo != null) {
            cargoService.excluirCargoPorId(id);
            System.out.println("Cargo excluído com sucesso!");
        } else {
            System.out.println("Cargo não encontrado.");
        }
    }

    // Métodos para Trilha
    public void cadastrarTrilha(Scanner scanner) {
        System.out.print("Nome da trilha: ");
        String nome = scanner.nextLine();

        System.out.print("Descrição da trilha: ");
        String descricao = scanner.nextLine();

        Trilha trilha = new Trilha(0, nome, descricao, true);
        trilhaService.salvarTrilha(trilha);
        System.out.println("Trilha cadastrada com sucesso!");
    }

    public void listarTrilhas() {
        List<Trilha> trilhas = trilhaService.listarTodasTrilhas();
        if (trilhas.isEmpty()) {
            System.out.println("Nenhuma trilha cadastrada.");
        } else {
            trilhas.forEach(System.out::println);
        }
    }

    public void editarTrilha(Scanner scanner) {
        System.out.print("ID da trilha a ser editada: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Trilha trilha = trilhaService.buscarTrilhaPorId(id);
        if (trilha != null) {
            System.out.print("Novo nome da trilha: ");
            String novoNome = scanner.nextLine();
            System.out.print("Nova descrição da trilha: ");
            String novaDescricao = scanner.nextLine();
            trilha.setNome(novoNome);
            trilha.setDescricao(novaDescricao);
            trilhaService.salvarTrilha(trilha);
            System.out.println("Trilha atualizada com sucesso!");
        } else {
            System.out.println("Trilha não encontrada.");
        }
    }

    public void excluirTrilha(Scanner scanner) {
        System.out.print("ID da trilha a ser excluída: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Trilha trilha = trilhaService.buscarTrilhaPorId(id);
        if (trilha != null) {
            trilhaService.excluirTrilhaPorId(id);
            System.out.println("Trilha excluída com sucesso!");
        } else {
            System.out.println("Trilha não encontrada.");
        }
    }
    
    //Métodos para Conhecimento
    public void cadastrarConhecimento(Scanner scanner) {
        System.out.print("Nome do conhecimento: ");
        String nome = scanner.nextLine();

        System.out.print("Nível do conhecimento: ");
        int nivel = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID da trilha relacionada: ");
        int trilhaId = scanner.nextInt();
        scanner.nextLine();

        Trilha trilha = trilhaService.buscarTrilhaPorId(trilhaId);
        if (trilha == null) {
            System.out.println("Trilha não encontrada. Verifique o ID e tente novamente.");
            return;
        }

        Conhecimento conhecimento = new Conhecimento(0, nome, trilha);
        conhecimento.setNivel(nivel);
        conhecimentoService.salvarConhecimento(conhecimento);
        System.out.println("Conhecimento cadastrado com sucesso!");
    }

    public void listarConhecimentos() {
        List<Conhecimento> conhecimentos = conhecimentoService.listarTodosConhecimentos();
        if (conhecimentos.isEmpty()) {
            System.out.println("Nenhum conhecimento cadastrado.");
        } else {
            System.out.println("Lista de Conhecimentos:");
            conhecimentos.forEach(conhecimento -> 
                System.out.println("ID: " + conhecimento.getId() + ", Nome: " + conhecimento.getNome() + ", Nível: " + conhecimento.getNivel()));
        }
    }

    public void editarConhecimento(Scanner scanner) {
        System.out.print("ID do conhecimento a ser editado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Conhecimento conhecimento = conhecimentoService.buscarConhecimentoPorId(id);
        if (conhecimento != null) {
            System.out.print("Novo nome do conhecimento: ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo nível do conhecimento: ");
            int novoNivel = scanner.nextInt();
            scanner.nextLine();

            conhecimento.setNome(novoNome);
            conhecimento.setNivel(novoNivel);
            conhecimentoService.salvarConhecimento(conhecimento);
            System.out.println("Conhecimento atualizado com sucesso!");
        } else {
            System.out.println("Conhecimento não encontrado.");
        }
    }

    public void excluirConhecimento(Scanner scanner) {
        System.out.print("ID do conhecimento a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Conhecimento conhecimento = conhecimentoService.buscarConhecimentoPorId(id);
        if (conhecimento != null) {
            conhecimentoService.excluirConhecimentoPorId(id);
            System.out.println("Conhecimento excluído com sucesso!");
        } else {
            System.out.println("Conhecimento não encontrado.");
        }
    }
    
    //Métodos para Avaliação
    
    public void salvarAvaliacoesDeArquivo(String caminhoArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");

                if (dados.length != 4) {
                    System.out.println("Linha inválida no CSV: " + linha);
                    continue;
                }

                int funcionarioId = Integer.parseInt(dados[0].trim());
                int conhecimentoId = Integer.parseInt(dados[1].trim());
                String tipo = dados[2].trim();
                float nota = Float.parseFloat(dados[3].trim());
                
                Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(funcionarioId);
                Conhecimento conhecimento = conhecimentoService.buscarConhecimentoPorId(conhecimentoId);

                if (funcionario == null) {
                    System.out.println("Funcionário com ID " + funcionarioId + " não encontrado. Linha ignorada.");
                    continue;
                }

                if (conhecimento == null) {
                    System.out.println("Conhecimento com ID " + conhecimentoId + " não encontrado. Linha ignorada.");
                    continue;
                }

                Avaliacao avaliacao = new Avaliacao(0, funcionario, conhecimento, tipo, nota);
                avaliacaoService.salvarAvaliacao(avaliacao);
                System.out.println("Avaliação salva: " + avaliacao);
            }
            System.out.println("Processamento de arquivo concluído.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter dados numéricos no arquivo: " + e.getMessage());
        }
    }
    
    public void exibirMediaConhecimentoFuncionario(int funcionarioId, int conhecimentoId) {
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(funcionarioId);
        Conhecimento conhecimento = conhecimentoService.buscarConhecimentoPorId(conhecimentoId);

        if (funcionario == null) {
            System.out.println("Funcionário com ID " + funcionarioId + " não encontrado.");
            return;
        }

        if (conhecimento == null) {
            System.out.println("Conhecimento com ID " + conhecimentoId + " não encontrado.");
            return;
        }

        List<Avaliacao> avaliacoes = avaliacaoService.buscarAvaliacoesPorFuncionarioEConhecimento(funcionario, conhecimento);

        if (avaliacoes.isEmpty()) {
            System.out.println("Nenhuma avaliação encontrada para o funcionário " + funcionarioId + " no conhecimento " + conhecimentoId);
            return;
        }

        double soma = 0;
        for (Avaliacao avaliacao : avaliacoes) {
            soma += avaliacao.getNota();
        }
        double media = soma / avaliacoes.size();

        System.out.printf("Média de conhecimento do funcionário %d no conhecimento %d: %.2f%n", funcionarioId, conhecimentoId, media);
    }
}
