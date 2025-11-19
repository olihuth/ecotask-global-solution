package br.com.fiap.ecotask.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Transforma "123456" em "$2a$10$EixZaY..."
    public String criptografarSenha(String senhaPura) {
        return passwordEncoder.encode(senhaPura);
    }

    // Verifica se a senha bate com o hash
    public boolean verificarSenha(String senhaPura, String hashSalvo) {
        return passwordEncoder.matches(senhaPura, hashSalvo);
    }
}