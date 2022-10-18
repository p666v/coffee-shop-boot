package ru.itsjava.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsjava.domain.Coffee;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CoffeeHouseImplTest {

    @Autowired
    private CoffeeHouse coffeeHouse;

    @DisplayName("корректный метод покупки кофе")
    @Test
    public void shouldHaveCorrectSayHiToNewProgrammer() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        coffeeHouse.buyCoffeeFromShop();

        assertEquals("Добро пожаловать в нашу кофейню!\r\n" +
                "Прайс:\n" +
                "Капучино 170 рублей\n" +
                "Латте 180 рублей\n" +
                "Эспрессо 100 рублей\n" +
                "______________________________\r\n" +
                "Оплатите выбранный кофе\r\n" +
                "Ваш кофе Эспрессо готов!\r\n" +
                "Спасибо за покупку! Всегда рады Вам в нашей кофейне!\r\n", out.toString());
    }

    @Configuration
    static class MyConfiguration {
        @Bean
        public CoffeeHouse coffeeHouse(CoffeeService coffeeService, IOService ioService) {
            return new CoffeeHouseImpl(coffeeService, ioService);
        }

        @Bean
        public IOService ioService() {
            IOServiceImpl mockIOService = Mockito.mock(IOServiceImpl.class);
            when(mockIOService.input()).thenReturn("100");
            return mockIOService;
        }

        @Bean
        public CoffeeService coffeeService() {
            CoffeeService mockNotebookService = Mockito.mock(CoffeeServiceImpl.class);
            when(mockNotebookService.getCoffeeByPrice("100")).thenReturn(new Coffee("Эспрессо"));
            return mockNotebookService;
        }
    }
}
