package br.com.fiap.ecotask.repository;

import br.com.fiap.ecotask.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    // Magic Method: O Spring entende o nome e cria o SQL "WHERE status_tarefa = ?"
    List<Tarefa> findByStatusTarefa(String status);
}