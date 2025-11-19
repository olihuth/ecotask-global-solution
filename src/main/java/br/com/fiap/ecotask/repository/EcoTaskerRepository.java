package br.com.fiap.ecotask.repository;

import br.com.fiap.ecotask.model.EcoTasker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EcoTaskerRepository extends JpaRepository<EcoTasker, Long> {
}