package com.thaynarasilvapinto.beerandcoffee.dto;

import com.thaynarasilvapinto.beerandcoffee.entity.Beer;
import com.thaynarasilvapinto.beerandcoffee.entity.Coffee;
import com.thaynarasilvapinto.beerandcoffee.utils.TypeMeasures;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CoffeeDto {

    private Long id;

    private String name;

    private String brand;

    private Integer amount;

    private Double capacity;

    private TypeMeasures typeMeasures;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public CoffeeDto() {
    }

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

    public Coffee build() {
        Coffee coffee = new Coffee();
        coffee.setId(this.id);
        coffee.setName(this.name);
        coffee.setBrand(this.brand);
        coffee.setAmount(this.amount);
        coffee.setCapacity(this.capacity);
        coffee.setTypeMeasures(this.typeMeasures);
        coffee.setCreatedAt(this.createdAt);
        coffee.setUpdatedAt(this.updatedAt);
        return coffee ;
    }

    public CoffeeDto(Coffee coffee) {
        this.id = coffee.getId();
        this.name = coffee.getName();
        this.brand = coffee.getBrand();
        this.amount = coffee.getAmount();
        this.capacity = coffee.getCapacity();
        this.typeMeasures = coffee.getTypeMeasures();
        this.createdAt = coffee.getCreatedAt();
        this.updatedAt = coffee.getUpdatedAt();
    }

    public static List<CoffeeDto> convert(List<Coffee> coffee){
        return coffee.stream().map(CoffeeDto::new).collect(Collectors.toList());
    }
}
