package ru.itsjava.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("coffeeHouse")
@RequiredArgsConstructor
public class CoffeeHouseImpl implements CoffeeHouse {
    private final CoffeeService coffeeService;
    private final IOService ioService;

    public static void printMenu() {
        System.out.println("Прайс:\n" +
                "Капучино 170 рублей\n" +
                "Латте 180 рублей\n" +
                "Эспрессо 100 рублей\n" +
                "______________________________");
    }

    @Override
    public void buyCoffeeFromShop() {
        System.out.println("Добро пожаловать в нашу кофейню!");
        printMenu();
        System.out.println("Оплатите выбранный кофе");
        String price = ioService.input();

        while (true) {
            if (price.equals("100") || price.equals("170") || price.equals("180")) {
                System.out.println("Ваш кофе " + coffeeService.getCoffeeByPrice(price) + " готов!");
                System.out.println("Спасибо за покупку! Всегда рады Вам в нашей кофейне!");
                break;
            } else {
                System.out.println("Кофе по указанной цене НЕТ!!!");
                System.out.println("Попробуйте заново");
                System.out.println("============================");
                printMenu();
                System.out.println("Оплатите выбранный кофе");
                price = ioService.input();
            }
        }
    }
}
