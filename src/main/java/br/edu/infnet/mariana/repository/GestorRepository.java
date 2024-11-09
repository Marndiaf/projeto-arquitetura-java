package br.edu.infnet.mariana.repository;

import br.edu.infnet.mariana.domain.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestorRepository extends JpaRepository<Gestor, Integer> {

}
