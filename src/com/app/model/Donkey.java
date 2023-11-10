package com.app.model;

import java.time.LocalDate;

public class Donkey extends Pack {
    public Donkey(String name, LocalDate birthDate, String skills) {
        super(name, birthDate, skills);
    }

    @Override
    public void displayCommands() {
        System.out.println("Список команд для осла " + getName() + ": " + getSkills());
    }

    @Override
    public void teachNewCommand(String command) {
        String updatedSkills = getSkills() + "," + command;
        setSkills(updatedSkills);
        System.out.println("Осёл " + getName() + " научился новой команде: " + command);
    }

    @Override
    public String toString() {
        return "Осёл{" +
                "Имя='" + name + '\'' +
                ", Команды='" + skills + '\'' +
                ", Дата рождения=" + birthDate +
                '}';
    }
}