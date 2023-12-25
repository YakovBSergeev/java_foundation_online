package ru.itsjava.oopPractice;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor


public class Person {

    private int age;
    private String name;

    public Person(int age) {
    }

//    public Person(int age) {
//        this.age = age;
//    }
//
//    public Person(String name, int age) {
//        this.age = age;
//        this.name = name;
//    }


    public int printAge() {
        return age;
    }

    public void printAll() {

        System.out.println(name + " " + age);

    }
//    @Override
//    public String toString(){
//        return "name=" + name;
//    }

}
