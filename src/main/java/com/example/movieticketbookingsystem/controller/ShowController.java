package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.dto.ShowResponse;
import com.example.movieticketbookingsystem.service.ShowService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import com.example.movieticketbookingsystem.utility.RestResponseBuilder;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Validated
public class ShowController {

    private final ShowService showService;
    private final RestResponseBuilder responseBuilder;


    public ResponseEntity<ResponseStructure<ShowResponse>> addShow(@PathVariable String theaterId, @PathVariable String screenId, String movieId,@NotNull Long startTime) {
        ShowResponse showResponse = showService.addShow(theaterId,screenId,movieId,startTime);
        return responseBuilder.success(HttpStatus.OK,"Show added successfully", showResponse);
    }

}
