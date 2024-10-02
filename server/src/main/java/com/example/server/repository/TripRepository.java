package com.example.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.server.entity.TripEntity;

@Repository
public interface TripRepository extends JpaRepository<TripEntity, String> {

    @Query("SELECT trip FROM TripEntity trip WHERE trip.id IN :tripIds")
    List<TripEntity> findTripsById(@Param("tripIds") List<String> tripIds);
}
