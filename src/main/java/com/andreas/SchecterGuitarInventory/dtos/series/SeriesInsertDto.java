package com.andreas.SchecterGuitarInventory.dtos.series;

import com.andreas.SchecterGuitarInventory.models.Series;
import lombok.Data;

import java.io.Serializable;

@Data
public class SeriesInsertDto implements Serializable {
    private final Integer id;
    private final String seriesName;

    public Series convert(){
        return new Series(seriesName);
    }
}
