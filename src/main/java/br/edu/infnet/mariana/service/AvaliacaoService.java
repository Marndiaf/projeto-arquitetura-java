package br.edu.infnet.mariana.service;

import br.edu.infnet.mariana.domain.Avaliacao;
import br.edu.infnet.mariana.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public void salvarAvaliacao(Avaliacao avaliacao) {
        avaliacaoRepository.save(avaliacao);
        System.out.println("Avaliação cadastrada com sucesso!");
    }
}
