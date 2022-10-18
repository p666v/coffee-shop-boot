package ru.itsjava;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.itsjava.domain.Coffee;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeTest {
    public static final String DEFAULT_TYPE = "Капучино";

    @DisplayName("корректно создаваться конструктором")
    @Test
    public void shouldHaveCorrectConstructor() {
        Coffee actualCoffee = new Coffee(DEFAULT_TYPE);

        assertEquals(DEFAULT_TYPE, actualCoffee.getType());
    }
}
