package ru.itsjava.Shop.first_app.src.ru.itsjava.OOP_Practice;

public class Main {
    public static void main(String[] args) {

        Person boris = new Man("Борис", 33);
        Person elen = new Woman("Елена", 18);
//        Woman galya = new Woman("Галя", 24, 58);

        Person[] array = new Person[]{boris, elen};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].printAge());
            array[i].printAll();
        }

//        galya.blank();

    }
}