package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.dto.TheaterRequest;
import com.example.movieticketbookingsystem.dto.TheaterResponse;
import com.example.movieticketbookingsystem.service.TheaterService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import com.example.movieticketbookingsystem.utility.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/theaters")
    public ResponseEntity<ResponseStructure<TheaterResponse>> addTheater(String email, @Valid @RequestBody TheaterRequest theaterRegistrationRequest){
        TheaterResponse theaterResponse = theaterService.addTheater(email,theaterRegistrationRequest);
        return responseBuilder.success(HttpStatus.OK,"Theater has been added successfully",theaterResponse);
    }
    @GetMapping("/theaters/{theaterId}")
    public ResponseEntity<ResponseStructure<TheaterResponse>> findTheater(@PathVariable String theaterId){
        TheaterResponse theaterResponse = theaterService.findTheater(theaterId);
        return responseBuilder.success(HttpStatus.OK,"Theater has been successfully fetched", theaterResponse);
    }
    @PutMapping("/theaters/{theaterId}")
    public ResponseEntity<ResponseStructure<TheaterResponse>> updateTheater(@PathVariable String theaterId, @Valid @RequestBody TheaterRequest registrationRequest){
        TheaterResponse theaterResponse = theaterService.updateTheater(theaterId,registrationRequest);
        return responseBuilder.success(HttpStatus.OK,"Theater has been successfully updated",theaterResponse);
    }

}
