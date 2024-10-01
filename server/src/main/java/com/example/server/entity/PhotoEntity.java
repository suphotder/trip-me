package com.example.server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "photos")
public class PhotoEntity extends AuditingEntity {
    @ManyToOne
    @JoinColumn(name = "trip_id")
    private TripEntity tripId;

    @Column(name = "url")
    private String url;

    @Column(name = "priority")
    private int priority;
}
