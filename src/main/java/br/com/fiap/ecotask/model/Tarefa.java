package br.com.fiap.ecotask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Tarefas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Muitas tarefas pertencem a uma Empresa
    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    @Column(nullable = false)
    private String titulo;

    private String descricao;

    @Column(nullable = false)
    private BigDecimal valorPagamento;

    private String statusTarefa = "DISPONIVEL"; // DISPONIVEL, EM_ANDAMENTO, CONCLUIDA

    // Coordenadas da tarefa (Onde o trabalho é?)
    private Double latitude;
    private Double longitude;
}