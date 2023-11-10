package com.app.model;

import java.time.LocalDate;

public class Hamster extends Pet {
    public Hamster(String name, LocalDate birthDate, String skills) {
        super(name, birthDate, skills);
    }

    @Override
    public void displayCommands() {
        System.out.println("Список команд для хомяка " + getName() + ": " + getSkills());
    }

    @Override
    public void teachNewCommand(String command) {
        String updatedSkills = getSkills() + "," + command;
        setSkills(updatedSkills);
        System.out.println("Хомяк " + getName() + " научился новой команде: " + command);
    }

    @Override
    public String toString() {
        return "Хомяк{" +
                "Имя='" + name + '\'' +
                ", Команды='" + skills + '\'' +
                ", Дата рождения=" + birthDate +
                '}';
    }
}