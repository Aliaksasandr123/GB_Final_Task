package com.app.model;

import java.time.LocalDate;

public abstract class Pack extends Animal {
    public Pack(String name, LocalDate birthDate, String skills) {
        super(name, birthDate, skills);
    }
}