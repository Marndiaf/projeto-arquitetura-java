package br.edu.infnet.mariana.service;

import br.edu.infnet.mariana.domain.Conhecimento;
import br.edu.infnet.mariana.repository.ConhecimentoRepository;

import org.springframework.stereotype.Service;

@Service
public class ConhecimentoService {
    private final ConhecimentoRepository conhecimentoRespository;

    public ConhecimentoService(ConhecimentoRepository conhecimentoRespository) {
        this.conhecimentoRespository = conhecimentoRespository;
    }

    public void cadastrarConhecimento(Conhecimento conhecimento) {
    	conhecimentoRespository.save(conhecimento);
    }
}
