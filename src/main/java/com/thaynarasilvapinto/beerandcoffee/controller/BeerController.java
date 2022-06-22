package com.thaynarasilvapinto.beerandcoffee.controller;

import com.thaynarasilvapinto.beerandcoffee.dto.BeerDto;
import com.thaynarasilvapinto.beerandcoffee.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beer")
public class BeerController {

    private final BeerService beerService;

    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @PostMapping()
    public ResponseEntity<BeerDto> create(@RequestBody BeerDto beerDto){
        return new ResponseEntity<>(beerService.create(beerDto), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<BeerDto> update(@RequestBody BeerDto beerDto){
        return new ResponseEntity<>(beerService.update(beerDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeerDto> getId(@PathVariable Long id){
        return new ResponseEntity<>(beerService.getBeer(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<BeerDto>> getAll(){
        return new ResponseEntity<>(beerService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BeerDto> deleteId(@PathVariable Long id){
        return new ResponseEntity<>(beerService.delete(id), HttpStatus.OK);
    }

    //GET BY ID
    //GET ALL
    //DELETE
    /*
    QUALQUER REGRA DE NEGOCIO
    EXEMPLO: SÓ ATUALIZA SE O FOR ML

    CAFÉ
     */
}
