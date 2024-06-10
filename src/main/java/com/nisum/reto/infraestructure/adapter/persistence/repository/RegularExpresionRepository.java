package com.nisum.reto.infraestructure.adapter.persistence.repository;

import com.nisum.reto.infraestructure.adapter.persistence.entity.RegularExpresionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegularExpresionRepository extends JpaRepository<RegularExpresionEntity, UUID> {
}
