package com.example.server.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.model.ResponseTripModel;
import com.example.server.service.TripService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("trips")
public class TripController {

    private final TripService tripService;

    @GetMapping()
    public ResponseEntity<List<ResponseTripModel>> getTrip(
            @RequestParam(value = "keyword", required = false) String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            keyword = "";
        }
        List<ResponseTripModel> responseTripModel = tripService.getTripService(keyword);
        return ResponseEntity.ok(responseTripModel);
    }
}