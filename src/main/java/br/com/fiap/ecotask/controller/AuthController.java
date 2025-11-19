package br.com.fiap.ecotask.controller;

import br.com.fiap.ecotask.model.Usuario;
import br.com.fiap.ecotask.repository.UsuarioRepository;
import br.com.fiap.ecotask.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuthService authService;

    // DTO (Data Transfer Object) simples para receber login
    public record LoginRequest(String email, String senha) {}

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest requisicao) {
        // 1. Busca usuário pelo email (vamos ter que criar esse método no Repository)
        Usuario usuario = usuarioRepository.findByEmail(requisicao.email());

        if (usuario == null) {
            return ResponseEntity.status(401).body("Usuário não encontrado");
        }

        // 2. Verifica se a senha bate
        if (authService.verificarSenha(requisicao.senha(), usuario.getSenhaHash())) {
            // Login Sucesso! Retorna o usuário (sem a senha, graças ao @JsonIgnore)
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(401).body("Senha incorreta");
        }
    }
}