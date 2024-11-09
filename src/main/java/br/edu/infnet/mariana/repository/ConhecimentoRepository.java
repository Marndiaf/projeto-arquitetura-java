package br.edu.infnet.mariana.repository;

import br.edu.infnet.mariana.domain.Conhecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConhecimentoRepository extends JpaRepository<Conhecimento, Integer> {
    
}
