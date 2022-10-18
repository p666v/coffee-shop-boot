package ru.itsjava.services;

import org.springframework.stereotype.Service;
import ru.itsjava.domain.Coffee;

@Service
public class CoffeeServiceImpl implements CoffeeService {
    private String type;

    @Override
    public Coffee getCoffeeByPrice(String price) {

        if (price.equals("170")) {
            type = "Капучино";
        } else if (price.equals("180")) {
            type = "Латте";
        } else if (price.equals("100")) {
            type = "Эспрессо";
        } else {
            System.out.println("Кофе по указанной цене НЕТ!!!");
        }

        return new Coffee(type);
    }
}
