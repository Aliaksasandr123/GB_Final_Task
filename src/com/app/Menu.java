package com.app;

import com.app.dao.Database;
import com.app.model.*;
import com.app.utils.InputReader;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    private static Menu menuInstance;
    private final Database database;
    private final Scanner scanner;

    private Menu() {
        this.database = Database.getDatabaseInstance();
        scanner = new Scanner(System.in);
    }

    public static Menu getMenuInstance() {
        if (Objects.isNull(menuInstance)) {
            menuInstance = new Menu();
        }
        return menuInstance;
    }

    public void run() {
        displayMenu();
    }

    private void displayMenu() {
        while (true) {
            try {
                System.out.println("""
                        Меню:\s
                        \t1. Добавить новое животное\s
                        \t2. Просмотреть список команд животного\s
                        \t3. Обучить животное новой команде\s
                        \t4. Показать список всех животных\s
                        \t5. Показать список домашних животных\s
                        \t6. Показать список вьючных животных\s
                        \t7. Показать список животных по дате рождения\s
                        \t8. Показать общее количество животных\s
                        \t0. Выход""");
                switch (InputReader.getIntegerInput(scanner, "Выберите пункт меню: ")) {
                    case 1 -> addNewAnimal();
                    case 2 -> displayAnimalCommands();
                    case 3 -> teachNewCommand();
                    case 4 -> displayAllAnimals();
                    case 5 -> displayPetAnimals();
                    case 6 -> displayPackAnimals();
                    case 7 -> displaySortedAnimals();
                    case 8 -> displayNumberOfAnimals();
                    case 0 -> {
                        System.out.println("Программа завершена.");
                        return;
                    }
                    default -> System.out.println("Неверный выбор. Попробуйте снова.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: неверный формат ввода. Попробуйте снова.");
                scanner.nextLine(); // Очистка буфера сканера после ошибочного ввода
            }
        }
    }

    private void addNewAnimal() {
        String name = InputReader.getStringInput(scanner, "Введите имя животного:");
        LocalDate birthDate = InputReader.getLocalDateInput(scanner, "Введите дату рождения животного в формате \"YYYY-MM-DD\"");
        String skills = InputReader.getStringInput(scanner, "Введите список команд через запятую:");
        int animalClass = InputReader.getIntegerInput(scanner, """
                Выберите класс животного:\s
                \t1. Собака
                \t2. Кошка
                \t3. Хомяк
                \t4. Лошадь
                \t5. Верблюд
                \t6. Осёл""");
        Animal animal;
        switch (animalClass) {
            case 1 -> animal = new Dog(name, birthDate, skills);
            case 2 -> animal = new Cat(name, birthDate, skills);
            case 3 -> animal = new Hamster(name, birthDate, skills);
            case 4 -> animal = new Horse(name, birthDate, skills);
            case 5 -> animal = new Camel(name, birthDate, skills);
            case 6 -> animal = new Donkey(name, birthDate, skills);
            default -> {
                System.out.println("Неверный выбор класса животного.");
                return;
            }
        }
        database.addAnimal(animal);
        System.out.println("Животное успешно добавлено в базу данных.");
    }

    private void displayAnimalCommands() {
        String name = InputReader.getStringInput(scanner, "Введите имя животного:");
        database.displayAnimalCommands(name);
    }

    private void teachNewCommand() {
        String name = InputReader.getStringInput(scanner, "Введите имя животного:");
        String command = InputReader.getStringInput(scanner, "Введите новые команды через запятую:");
        database.teachNewCommand(name, command);
    }

    private void displayAllAnimals() {
        database.displayAllAnimals();
    }

    private void displayPetAnimals() {
        database.displayPetAnimals();
    }

    private void displayPackAnimals() {
        database.displayPackAnimals();
    }

    private void displaySortedAnimals() {
        database.displaySortedAnimals();
    }

    private void displayNumberOfAnimals() {
        database.displayNumberOfAnimals();
    }
}