package com.andreas.SchecterGuitarInventory.dtos.product;

import lombok.Data;

import java.io.Serializable;

@Data
public class StockOutDto implements Serializable {
    private final Integer id;
    private final Integer units;
}
