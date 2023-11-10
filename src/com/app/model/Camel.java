package com.app.model;

import java.time.LocalDate;

public class Camel extends Pack {
    public Camel(String name, LocalDate birthDate, String skills) {
        super(name, birthDate, skills);
    }

    @Override
    public void displayCommands() {
        System.out.println("Список команд для верблюда " + getName() + ": " + getSkills());
    }

    @Override
    public void teachNewCommand(String command) {
        String updatedSkills = getSkills() + "," + command;
        setSkills(updatedSkills);
        System.out.println("Верблюд " + getName() + " научился новой команде: " + command);
    }

    @Override
    public String toString() {
        return "Верблюд{" +
                "Имя='" + name + '\'' +
                ", Команды='" + skills + '\'' +
                ", Дата рождения=" + birthDate +
                '}';
    }
}