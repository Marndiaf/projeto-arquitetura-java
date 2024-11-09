package br.edu.infnet.mariana.service;

import br.edu.infnet.mariana.domain.Cargo;
import br.edu.infnet.mariana.domain.Conhecimento;
import br.edu.infnet.mariana.repository.ConhecimentoRepository;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class ConhecimentoService {

    private final ConhecimentoRepository conhecimentoRepository;

    public ConhecimentoService(ConhecimentoRepository conhecimentoRepository) {
        this.conhecimentoRepository = conhecimentoRepository;
    }

    public void salvarConhecimento(Conhecimento conhecimento) {
        conhecimentoRepository.save(conhecimento);
    }
    
    public Conhecimento buscarConhecimentoPorId(int id) {
        return conhecimentoRepository.findById(id).orElse(null); 
    }

    public void excluirConhecimentoPorId(int id) {
    	conhecimentoRepository.deleteById(id); 
    }

    public List<Conhecimento> listarTodosConhecimentos() {
        return conhecimentoRepository.findAll(); 
    }
}
