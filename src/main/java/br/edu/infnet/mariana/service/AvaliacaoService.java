package br.edu.infnet.mariana.service;

import br.edu.infnet.mariana.domain.Avaliacao;
import br.edu.infnet.mariana.domain.Conhecimento;
import br.edu.infnet.mariana.domain.Funcionario;
import br.edu.infnet.mariana.repository.AvaliacaoRepository;

import java.util.List;

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
    
    public List<Avaliacao> buscarAvaliacoesPorFuncionarioEConhecimento(Funcionario funcionario, Conhecimento conhecimento) {
        return avaliacaoRepository.findByFuncionarioAndConhecimento(funcionario, conhecimento);
    }
}
