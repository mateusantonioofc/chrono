package com.github.mateusantonioofc.chrono.controller;

import com.github.mateusantonioofc.chrono.model.EmprestimosEntity;
import com.github.mateusantonioofc.chrono.repository.EmprestimosRepository;
import com.github.mateusantonioofc.chrono.service.EmprestimosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimosController {

    private final EmprestimosRepository emprestimosRepository;

    public EmprestimosController(EmprestimosRepository emprestimosRepository) {
        this.emprestimosRepository = emprestimosRepository;
    }

    @GetMapping
    public List<EmprestimosEntity> getAllEmprestimos() {
        return emprestimosRepository.findAll();
    }
}
