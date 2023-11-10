package com.app.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Animal {
    protected String name;
    protected String skills;
    protected LocalDate birthDate;

    public Animal(String name, LocalDate birthDate, String skills) {
        this.name = name;
        this.birthDate = birthDate;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) && Objects.equals(skills, animal.skills) && Objects.equals(birthDate, animal.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, skills, birthDate);
    }

    public abstract void displayCommands();

    public abstract void teachNewCommand(String command);
}