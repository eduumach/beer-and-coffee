package com.thaynarasilvapinto.beerandcoffee.dto;

import com.thaynarasilvapinto.beerandcoffee.entity.Beer;
import com.thaynarasilvapinto.beerandcoffee.utils.TypeMeasures;

import java.time.LocalDateTime;

public class BeerDto {

    private Long id;

    private String name;

    private String brand;

    private Integer amount;

    private Double capacity;

    private TypeMeasures typeMeasures;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public TypeMeasures getTypeMeasures() {
        return typeMeasures;
    }

    public void setTypeMeasures(TypeMeasures typeMeasures) {
        this.typeMeasures = typeMeasures;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Beer build() {
        Beer beer = new Beer();
        beer.setId(this.id);
        beer.setName(this.name);
        beer.setBrand(this.brand);
        beer.setAmount(this.amount);
        beer.setCapacity(this.capacity);
        beer.setTypeMeasures(this.typeMeasures);
        beer.setCreatedAt(this.createdAt);
        beer.setUpdatedAt(this.updatedAt);
        return beer ;
    }
}
