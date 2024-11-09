package br.edu.infnet.mariana.repository;

import br.edu.infnet.mariana.domain.Trilha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrilhaRepository extends JpaRepository<Trilha, Integer> {

}
