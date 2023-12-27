package ru.itsjava.oopPractice;

public class Main {
    public static void main(String[] args) {

        Person boris = new Man("Борис", 33);
        Person elen = new Woman("Елена", 18);

        Person[] array = new Person[]{boris, elen};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].printAge());
            array[i].printAll();
        }

        System.out.println(boris);
        boris.birthday();


    }
}