package br.edu.infnet.mariana.service;

import br.edu.infnet.mariana.domain.Avaliacao;
import br.edu.infnet.mariana.repository.AvaliacaoRepository;

import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {
    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public void cadastrarAvaliacao(Avaliacao avaliacao) {
    	avaliacaoRepository.save(avaliacao);
    }
}
