package ru.itsjava.Shop.first_app.src.ru.itsjava.object;

public class ObjectPractice {
    public static void main(String[] args) {

        Object obj1 = new Object();
        Object obj2 = new Object(); //ctrl+D

        System.out.println(obj1 == obj2);

        System.out.println("obj1.equals(obj2)" + obj1.equals(obj2));

        obj1 = obj2;
        System.out.println("obj1.equals(obj2)" + obj1.equals(obj2));

            Dog dog1 = new Dog("Strelka", 4);
            Dog dog1_1 = new Dog("Strelka", 4);
            Dog dog2 = new Dog("Belka", 4);

        System.out.println(dog1.equals(dog2));
        System.out.println(dog1_1.equals(dog1));
        System.out.println(dog1_1==dog1);

        dog1 = dog1_1;
        System.out.println(dog1_1==dog1);

        System.out.println(dog1);


    }


}
