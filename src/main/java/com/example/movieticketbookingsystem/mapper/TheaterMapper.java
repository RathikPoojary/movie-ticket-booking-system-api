package com.example.movieticketbookingsystem.mapper;

import com.example.movieticketbookingsystem.dto.TheaterResponse;
import com.example.movieticketbookingsystem.entity.Theater;
import org.springframework.stereotype.Component;

@Component
public class TheaterMapper {

    public TheaterResponse theaterResponseMapper(Theater theater) {
        if (theater == null)
            return null;

        return TheaterResponse.builder()
                .theaterId(theater.getTheaterId())
                .name(theater.getName())
                .address(theater.getAddress())
                .city(theater.getCity())
                .landmark(theater.getLandmark())
                .build();
    }

}
