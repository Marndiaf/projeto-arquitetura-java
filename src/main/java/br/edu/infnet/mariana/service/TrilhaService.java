package br.edu.infnet.mariana.service;

import br.edu.infnet.mariana.domain.Trilha;
import br.edu.infnet.mariana.repository.TrilhaRepository;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class TrilhaService {
    private final TrilhaRepository trilhaRepository;

    public TrilhaService(TrilhaRepository trilhaRepository) {
        this.trilhaRepository = trilhaRepository;
    }

    public void salvarTrilha(Trilha trilha) {
        trilhaRepository.save(trilha);
    }
    
    public Trilha buscarTrilhaPorId(int id) {
        return trilhaRepository.findById(id).orElse(null); 
    }

    public void excluirTrilhaPorId(int id) {
    	trilhaRepository.deleteById(id); 
    }

    public List<Trilha> listarTodasTrilhas() {
        return trilhaRepository.findAll(); 
    }    
}
