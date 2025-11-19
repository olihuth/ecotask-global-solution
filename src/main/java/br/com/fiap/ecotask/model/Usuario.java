package br.com.fiap.ecotask.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email; // Import novo
import jakarta.validation.constraints.NotBlank; // Import novo
import lombok.Data;

@Data
@Entity
@Table(name = "Usuarios")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "O email é obrigatório") // Validação
    @Email(message = "Formato de email inválido") // Validação
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "A senha é obrigatória")
    @JsonIgnore // SEGURANÇA: A senha (mesmo hash) nunca sai da API no GET
    private String senhaHash;

    @Column(nullable = false)
    private String perfil;
}