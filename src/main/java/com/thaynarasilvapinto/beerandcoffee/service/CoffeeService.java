package com.thaynarasilvapinto.beerandcoffee.service;

import com.thaynarasilvapinto.beerandcoffee.dto.CoffeeDto;
import com.thaynarasilvapinto.beerandcoffee.entity.Coffee;
import com.thaynarasilvapinto.beerandcoffee.repository.CoffeeRepository;
import com.thaynarasilvapinto.beerandcoffee.utils.TypeMeasures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class CoffeeService {

    private final CoffeeRepository repository;

    @Autowired
    public CoffeeService(CoffeeRepository repository) {
        this.repository = repository;
    }

    public CoffeeDto create(CoffeeDto coffeeDto){
        Coffee coffee = coffeeDto.build();
        coffee.setCreatedAt(LocalDateTime.now());
        coffee = repository.save(coffee);
        return coffee.build();
    }

    public CoffeeDto update(CoffeeDto coffeeDto){
        repository.findById(coffeeDto.getId()).orElseThrow();
        Coffee coffee = repository.findById(coffeeDto.getId()).orElseThrow(() -> new RuntimeException("Id not found."));
        if(coffee.getTypeMeasures() == TypeMeasures.L){
            throw new RuntimeException("Type Measures L.");
        }

        Coffee responseCoffee = coffeeDto.build();
        responseCoffee.setUpdatedAt(LocalDateTime.now());

        responseCoffee = repository.saveAndFlush(responseCoffee);
        return responseCoffee.build();
    }

    public CoffeeDto getCoffee(Long id){
        Coffee coffee = repository.findById(id).orElseThrow(() -> new RuntimeException("Id not found."));
        return coffee.build();
    }

    public List<CoffeeDto> getAll(){
        return CoffeeDto.convert(repository.findAll());
    }

    public CoffeeDto delete(Long id){
        repository.findById(id).orElseThrow();
        repository.deleteById(id);
        return null;
    }
}
