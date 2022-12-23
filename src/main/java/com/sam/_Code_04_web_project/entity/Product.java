package com.sam._Code_04_web_project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String serialNo;
    private String licenceCode;
    private int rating;
    private String manufacturer;
    private String importedFromCountry;
    private int quantity;
    private int margin;
    private double price;

    public Product(String name, String serialNo, String licenceCode,
                   int rating, String manufacturer, String importedFromCountry,
                   int quantity, int margin, double price) {
        this.name = name;
        this.serialNo = serialNo;
        this.licenceCode = licenceCode;
        this.rating = rating;
        this.manufacturer = manufacturer;
        this.importedFromCountry = importedFromCountry;
        this.quantity = quantity;
        this.margin = margin;
        this.price = price;
    }
}
