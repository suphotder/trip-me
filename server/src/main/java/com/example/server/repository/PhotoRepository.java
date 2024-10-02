package com.example.server.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.server.entity.PhotoEntity;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoEntity, String> {
    @Query(value = "SELECT p.url FROM photos p WHERE p.trip_id = :tripId", nativeQuery = true)
    List<String> findTripsByTripId(@Param("tripId") String tripId);
}