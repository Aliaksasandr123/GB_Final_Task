package com.app.model;

import java.time.LocalDate;

public abstract class Pet extends Animal {
    public Pet(String name, LocalDate birthDate, String skills) {
        super(name, birthDate, skills);
    }
}