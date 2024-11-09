package br.edu.infnet.mariana.service;

import br.edu.infnet.mariana.domain.Funcionario;
import br.edu.infnet.mariana.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void salvarFuncionario(Funcionario funcionario) {
        funcionarioRepository.save(funcionario); 
    }

    public Funcionario buscarFuncionarioPorId(int id) {
        return funcionarioRepository.findById(id).orElse(null); 
    }
    
    public void excluirFuncionarioPorId(int id) {
    	funcionarioRepository.deleteById(id); 
    }

    public List<Funcionario> listarTodosFuncionarios() {
        return funcionarioRepository.findAll(); 
    }
}
