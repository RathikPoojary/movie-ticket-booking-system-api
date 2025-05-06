package com.example.movieticketbookingsystem.entity;

import com.example.movieticketbookingsystem.enums.ScreenType;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@ToString
@Table(name = "screen")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "screen_id",updatable = false,nullable = false)
    private String screenId;

    @Column(name = "screen_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private ScreenType screenType;

    @Column(name = "capacity",nullable = false)
    private Integer capacity;

    @Column(name = "noOfRows",nullable = false)
    private Integer noOfRows;

    @Column(name = "created_at",updatable = false,nullable = false)
    @CreatedDate
    private Instant createdAt;

    @Column(name = "updated_at",nullable = false)
    @LastModifiedDate
    private Instant updatedAt;

    @Column(name = "created_by",updatable = false)
    private String createdBy;

    @JoinColumn(name = "theater_id",nullable = false)
    @ManyToOne
    private Theater theater;

    @OneToMany(mappedBy = "screen" , cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @OrderBy(value = "name")
    @JsonIgnore
    private List<Seat> seats;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Show> shows;

}
