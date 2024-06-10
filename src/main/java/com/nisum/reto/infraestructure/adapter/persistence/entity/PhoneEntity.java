package com.nisum.reto.infraestructure.adapter.persistence.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="phones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    private String  number;
    private String cityCode;
    private String countryCode;
}