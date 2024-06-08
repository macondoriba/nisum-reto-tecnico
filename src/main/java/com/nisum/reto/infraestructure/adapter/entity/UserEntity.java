package com.nisum.reto.infraestructure.adapter.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;


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
    private UUID id;
    private String name;
    private String email;
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private Set<PhoneEntity> phones = new HashSet<>();
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private String token;
    private Boolean isActive;

    @PrePersist
    public void onCreate() {
        this.created = this.lastLogin = this.modified = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.lastLogin = this.modified = LocalDateTime.now();
    }

}