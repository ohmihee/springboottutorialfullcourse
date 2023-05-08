package com.example.javafullcourse.learnEnum;

public enum Color {
    RED("red"),
    GREEN("green");

    private String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

class Main {
    public static void main (String[] args) {
        Color c1 = Color.RED;

        System.out.println("Red Enum name: " + c1.name());
        System.out.println("Red Enum value: " + c1.getValue());

        for (Color color :Color.values()) {
            System.out.println("Red Enum name: " + color.name());
            System.out.println("Enum value: " + color.getValue());
        }
    }
}
