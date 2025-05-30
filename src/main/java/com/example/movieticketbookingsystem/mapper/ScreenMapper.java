package com.example.movieticketbookingsystem.mapper;

import com.example.movieticketbookingsystem.dto.ScreenResponse;
import com.example.movieticketbookingsystem.dto.SeatResponse;
import com.example.movieticketbookingsystem.entity.Screen;
import com.example.movieticketbookingsystem.entity.Seat;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ScreenMapper {

    public ScreenResponse screenResponseMapper(Screen screen) {
        if (screen == null)
            return null;

        return ScreenResponse.builder()
                .screenId(screen.getScreenId())
                .screenType(screen.getScreenType())
                .capacity(screen.getCapacity())
                .noOfRow(screen.getNoOfRows())
                .seats(seatResponseMapper(screen.getSeats()))
                .build();
    }

    private List<SeatResponse> seatResponseMapper(List<Seat> seats) {
        List<SeatResponse> seatList = new LinkedList<>();
        for (Seat seat : seats) {

            seatList.add(SeatResponse.builder()
                    .seatId(seat.getSeatId())
                    .name(seat.getName())
                    .build());
        }
        return seatList;
    }
}