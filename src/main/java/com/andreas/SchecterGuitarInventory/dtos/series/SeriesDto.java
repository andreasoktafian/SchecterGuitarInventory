package com.andreas.SchecterGuitarInventory.dtos.series;

import com.andreas.SchecterGuitarInventory.exception.CustomException;
import com.andreas.SchecterGuitarInventory.models.Series;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

@Data
public class SeriesDto implements Serializable {
    private final Integer id;
    private final String series;

    public static SeriesDto setData(Series series){
        return new SeriesDto(
                series.getId(),
                series.getSeriesName()
        );
    }

    public static List<SeriesDto> toList(List<Series> series){

        if(series.size() == 0){
            throw new CustomException(HttpStatus.NOT_FOUND,"Tidak Ada Data Yang Sesuai.");
        }

        Stream<SeriesDto> result = series.stream().map(SeriesDto::setData);
        return result.toList();
    }
}
