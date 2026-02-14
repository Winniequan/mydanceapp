package com.mydanceapp.mydanceapp.user;
import jakarta.persistence.*;
import lombok.*;

import com.mydanceapp.mydanceapp.common.TimeStampedEntity;
@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends TimeStampedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password_hash", nullable = false, length = 60)
private String passwordHash;
    @Column(name = "role", nullable=false)
    @Enumerated(EnumType.STRING)
    private Role role;
    
}
