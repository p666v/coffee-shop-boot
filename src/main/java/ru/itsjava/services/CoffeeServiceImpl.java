package ru.itsjava.services;

import org.springframework.stereotype.Service;
import ru.itsjava.domain.Coffee;

@Service
public class CoffeeServiceImpl implements CoffeeService {
    private String type;

    @Override
    public Coffee getCoffeeByPrice(double price) {

        if (price == 170) {
            type = "Капучино";
        } else if (price == 180) {
            type = "Латте";
        } else if (price == 100) {
            type = "Эспрессо";
        } else {
            System.out.println("Коффе по указанной цене НЕТ!!!");
        }

        return new Coffee(type);
    }
}
