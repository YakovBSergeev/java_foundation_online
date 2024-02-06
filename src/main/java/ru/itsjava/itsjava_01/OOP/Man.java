package ru.itsjava.itsjava_01.OOP;

public class Man {

    private String name;
    private int age;


    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Man(String name) {
        this.name = name;
    }

    public Man(int age) {
        this.age = age;
    }

    public void hi() {
        System.out.println("Приветствую, меня зовут " + name + ", мне " + age + " года.");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
