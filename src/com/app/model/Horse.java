package com.app.model;

import java.time.LocalDate;

public class Horse extends Pack {
    public Horse(String name, LocalDate birthDate, String skills) {
        super(name, birthDate, skills);
    }

    @Override
    public void displayCommands() {
        System.out.println("Список команд для лошади " + getName() + ": " + getSkills());
    }

    @Override
    public void teachNewCommand(String command) {
        String updatedSkills = getSkills() + "," + command;
        setSkills(updatedSkills);
        System.out.println("Лошадь " + getName() + " научилась новой команде: " + command);
    }

    @Override
    public String toString() {
        return "Лошадь{" +
                "Имя='" + name + '\'' +
                ", Команды='" + skills + '\'' +
                ", Дата рождения=" + birthDate +
                '}';
    }
}