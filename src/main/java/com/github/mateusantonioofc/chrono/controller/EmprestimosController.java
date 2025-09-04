package com.github.mateusantonioofc.chrono.controller;

import com.github.mateusantonioofc.chrono.model.EmprestimosEntity;
import com.github.mateusantonioofc.chrono.repository.EmprestimosRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public EmprestimosEntity createEmprestimo(@RequestBody EmprestimosEntity entity) {
        return emprestimosRepository.save(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmprestimo(@PathVariable Long id) {
        if(emprestimosRepository.existsById(id)) {
            emprestimosRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmprestimo(@PathVariable Long id, @RequestBody EmprestimosEntity dados) {
        return emprestimosRepository.findById(id)
                .map(emprestimo -> {
                    emprestimo.setNome(dados.getNome());
                    emprestimo.setData(dados.getData());
                    emprestimo.setValor(dados.getValor());
                    emprestimo.setDescricao(dados.getDescricao());
                    emprestimosRepository.save(emprestimo);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
