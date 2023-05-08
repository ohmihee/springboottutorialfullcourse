package com.example.javafullcourse.learnAnnonation;

public class main {
    public static void main(String[] args) {
        TestClass test = new TestClass();
        UUIDGeneratorProcessor.process(test);
        System.out.println(test.getId());
    }
}
