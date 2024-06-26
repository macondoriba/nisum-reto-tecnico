package com.nisum.reto.infraestructure.adapter.out.persistence.entity;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name="users")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
    private String email;
    private String password;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private Set<PhoneEntity> phones;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private String token;
    private Boolean isActive;

    @PrePersist
    public void onCreate() {
        this.setPassword(
                new BCryptPasswordEncoder()
                        .encode(this.getPassword()));
        this.created = this.lastLogin = this.modified = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.setPassword(
                new BCryptPasswordEncoder()
                        .encode(this.getPassword()));
        this.lastLogin = this.modified = LocalDateTime.now();
    }

}