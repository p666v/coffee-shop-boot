package ru.itsjava.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsjava.domain.Coffee;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CoffeeServiceImplTest {
    @Autowired
    private CoffeeServiceImpl coffeeService;

    @DisplayName("должен корректно давать кофе")
    @Test
    public void shouldCorrectHaveGetCoffeeByPrice() {
        Coffee coffee1 = coffeeService.getCoffeeByPrice("100");
        Coffee coffee2 = coffeeService.getCoffeeByPrice("170");
        Coffee coffee3 = coffeeService.getCoffeeByPrice("180");

        assertAll("Проверка выдачи кофе",
                () -> assertEquals("Эспрессо", coffee1.getType()),
                () -> assertEquals("Капучино", coffee2.getType()),
                () -> assertEquals("Латте", coffee3.getType())
        );
    }

    @Configuration
    static class MyConfiguration {

        @Bean
        public CoffeeService coffeeService() {
            return new CoffeeServiceImpl();
        }
    }

}
