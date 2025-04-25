package com.example.movieticketbookingsystem.service.impl;

import com.example.movieticketbookingsystem.dto.TheaterRequest;
import com.example.movieticketbookingsystem.dto.TheaterResponse;
import com.example.movieticketbookingsystem.entity.Theater;
import com.example.movieticketbookingsystem.entity.TheaterOwner;
import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.enums.UserRole;
import com.example.movieticketbookingsystem.exception.TheaterNotFoundByIdException;
import com.example.movieticketbookingsystem.exception.UserNotFoundByEmailException;
import com.example.movieticketbookingsystem.mapper.TheaterMapper;
import com.example.movieticketbookingsystem.repository.TheaterRepository;
import com.example.movieticketbookingsystem.repository.UserRepository;
import com.example.movieticketbookingsystem.service.TheaterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;
    private final TheaterMapper theaterMapper;
    private final UserRepository userRepository;


    @Override
    public TheaterResponse addTheater(String email, TheaterRequest theaterRequest) {
        if (userRepository.existsByEmail(email) && userRepository.findByEmail(email).getUserRole() == UserRole.THEATER_OWNER) {
            UserDetails user = userRepository.findByEmail(email);
            Theater theater = copy(theaterRequest, new Theater(), user);
            return theaterMapper.theaterResponseMapper(theater);
        }
        throw new UserNotFoundByEmailException("No theater owner with the provided email");
    }

    @Override
    public TheaterResponse findTheater(String theaterId) {
        if(theaterRepository.existsById(theaterId)){
            Theater theater = theaterRepository.findById(theaterId).get();
            return theaterMapper.theaterResponseMapper(theater);
        }
        throw new TheaterNotFoundByIdException("Theater not found by the id");
    }

    @Override
    public TheaterResponse updateTheater(String theaterId, TheaterRequest theaterRequest) {
        if (theaterRepository.existsById(theaterId)){
            Theater theater = theaterRepository.findById(theaterId).get();
            theater = copy(theaterRequest, theater);
            return theaterMapper.theaterResponseMapper(theater);
        }
        throw new TheaterNotFoundByIdException("Theater not found by the id");

    }

    public Theater copy(TheaterRequest theaterRequest, Theater theater, UserDetails userDetails) {
        theater.setAddress(theaterRequest.address());
        theater.setCity(theaterRequest.city());
        theater.setName(theaterRequest.name());
        theater.setLandmark(theaterRequest.landmark());
        theater.setTheaterOwner((TheaterOwner) userDetails);
        theaterRepository.save(theater);
        return theater;
    }

    public Theater copy(TheaterRequest theaterRequest, Theater theater){
        theater.setAddress(theaterRequest.address());
        theater.setCity(theaterRequest.city());
        theater.setName(theaterRequest.name());
        theater.setLandmark(theaterRequest.landmark());
        theaterRepository.save(theater);
        return theater;
    }

}

