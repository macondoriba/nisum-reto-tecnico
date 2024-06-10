package com.nisum.reto.infraestructure.adapter.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JoinColumn(name = "id_user")
    private UserEntity user;
    private String  number;
    private String cityCode;
    private String countryCode;
}
