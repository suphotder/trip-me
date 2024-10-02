package com.example.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.server.entity.TripTagEntity;

@Repository
public interface TripTagRepository extends JpaRepository<TripTagEntity, String> {

    @Query(value = """
            SELECT tt.trip_id FROM tags t
            RIGHT JOIN trip_tag tt
            ON t.id = tt.tag_id
            WHERE t.name LIKE :keyword
            """, nativeQuery = true)
    List<String> findTripIdsByName(@Param("keyword") String keyword);

    @Query(value = """
            SELECT t.name FROM tags t
            RIGHT JOIN trip_tag tt
            ON t.id = tt.tag_id
            WHERE tt.trip_id = :tripId
            """, nativeQuery = true)
    List<String> findTagNameByTripId(@Param("tripId") String tripId);

    @Query(value = """
            select t.name from tags t
            where id in (
                select tg.tag_id from trip_tag tg
                group by tag_id
                order by count(*) DESC
            );
            """, nativeQuery = true)
    List<String> findTagNamePopularity();
}