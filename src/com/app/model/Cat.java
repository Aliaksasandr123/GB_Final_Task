package com.app.model;

import java.time.LocalDate;

public class Cat extends Pet {
    public Cat(String name, LocalDate birthDate, String skills) {
        super(name, birthDate, skills);
    }

    @Override
    public void displayCommands() {
        System.out.println("Список команд для кошки " + getName() + ": " + getSkills());
    }

    @Override
    public void teachNewCommand(String command) {
        String updatedSkills = getSkills() + "," + command;
        setSkills(updatedSkills);
        System.out.println("Кошка " + getName() + " научилась новой команде: " + command);
    }

    @Override
    public String toString() {
        return "Кошка{" +
                "Имя='" + name + '\'' +
                ", Команды='" + skills + '\'' +
                ", Дата рождения=" + birthDate +
                '}';
    }
}