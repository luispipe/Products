package com.example.modelos.Models;

import java.time.LocalDate;
import java.util.Date;

public class Product {
    //Atributos
    String identifier, name, brand, provider;
    double price;
    Date expiritProduct;

    //Metodos
    //Constructor


    public Product(String identifier, String name, String brand, String provider, double price, Date expiritProduct) {
        this.identifier = identifier;
        this.name = name;
        this.brand = brand;
        this.provider = provider;
        this.price = price;
        this.expiritProduct = expiritProduct;
    }

    //Comportamientos de consulta y modificación o actualización


    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpiritProduct() {
        return expiritProduct;
    }

    public void setExpiritProduct(Date expiritProduct) {
        this.expiritProduct = expiritProduct;
    }

    //Comportamientos propios de la clase
    public boolean expiredProduct(){
        LocalDate now= LocalDate.now();
        return false;
    }


}
