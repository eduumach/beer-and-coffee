package com.thaynarasilvapinto.beerandcoffee.service;

import com.thaynarasilvapinto.beerandcoffee.dto.BeerDto;
import com.thaynarasilvapinto.beerandcoffee.entity.Beer;
import com.thaynarasilvapinto.beerandcoffee.respository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BeerService {

    private final BeerRepository repository;

    @Autowired
    public BeerService(BeerRepository repository) {
        this.repository = repository;
    }

    public BeerDto create(BeerDto beerDto){
        Beer beer = beerDto.build();
        beer.setCreatedAt(LocalDateTime.now());
        beer = repository.save(beer);
        return beer.build();
    }

    public BeerDto update(BeerDto beerDto){
        repository.findById(beerDto.getId()).orElseThrow();

        Beer beer = beerDto.build();
        beer.setUpdatedAt(LocalDateTime.now());

        beer = repository.saveAndFlush(beer);
        return beer.build();
    }

}
