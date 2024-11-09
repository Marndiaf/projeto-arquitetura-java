package br.edu.infnet.mariana.service;

import br.edu.infnet.mariana.domain.Funcionario;
import br.edu.infnet.mariana.domain.Gestor;
import br.edu.infnet.mariana.repository.FuncionarioRepository;
import br.edu.infnet.mariana.repository.GestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestorService {

    @Autowired
    private GestorRepository gestorRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> buscarFuncionariosDoGestor(int gestorId) {
        return funcionarioRepository.findByGestorId(gestorId);
    }

    public void salvarGestor(Gestor gestor) {
        gestorRepository.save(gestor);
    }

    public Gestor buscarGestorPorId(int id) {
        return gestorRepository.findById(id).orElse(null);
    }    
    
    public void excluirGestorPorId(int id) {
    	gestorRepository.deleteById(id); 
    }

    public List<Gestor> listarTodosGestores() {
        return gestorRepository.findAll();
    }
}
