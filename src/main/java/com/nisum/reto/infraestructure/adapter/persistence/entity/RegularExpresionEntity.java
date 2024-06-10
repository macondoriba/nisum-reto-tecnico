package com.nisum.reto.infraestructure.adapter.persistence.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "regular_expresions")
public class RegularExpresionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String expression;
    private LocalDateTime created;
    private LocalDateTime modified;
    @PrePersist
    public void onCreate() {

        this.created = this.modified = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {

        this.modified = LocalDateTime.now();
    }

}