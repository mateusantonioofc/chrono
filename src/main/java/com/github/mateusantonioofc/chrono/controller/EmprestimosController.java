package com.github.mateusantonioofc.chrono.controller;

import com.github.mateusantonioofc.chrono.model.EmprestimosEntity;
import com.github.mateusantonioofc.chrono.repository.EmprestimosRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmprestimoById(@PathVariable Long id) {
        if(emprestimosRepository.existsById(id)) {
            Optional<EmprestimosEntity> referenceById = emprestimosRepository.findById(id);
            return ResponseEntity.ok(referenceById);
        } else {
            return ResponseEntity.notFound().build();
        }
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
                    emprestimo.setDataPagamento(dados.getDataPagamento());
                    emprestimosRepository.save(emprestimo);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
