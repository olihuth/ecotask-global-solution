package br.com.fiap.ecotask.controller;

import br.com.fiap.ecotask.model.Tarefa;
import br.com.fiap.ecotask.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    // POST: Empresa cria uma tarefa (ou IoT cria automaticamente)
    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        // Simulação: Se vier sem status, define como DISPONIVEL
        if (tarefa.getStatusTarefa() == null) {
            tarefa.setStatusTarefa("DISPONIVEL");
        }
        return repository.save(tarefa);
    }

    // GET: Lista TODAS as tarefas
    @GetMapping
    public List<Tarefa> listarTodas() {
        return repository.findAll();
    }

    // GET: Lista apenas tarefas DISPONIVEIS (Usado no Mobile)
    @GetMapping("/disponiveis")
    public List<Tarefa> listarDisponiveis() {
        return repository.findByStatusTarefa("DISPONIVEL");
    }

    // Endpoint para o Simulador de IoT chamar
    // Exemplo: POST /api/tarefas/iot/alertar-lixeira-cheia
    @PostMapping("/iot/alertar-lixeira-cheia")
    public Tarefa receberAlertaIot() {
        Tarefa tarefaAutomatica = new Tarefa();
        tarefaAutomatica.setTitulo("ALERTA IOT: Lixeira Inteligente #42 Cheia");
        tarefaAutomatica.setDescricao("O sensor detectou capacidade máxima. Esvaziar urgente.");
        tarefaAutomatica.setValorPagamento(new java.math.BigDecimal("15.00"));
        tarefaAutomatica.setStatusTarefa("DISPONIVEL");

        // Nota: Em um sistema real, buscaríamos a Empresa dona da lixeira pelo ID do sensor.
        // Aqui vamos fixar uma "Empresa do Sistema" (ID 1) para o protótipo não quebrar.
        br.com.fiap.ecotask.model.Empresa empresaSistema = new br.com.fiap.ecotask.model.Empresa();
        empresaSistema.setId(1L); // Assume que já existe a empresa 1
        tarefaAutomatica.setEmpresa(empresaSistema);

        return repository.save(tarefaAutomatica);
    }

}