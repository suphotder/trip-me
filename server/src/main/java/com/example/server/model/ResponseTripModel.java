package com.example.server.model;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResponseTripModel extends TripModel {
    private List<String> photos;
    private List<String> tags;
}
