package com.nisum.reto.infraestructure.adapter.persistence.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="phones")
@Getter
@Setter
public class PhoneEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    private String  number;
    private String cityCode;
    private String countryCode;
}