package com.example.server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "trip_tag")
public class TripTagEntity extends AuditingEntity {
    @ManyToOne
    @JoinColumn(name = "trip_id")
    private TripEntity tripId;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private TagEntity tagId;
}
