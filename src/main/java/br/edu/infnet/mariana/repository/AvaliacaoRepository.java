package br.edu.infnet.mariana.repository;

import br.edu.infnet.mariana.domain.Avaliacao;
import br.edu.infnet.mariana.domain.Conhecimento;
import br.edu.infnet.mariana.domain.Funcionario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {

	List<Avaliacao> findByFuncionarioAndConhecimento(Funcionario funcionario, Conhecimento conhecimento);
}
