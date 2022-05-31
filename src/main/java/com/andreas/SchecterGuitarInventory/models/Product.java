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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID", nullable = false)
    private Integer id;

    @Column(name = "ProductName", nullable = false, length = 50)
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CategoryID", nullable = false)
    private Category categoryID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SeriesID", nullable = false)
    private Series seriesID;

    @Column(name = "String", nullable = false, length = 10)
    private String string;

    @Column(name = "Color", nullable = false, length = 50)
    private String color;

    @Column(name = "BodyWood", nullable = false, length = 50)
    private String bodyWood;

    @Column(name = "NeckPickUp", length = 50)
    private String neckPickUp;

    @Column(name = "BridgePickUp", nullable = false, length = 50)
    private String bridgePickUp;

    @Column(name = "Bridge", nullable = false, length = 50)
    private String bridge;

    @Column(name = "Stock", nullable = false)
    private Integer stock;

    public String fullProductName(){
        return String.format("%s %s %s - %s", this.getProductName(), this.getSeriesID().getSeriesName(), this.getBridge(), this.getColor());
    }

    public Product(String productName, Integer categoryID, Integer seriesID, String string, String color, String bodyWood, String neckPickUp, String bridgePickUp, String bridge, Integer stock) {
        this.productName = productName;
        this.categoryID = new Category(categoryID);
        this.seriesID = new Series(seriesID);
        this.string = string;
        this.color = color;
        this.bodyWood = bodyWood;
        this.neckPickUp = neckPickUp;
        this.bridgePickUp = bridgePickUp;
        this.bridge = bridge;
        this.stock = stock;
    }

    public Product(Integer id) {
        this.id = id;
    }

}