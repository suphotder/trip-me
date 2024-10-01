package com.example.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.server.entity.TagEntity;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, String> {

}
