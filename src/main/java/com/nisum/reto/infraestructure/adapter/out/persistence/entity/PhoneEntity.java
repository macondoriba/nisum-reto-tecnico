package com.nisum.reto.infraestructure.adapter.out.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


@Data
@Entity
@Table(name="phones")
public class PhoneEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" ,referencedColumnName = "id")
    private UserEntity user;
    private String  number;
    private String cityCode;
    private String countryCode;
}