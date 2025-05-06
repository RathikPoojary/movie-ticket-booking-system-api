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
    public ScreenResponse screenResponseMapper(Screen screen)
    {
        if (screen == null)
            return null;
        return new ScreenResponse(
                screen.getScreenId(),
                screen.getScreenType(),
                screen.getCapacity(),
                screen.getNoOfRows(),
                seatResponse(screen.getSeats())
        );
    }

    public List<SeatResponse> seatResponse(List<Seat> seats){
        List<SeatResponse> seatList = new ArrayList<>();

        for (Seat seat : seats)
        {

            seatList.add(SeatResponse.builder()
                    .seatId(seat.getSeatId())
                    .name(seat.getName())
                    .build());

        }
        return seatList;
    }




}
