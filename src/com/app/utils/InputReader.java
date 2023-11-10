package com.app.utils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class InputReader {
    public static String getStringInput(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public static Integer getIntegerInput(Scanner scanner, String message) {
        System.out.println(message);
        boolean isValid = false;
        Integer input = null;
        while (!isValid) {
            String line = scanner.nextLine();
            if (isDigit(line)) {
                input = Integer.valueOf(line);
                if (isPositive(input)) {
                    isValid = true;
                } else {
                    System.out.println("Входное значение должно быть больше или равно 0");
                }
            } else {
                System.out.println("Неправильный ввод. Пожалуйста, повторите ввод");
            }
        }
        return input;
    }

    private static boolean isDigit(String line) {
        try {
            Integer.parseInt(line);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Строка не состоит из цифр");
            return false;
        }
    }

    private static boolean isPositive(Integer number) {
        return number >= 0;
    }

    public static LocalDate getLocalDateInput(Scanner scanner, String message) {
        System.out.println(message);
        boolean isValid = false;
        LocalDate input = null;
        while (!isValid) {
            String line = scanner.nextLine();
            if (isDate(line)) {
                input = LocalDate.parse(line);
                isValid = true;
            } else {
                System.out.println("Неправильный ввод. Пожалуйста, введите дату в формате \"YYYY-MM-DD\"");
            }
        }
        return input;
    }

    private static boolean isDate(String line) {
        try {
            LocalDate.parse(line);
            return true;
        } catch (DateTimeException e) {
            System.out.println("Строка не состоит из даты в формате \"YYYY-MM-DD\"");
            return false;
        }
    }
}