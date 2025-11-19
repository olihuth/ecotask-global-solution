package br.com.fiap.ecotask.controller;

import br.com.fiap.ecotask.model.Submissao;
import br.com.fiap.ecotask.repository.SubmissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissoes")
public class SubmissaoController {

    @Autowired
    private SubmissaoRepository repository;

    // POST: EcoTasker envia a foto/comprovação
    @PostMapping
    public Submissao enviarSubmissao(@RequestBody Submissao submissao) {
        submissao.setDataSubmissao(java.time.LocalDateTime.now());
        submissao.setStatusSubmissao("PENDENTE");
        return repository.save(submissao);
    }

    // GET: Histórico do EcoTasker (Minhas Submissões)
    @GetMapping("/me/{ecotaskerId}")
    public List<Submissao> historicoPorEcoTasker(@PathVariable Long ecotaskerId) {
        return repository.findByEcoTaskerId(ecotaskerId);
    }
}