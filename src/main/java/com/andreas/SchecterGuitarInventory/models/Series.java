package com.andreas.SchecterGuitarInventory.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SeriesID", nullable = false)
    private Integer id;

    @Column(name = "SeriesName", nullable = false, length = 50)
    private String seriesName;

    public Series(String seriesName) {
        this.seriesName = seriesName;
    }

    public Series(Integer id) {
        this.id = id;
    }
}