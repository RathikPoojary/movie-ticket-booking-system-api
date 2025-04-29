package com.example.movieticketbookingsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@ToString
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "seat_id",nullable = false)
    private String seatId;

    @Column(name = "created_at",updatable = false,nullable = false)
    @CreatedDate
    private Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;
}
