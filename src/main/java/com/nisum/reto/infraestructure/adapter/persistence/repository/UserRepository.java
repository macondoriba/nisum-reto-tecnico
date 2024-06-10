package com.nisum.reto.infraestructure.adapter.persistence.repository;

import com.nisum.reto.infraestructure.adapter.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

}
