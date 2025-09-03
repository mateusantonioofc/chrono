package com.github.mateusantonioofc.chrono.repository;

import com.github.mateusantonioofc.chrono.model.EmprestimosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimosRepository extends JpaRepository<EmprestimosEntity, Long> {
}
