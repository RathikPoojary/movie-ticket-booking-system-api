package com.example.movieticketbookingsystem.mapper;

import com.example.movieticketbookingsystem.dto.ScreenResponse;
import com.example.movieticketbookingsystem.dto.SeatResponse;
import com.example.movieticketbookingsystem.entity.Screen;
import com.example.movieticketbookingsystem.entity.Seat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScreenMapper {
    public ScreenResponse screenResponseMapper(Screen screen){
        if (screen == null)
            return null;
        return new ScreenResponse(
                screen.getScreenID(),
                screen.getScreenType(),
                screen.getCapacity(),
                screen.getNoOfRows()
        );
    }

    public SeatResponse seatResponse(List<Seat> seats){
        List<String> seatId = new ArrayList<>();
        List<String> seatName = new ArrayList<>();

        for (Seat seat : seats){
            seatId.add(seat.getSeatId());
            seatName.add(seat.getName());
        }
        return SeatResponse.builder()
                .seatId(seatId)
                .name(seatName)
                .build();
    }




}
