package com.nisum.reto.infraestructure.adapter.persistence.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", name = "user_id")
    private UUID id;
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user", cascade = { CascadeType.ALL })
    private Set<PhoneEntity> phones = new HashSet<>();
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