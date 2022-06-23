package com.thaynarasilvapinto.beerandcoffee.service;

import com.thaynarasilvapinto.beerandcoffee.dto.BeerDto;
import com.thaynarasilvapinto.beerandcoffee.entity.Beer;
import com.thaynarasilvapinto.beerandcoffee.repository.BeerRepository;
import com.thaynarasilvapinto.beerandcoffee.utils.TypeMeasures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        Beer beer = repository.findById(beerDto.getId()).orElseThrow(() -> new RuntimeException("Id not found."));
        if(beer.getTypeMeasures() == TypeMeasures.L){
            throw new RuntimeException("Type Measures L.");
        }

        Beer responseBeer = beerDto.build();
        responseBeer.setUpdatedAt(LocalDateTime.now());

        responseBeer = repository.saveAndFlush(responseBeer);
        return responseBeer.build();
    }

    public BeerDto getBeer(Long id){
        repository.findById(id).orElseThrow();
        Beer beer = repository.findById(id).orElseThrow(() -> new RuntimeException("Id not found."));
        return beer.build();
    }

    public List<BeerDto> getAll(){
        return BeerDto.convert(repository.findAll());
    }

    public BeerDto delete(Long id){
        repository.findById(id).orElseThrow();
        repository.deleteById(id);
        return null;
    }

}
