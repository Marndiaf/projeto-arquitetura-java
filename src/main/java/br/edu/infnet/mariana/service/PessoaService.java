package br.edu.infnet.mariana.service;

import br.edu.infnet.mariana.domain.Pessoa;
import br.edu.infnet.mariana.repository.PessoaRepository;

import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }
}
