package com.bucur.randomizer;

import java.util.ArrayList;
import java.util.List;

public class DemoIustin {

    private static List<String> names = new ArrayList<>();

    public DemoIustin() {
        populateList();
    }

    public static void main(String[] args) {
        updatePerson("Dan", "Daniela");
        System.out.println(names);
    }

    public static void updatePerson(String oldName, String newName) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equals(oldName)) {
                names.remove(oldName);
                names.add(i, newName);
            }
        }
    }

    public static List<String> updatePerson(List<String> names, String oldName, String newName) {

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equals(oldName)) {
                names.remove(oldName);
                names.add(i, newName);
            }
        }
        return names;
    }

    private void populateList() {
        names.add("Ana");
        names.add("Bob");
        names.add("Claudiu");
        names.add("Dan");
        names.add("Elena");
        names.add("Florin");
    }
}