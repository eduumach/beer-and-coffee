package com.thaynarasilvapinto.beerandcoffee.unit_test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thaynarasilvapinto.beerandcoffee.controller.CoffeeController;
import com.thaynarasilvapinto.beerandcoffee.dto.CoffeeDto;
import com.thaynarasilvapinto.beerandcoffee.service.CoffeeService;
import com.thaynarasilvapinto.beerandcoffee.utils.TypeMeasures;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CoffeeController.class)
@AutoConfigureMockMvc(addFilters = false)
public class CoffeeControllerTest {

    @MockBean
    private  CoffeeService coffeeService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void success_mustSaveABeer() throws Exception {

        mockMvc.perform(post("/coffee")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(getCoffee())))
                .andExpect(status().isCreated());
    }

    private CoffeeDto getCoffee() {

        CoffeeDto beerDto = new CoffeeDto();

        beerDto.setName("Café catuaí");
        beerDto.setBrand("três corações");
        beerDto.setCapacity(0.200);
        beerDto.setAmount(100);
        beerDto.setTypeMeasures(TypeMeasures.ML);

        return beerDto;
    }
}
