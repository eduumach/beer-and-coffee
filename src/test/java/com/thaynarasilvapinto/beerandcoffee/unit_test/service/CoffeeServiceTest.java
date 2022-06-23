package com.thaynarasilvapinto.beerandcoffee.unit_test.service;

import com.thaynarasilvapinto.beerandcoffee.dto.CoffeeDto;
import com.thaynarasilvapinto.beerandcoffee.entity.Coffee;
import com.thaynarasilvapinto.beerandcoffee.repository.CoffeeRepository;
import com.thaynarasilvapinto.beerandcoffee.service.CoffeeService;
import com.thaynarasilvapinto.beerandcoffee.utils.TypeMeasures;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@ContextConfiguration
public class CoffeeServiceTest {

    private final Long ID = 1L;

    @InjectMocks
    private CoffeeService coffeeService;

    @Mock
    private CoffeeRepository coffeeRepository;

    @Test
    void success_findCoffeeById(){
        /***
            Passo 1 - criar um cenario de tete
            Passo 2 - fazer efetivamente a chamada do metodo que deseja testar
            Passo 3 - fazer as verificações do teste
         ***/
    }


    @Test
    void success_assertJ(){

        when(coffeeRepository.findById(ID)).thenReturn(Optional.of(coffeeDto()));

        CoffeeDto response = coffeeService.getCoffee(ID);

        /**
         * tipos de assert
         */

        //AssertJ
        assertThat(response.getName()).isEqualTo("Café catuaí");
        assertThat(response.getBrand()).isEqualTo("três corações");
        assertThat(response.getCapacity()).isEqualTo(200.0);
        assertThat(response.getAmount()).isEqualTo(100);
        org.assertj.core.api.Assertions.assertThat(response.getTypeMeasures()).isEqualTo(TypeMeasures.ML);

        assertThat(response.getBrand().equals("três corações")).isTrue();

        assertThat(response.getName())
                .isNotNull()
                .startsWith("Café")
                .contains("catuaí");

        assertThat(response).matches(beer ->
                Objects.equals(beer.getName(), "Café catuaí") &&
                        Objects.equals(beer.getBrand(), "três corações") &&
                        beer.getAmount().equals(100));


        assertThat(response)
                .isNotNull()
                .extracting("name", "brand", "amount", "capacity", "typeMeasures").
                contains("Café catuaí", "três corações", 100, 200.0, TypeMeasures.ML);


        //Assert Junit
        assertEquals("Café catuaí", response.getName());
        assertEquals("três corações", response.getBrand());
        assertEquals(200.0, response.getCapacity());
        assertEquals(100, response.getAmount());
        Assertions.assertEquals(TypeMeasures.ML, response.getTypeMeasures());
    }

    private Coffee coffeeDto() {

        Coffee coffee = new Coffee();

        coffee.setName("Café catuaí");
        coffee.setBrand("três corações");
        coffee.setCapacity(200.0);
        coffee.setAmount(100);
        coffee.setTypeMeasures(TypeMeasures.ML);

        return coffee;
    }
}
