package br.com.fiap.ecotask.repository;

import br.com.fiap.ecotask.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}