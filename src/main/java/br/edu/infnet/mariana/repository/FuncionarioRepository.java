package br.edu.infnet.mariana.repository;

import br.edu.infnet.mariana.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    List<Funcionario> findByGestorId(Integer gestorId);
}
