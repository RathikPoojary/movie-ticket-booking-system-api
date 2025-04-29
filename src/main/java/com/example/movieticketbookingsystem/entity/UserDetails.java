package com.example.movieticketbookingsystem.entity;

import com.example.movieticketbookingsystem.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id",nullable = false)
    private String userId;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "email", unique = true,nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "user_role",nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column(name = "phone-number",updatable = true,length = 10,nullable = false)
    private String phoneNumber;

    @Column(name = "date_of_birth",nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "is_delete",nullable = false)
    private boolean isDelete;

    @Column(name = "deleted_at",nullable = false)
    private Instant deletedAt;

    @Column(name = "created_at",updatable = false,nullable = false)
    @CreatedDate
    private Instant createdAt;

    @Column(name = "updated_at",nullable = false)
    @LastModifiedDate
    private Instant updatedAt;

    @Column(name = "created_by",updatable = false)
    @CreatedBy
    private String createdBy;


}