package com.thaynarasilvapinto.beerandcoffee.unit_test.service;

import com.thaynarasilvapinto.beerandcoffee.service.CoffeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration
public class CoffeeServiceTest {

    @InjectMocks
    private CoffeeService coffeeService;


    @Test
    void success_findCoffeeById(){
        /**
            Passo 1 - criar um cenario de tete
            Passo 2 - fazer efetivamente a chamada do metodo que deseja testar
            Passo 3 - fazer as verificações do teste
         */
    }
}
