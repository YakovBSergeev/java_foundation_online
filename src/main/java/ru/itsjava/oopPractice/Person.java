package ru.itsjava.oopPractice;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
public class Person {

    private String name;

    private int age;


//    public Person(int age) {
//    }
//
//    public Person(int age) {
//        this.age = age;
//    }
//
//    public Person(String name, int age) {
//        this.age = age;
//        this.name = name;
//    }

    public void birthday() {
        age = age + 1;
//        System.out.println( age );
    }

    public boolean takeBeer(int age) {
        if (age > 18) {
            System.out.println( "true = " + true );
            return true;
        } else {
            System.out.println( "false = " + false );
            return false;
        }
    }

    public int printAge() {
        return age;
    }

    public void printAll() {

        System.out.println( name + " " + age );

    }
//    @Override
//    public String toString(){
//        return "name=" + name;
//    }

}
