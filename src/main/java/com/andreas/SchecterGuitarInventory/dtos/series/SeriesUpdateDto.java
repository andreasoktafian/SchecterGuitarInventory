package com.andreas.SchecterGuitarInventory.dtos.series;

import lombok.Data;

import java.io.Serializable;

@Data
public class SeriesUpdateDto implements Serializable {

    private final Integer id;
    private final String seriesName;
}
