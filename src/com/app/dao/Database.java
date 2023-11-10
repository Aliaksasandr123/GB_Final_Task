package com.app.dao;

import com.app.model.*;
import com.app.utils.comparator.AnimalBirthDateComparator;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Database {
    private static Database databaseInstance;
    private final List<Animal> animals;
    private static final String FILE_PATH = "src/com/data/database.txt";

    private Database() {
        animals = new ArrayList<>();
        loadDatabase();
    }

    public static Database getDatabaseInstance() {
        if (Objects.isNull(databaseInstance)) {
            databaseInstance = new Database();
        }
        return databaseInstance;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        saveDatabase();
    }

    public void displayAnimalCommands(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                animal.displayCommands();
                return;
            }
        }
        System.out.println("Животное с именем " + name + " не найдено.");
    }

    public void teachNewCommand(String name, String command) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                String[] commands = command.split(",");
                for (int i = 0; i < commands.length; i++) {
                    String trimmedCommand = commands[i].trim();
                    commands[i] = trimmedCommand;
                }
                animal.teachNewCommand(command);
                saveDatabase();
                System.out.println("Команда успешно добавлена для животного.");
                return;
            }
        }
        System.out.println("Животное с именем " + name + " не найдено.");
    }

    private void loadDatabase() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4) {
                    String className = data[0];
                    String name = data[1];
                    LocalDate birthDate = LocalDate.parse(data[2]);
                    String skills = String.join(",", Arrays.copyOfRange(data, 3, data.length));
                    Animal animal;
                    switch (className) {
                        case "Dog" -> animal = new Dog(name, birthDate, skills);
                        case "Cat" -> animal = new Cat(name, birthDate, skills);
                        case "Hamster" -> animal = new Hamster(name, birthDate, skills);
                        case "Horse" -> animal = new Horse(name, birthDate, skills);
                        case "Camel" -> animal = new Camel(name, birthDate, skills);
                        case "Donkey" -> animal = new Donkey(name, birthDate, skills);
                        default -> {
                            System.out.println("Неизвестный класс животного: " + className);
                            continue;
                        }
                    }
                    animals.add(animal);
                } else {
                    System.out.println("Некорректные данные в файле: " + line);
                }
            }
            System.out.println("База данных успешно загружена.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении базы данных: " + e.getMessage());
        }
    }

    public void displayAllAnimals() {
        if (!animals.isEmpty()) {
            for (Animal animal : animals) {
                System.out.println(animal);
            }
        } else {
            System.out.println("Животных в списке нет");
        }
    }

    public void displayPetAnimals() {
        List<Pet> petAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal instanceof Pet) {
                petAnimals.add((Pet) animal);
            }
        }
        if (!petAnimals.isEmpty()) {
            for (Pet pet : petAnimals) {
                System.out.println(pet);
            }
        } else {
            System.out.println("Домашних животных не найдено");
        }
    }

    public void displayPackAnimals() {
        List<Pack> packAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal instanceof Pack) {
                packAnimals.add((Pack) animal);
            }
        }
        if (!packAnimals.isEmpty()) {
            for (Pack pack : packAnimals) {
                System.out.println(pack);
            }
        } else {
            System.out.println("Вьючных животных не найдено");
        }
    }

    public void displaySortedAnimals() {
        List<Animal> sortedAnimals = new ArrayList<>(animals);
        sortedAnimals.sort(new AnimalBirthDateComparator());
        for (Animal animal : sortedAnimals) {
            System.out.println(animal);
        }
    }

    public void displayNumberOfAnimals() {
        System.out.println("Общее количество животных: " + animals.size());
    }

    private void saveDatabase() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Animal animal : animals) {
                String className = animal.getClass().getSimpleName();
                String name = animal.getName();
                String birthDate = animal.getBirthDate().toString();
                String skills = animal.getSkills().replaceAll(",\\s+", ",");
                String line = className + "," + name + "," + birthDate + "," + skills;
                writer.write(line);
                writer.newLine();
            }
            System.out.println("База данных успешно сохранена.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении базы данных: " + e.getMessage());
        }
    }
}