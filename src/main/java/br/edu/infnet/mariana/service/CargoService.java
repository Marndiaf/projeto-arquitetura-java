package br.edu.infnet.mariana.service;

import br.edu.infnet.mariana.domain.Cargo;
import br.edu.infnet.mariana.repository.CargoRepository;

import org.springframework.stereotype.Service;

@Service
public class CargoService {
    private final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void cadastrarCargo(Cargo cargo) {
        cargoRepository.save(cargo);
    }
}
