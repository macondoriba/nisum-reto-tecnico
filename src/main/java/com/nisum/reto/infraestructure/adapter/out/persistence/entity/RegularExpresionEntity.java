package com.nisum.reto.infraestructure.adapter.out.persistence.entity;


import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "regular_expresions")
public class RegularExpresionEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
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