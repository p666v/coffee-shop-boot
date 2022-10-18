package ru.itsjava.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsjava.domain.Coffee;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CoffeeServiceImplTest {
    @Autowired
    private CoffeeServiceImpl coffeeService;

    @DisplayName("должен корректно давать кофе")
    @Test
    public void shouldCorrectHaveGetCoffeeByPrice() {
        Coffee coffee1 = coffeeService.getCoffeeByPrice("100");
        assertEquals(coffee1.getType(), "Эспрессо");

        Coffee coffee2 = coffeeService.getCoffeeByPrice("170");
        assertEquals(coffee2.getType(), "Капучино");

        Coffee coffee3 = coffeeService.getCoffeeByPrice("180");
        assertEquals(coffee3.getType(), "Латте");

    }

    @Configuration
    static class MyConfiguration {

        @Bean
        public CoffeeService coffeeService() {
            return new CoffeeServiceImpl();
        }
    }

}
