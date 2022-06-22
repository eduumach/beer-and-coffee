package com.thaynarasilvapinto.beerandcoffee.controller;

import com.thaynarasilvapinto.beerandcoffee.dto.CoffeeDto;
import com.thaynarasilvapinto.beerandcoffee.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @PostMapping()
    public ResponseEntity<CoffeeDto> create(@RequestBody CoffeeDto coffeeDto){
        return new ResponseEntity<>(coffeeService.create(coffeeDto), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<CoffeeDto> update(@RequestBody CoffeeDto coffeeDto){
        return new ResponseEntity<>(coffeeService.update(coffeeDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoffeeDto> getId(@PathVariable Long id){
        return new ResponseEntity<>(coffeeService.getCoffee(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CoffeeDto>> getAll(){
        return new ResponseEntity<>(coffeeService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CoffeeDto> deleteId(@PathVariable Long id){
        return new ResponseEntity<>(coffeeService.delete(id), HttpStatus.OK);
    }
}
