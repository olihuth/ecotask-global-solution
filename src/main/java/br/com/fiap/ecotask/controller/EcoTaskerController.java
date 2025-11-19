package br.com.fiap.ecotask.controller;

import br.com.fiap.ecotask.model.EcoTasker;
import br.com.fiap.ecotask.repository.EcoTaskerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ecotaskers")
public class EcoTaskerController {

    @Autowired
    private EcoTaskerRepository repository;

    // GET: Listar todos os trabalhadores
    @GetMapping
    public List<EcoTasker> listarTodos() {
        return repository.findAll();
    }

    // GET: Buscar um trabalhador específico pelo ID
    @GetMapping("/{id}")
    public EcoTasker buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // POST: Cadastrar um novo trabalhador (EcoTasker)
    @PostMapping
    public EcoTasker criar(@RequestBody EcoTasker ecoTasker) {
        return repository.save(ecoTasker);
    }
}