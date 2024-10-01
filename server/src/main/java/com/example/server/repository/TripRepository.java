package com.example.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.server.entity.TripEntity;

@Repository
public interface TripRepository extends JpaRepository<TripEntity, String> {

}
