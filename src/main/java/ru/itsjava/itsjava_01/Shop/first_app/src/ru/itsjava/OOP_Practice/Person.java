package ru.itsjava.Shop.first_app.src.ru.itsjava.OOP_Practice;

public class Person {

    private int age;
    private String name;

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }


    public int printAge() {
        return age;
    }

    public void printAll() {

        System.out.println(name + " " + age);

    }
}
