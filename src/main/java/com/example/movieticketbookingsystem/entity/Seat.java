package com.example.movieticketbookingsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@ToString
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String seatId;

    private String name;

    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Screen screen;


}
