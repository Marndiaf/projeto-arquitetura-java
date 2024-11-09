package br.edu.infnet.mariana.service;

import br.edu.infnet.mariana.domain.Cargo;
import br.edu.infnet.mariana.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public void salvarCargo(Cargo cargo) {
        cargoRepository.save(cargo); 
    }

    public Cargo buscarCargoPorId(int id) {
        return cargoRepository.findById(id).orElse(null); 
    }

    public void excluirCargoPorId(int id) {
        cargoRepository.deleteById(id); 
    }

    public List<Cargo> listarTodosCargos() {
        return cargoRepository.findAll(); 
    }
}
