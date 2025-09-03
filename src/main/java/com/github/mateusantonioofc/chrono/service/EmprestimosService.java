package com.github.mateusantonioofc.chrono.service;

import com.github.mateusantonioofc.chrono.model.EmprestimosEntity;
import com.github.mateusantonioofc.chrono.repository.EmprestimosRepository;

import java.util.List;

public class EmprestimosService {

    private final EmprestimosRepository emprestimosRepository;

    public EmprestimosService(EmprestimosRepository emprestimosRepository) {
        this.emprestimosRepository = emprestimosRepository;
    }

    public List<EmprestimosEntity> getAll() {
        return emprestimosRepository.findAll();
    }
}
