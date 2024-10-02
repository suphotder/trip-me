package com.example.server.service;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.server.exception.CustomException;
import com.example.server.logs.Log4jEntiry;
import com.example.server.repository.TripTagRepository;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Service
public class TagService {

    private final TripTagRepository tripTagRepository;
    private final Log4jEntiry log4jEntiry;

    public List<String> getTagPopularService() {
        try {
            List<String> popTags = tripTagRepository.findTagNamePopularity();
            return popTags;
        } catch (CustomException e) {
            throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage());
        }
    }
}
