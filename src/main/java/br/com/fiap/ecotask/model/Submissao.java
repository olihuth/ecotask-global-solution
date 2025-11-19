package br.com.fiap.ecotask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Submissoes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Submissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Uma submissão pertence a uma Tarefa
    @ManyToOne
    @JoinColumn(name = "tarefa_id", nullable = false)
    private Tarefa tarefa;

    // Uma submissão é feita por um EcoTasker
    @ManyToOne
    @JoinColumn(name = "ecotasker_id", nullable = false)
    private EcoTasker ecoTasker;

    private LocalDateTime dataSubmissao = LocalDateTime.now();

    private String urlComprovacao; // Link da foto ou arquivo

    private String statusSubmissao = "PENDENTE"; // PENDENTE, APROVADA, REJEITADA
}