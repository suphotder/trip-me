package com.example.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.server.entity.TripTagEntity;

@Repository
public interface TripTagRepository extends JpaRepository<TripTagEntity, String> {

}