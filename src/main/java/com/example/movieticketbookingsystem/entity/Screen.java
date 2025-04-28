package com.example.movieticketbookingsystem.entity;

import com.example.movieticketbookingsystem.enums.ScreenType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@ToString
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String screenID;
    @Enumerated(EnumType.STRING)
    private ScreenType screenType;
    private Integer capacity;
    private Integer noOfRows;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    private String createdBy;

    @ManyToOne
    private Theater theater;

    @OneToMany(mappedBy = "screen" , cascade = CascadeType.PERSIST)
    private List<Seat> seats;

}
