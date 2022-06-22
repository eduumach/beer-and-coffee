package com.thaynarasilvapinto.beerandcoffee.entity;


import com.sun.istack.NotNull;
import com.thaynarasilvapinto.beerandcoffee.dto.BeerDto;
import com.thaynarasilvapinto.beerandcoffee.utils.TypeMeasures;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "beer")
@Entity
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    private String brand;

    @Column
    private Integer amount;

    @Column
    private Double capacity;

    @Column(name = "type_measures")
    @Enumerated(EnumType.STRING)
    private TypeMeasures typeMeasures;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Beer() {
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

    public BeerDto build() {
        BeerDto beerDto = new BeerDto();
        beerDto.setId(this.id);
        beerDto.setName(this.name);
        beerDto.setBrand(this.brand);
        beerDto.setAmount(this.amount);
        beerDto.setCapacity(this.capacity);
        beerDto.setTypeMeasures(this.typeMeasures);
        beerDto.setCreatedAt(this.createdAt);
        beerDto.setUpdatedAt(this.updatedAt);
        return beerDto;
    }
}
