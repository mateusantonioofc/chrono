package com.github.mateusantonioofc.chrono.model;

import jakarta.persistence.*;

@Entity
@Table(name = "emprestados")
public class EmprestimosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
