package com.nisum.reto.infraestructure.adapter.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "regular_expresions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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