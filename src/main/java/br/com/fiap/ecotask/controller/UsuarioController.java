package br.com.fiap.ecotask.controller;

import br.com.fiap.ecotask.model.Usuario;
import br.com.fiap.ecotask.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    // GET: Listar todos (Para debug)
    @GetMapping
    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    // POST: Criar novo usuário
    @Autowired
    private br.com.fiap.ecotask.service.AuthService authService; // Injete o serviço

    @PostMapping
    public Usuario criar(@RequestBody @jakarta.validation.Valid Usuario usuario) {
        // Criptografa a senha antes de salvar no banco
        String senhaCriptografada = authService.criptografarSenha(usuario.getSenhaHash());
        usuario.setSenhaHash(senhaCriptografada);

        return repository.save(usuario);
    }

    // GET: Buscar por ID
    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}