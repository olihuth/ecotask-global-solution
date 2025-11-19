package br.com.fiap.ecotask.controller;

import br.com.fiap.ecotask.model.Empresa;
import br.com.fiap.ecotask.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository repository;

    @PostMapping
    public Empresa criar(@RequestBody Empresa empresa) {
        return repository.save(empresa);
    }

    @GetMapping
    public List<Empresa> listar() {
        return repository.findAll();
    }
}