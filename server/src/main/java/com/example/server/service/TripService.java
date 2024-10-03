package com.example.server.service;

import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.server.entity.TripEntity;
import com.example.server.exception.CustomException;
import com.example.server.logs.Log4jEntiry;
import com.example.server.model.ResponseTripModel;
import com.example.server.repository.PhotoRepository;
import com.example.server.repository.TripRepository;
import com.example.server.repository.TripTagRepository;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Service
public class TripService {

    private final TripRepository tripRepository;
    private final TripTagRepository tripTagRepository;
    private final PhotoRepository photoRepository;
    private final ModelMapper modelMapper;
    private final Log4jEntiry log4jEntiry;

    public List<ResponseTripModel> getTripService(String keyword) {
        try {
            // List<String> tripIds = tripTagRepository.findTripIdsByName(keyword);
            String keywordLike = "%" + keyword + "%";
            List<TripEntity> tripEntitys = tripRepository.findTripsByKeyWord(keyword, keywordLike);
            return tripEntitys.stream()
                    .map(entity -> {
                        ResponseTripModel responseTripModel = modelMapper.map(entity,
                                ResponseTripModel.class);
                        List<String> tags = tripTagRepository.findTagNameByTripId(entity.getId());
                        List<String> photos = photoRepository.findTripsByTripId(entity.getId());
                        responseTripModel.setTags(tags);
                        responseTripModel.setPhotos(photos);
                        return responseTripModel;
                    })
                    .collect(Collectors.toList());
        } catch (CustomException e) {
            throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage());
        }
    }
}
