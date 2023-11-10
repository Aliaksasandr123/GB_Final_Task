package com.app.utils.comparator;

import com.app.model.Animal;

import java.util.Comparator;

public class AnimalBirthDateComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}