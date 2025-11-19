package br.com.fiap.ecotask.repository;

import br.com.fiap.ecotask.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // O Spring já cria findById, save, delete, findAll automaticamente!
    Usuario findByEmail(String email);
}