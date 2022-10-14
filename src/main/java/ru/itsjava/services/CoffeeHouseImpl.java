package ru.itsjava.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service("coffeeHouse")
@RequiredArgsConstructor
public class CoffeeHouseImpl implements CoffeeHouse {
    private final CoffeeService coffeeService;

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
        Scanner console = new Scanner(System.in);
        double price = console.nextDouble();

        while (true) {
            if (price == 170 || price == 180 || price == 100) {
                System.out.println("Ваш кофе " + coffeeService.getCoffeeByPrice(price) + " готов!");
                System.out.println("Спасибо за покупку! Всегда рады Вам в нашей кофейне!");
                break;
            } else {
                System.out.println("Коффе по указанной цене НЕТ!!!");
                System.out.println("Попробуйту заново");
                System.out.println("=========================");
                printMenu();
                System.out.println("Оплатите выбранный кофе");
                price = console.nextDouble();
            }
        }


    }
}
