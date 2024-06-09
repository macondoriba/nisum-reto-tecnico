package com.nisum.reto.infraestructure.adapter.repository;

import com.nisum.reto.infraestructure.adapter.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

}
