package com.github.mateusantonioofc.chrono.controller;

import com.github.mateusantonioofc.chrono.model.EmprestimosEntity;
import com.github.mateusantonioofc.chrono.service.EmprestimosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmprestimosController {

    private final EmprestimosService emprestimosService;

    public EmprestimosController(EmprestimosService emprestimosService) {
        this.emprestimosService = emprestimosService;
    }

    @GetMapping
    public List<EmprestimosEntity> getAllEmprestimos() {
        return emprestimosService.getAll();
    }
}
