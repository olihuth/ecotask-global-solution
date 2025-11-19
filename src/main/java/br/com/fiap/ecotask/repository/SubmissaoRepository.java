package br.com.fiap.ecotask.repository;

import br.com.fiap.ecotask.model.Submissao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubmissaoRepository extends JpaRepository<Submissao, Long> {

    // Busca submissões de um EcoTasker específico
    List<Submissao> findByEcoTaskerId(Long ecotaskerId);
}