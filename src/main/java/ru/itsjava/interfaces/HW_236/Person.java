package ru.itsjava.interfaces.HW_236;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Person implements Comparable<Person>, Cloneable {

    private String name;
    private String surname;
    private float age;


    @Override
    public int compareTo(Person person) {
        if (surname.compareTo(person.surname) != 0) {
            return surname.compareTo(person.surname);
        } else if (name.compareTo(person.name) != 0) {
            return name.compareTo(person.name);
        }
        return (int) (age - person.age);

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}