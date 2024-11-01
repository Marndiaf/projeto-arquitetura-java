package br.edu.infnet.mariana.service;

import br.edu.infnet.mariana.domain.Trilha;
import br.edu.infnet.mariana.repository.TrilhaRepository;

import org.springframework.stereotype.Service;


@Service
public class TrilhaService {
    private final TrilhaRepository trilhaRepository;

    public TrilhaService(TrilhaRepository trilhaRepository) {
        this.trilhaRepository = trilhaRepository;
    }

    public void cadastrarTrilha(Trilha trilha) {
        trilhaRepository.save(trilha);
    }
}
