package ru.itsjava.collections.maps.HW_324;

import ru.itsjava.collections.maps.HW_324.Fruit;
import ru.itsjava.collections.maps.HW_324.Man;

import java.util.HashMap;
import java.util.Map;

public class MapPracticeHW_324 {
    public static void main(String[] args) {

        Map<Man, Fruit> basket = new HashMap<>();
        Man igor = new Man("Игорь");
        Man grigor = new Man("Григорий");
        Man georg = new Man("Георгий");
        Fruit apple0 = new Fruit("антоновка", 0.5);
        Fruit apple1 = new Fruit("антоновка", 1.0);
        Fruit apple2 = new Fruit("антоновка", 1.5);
        Fruit apple3 = new Fruit("антоновка", 2.0);
        Fruit apple4 = new Fruit("антоновка", 2.5);
        basket.put(igor, apple0);
        basket.put(igor, apple4);
        basket.put(georg, apple3);
        basket.put(grigor, apple1);

        for (Map.Entry<Man, Fruit> key : basket.entrySet()
        ) {
            System.out.println(key.getKey() + ": " + key.getValue());
        }
        System.out.println("--------------------------------");
        System.out.println("basket.remove( georg,apple3 ) = " + basket.remove(georg, apple3));
        for (Man key : basket.keySet()
        ) {
            System.out.println(key + ": " + basket.get(key));
        }
        System.out.println("--------------------------------");
        System.out.println("basket.containsValue( apple4 ) = " + basket.containsValue(apple4));
        System.out.println("--------------------------------");
        for (Man keyMan : basket.keySet()
        ) {
            System.out.println(keyMan);
        }
        System.out.println("--------------------------------");
        for (Man keyMan : basket.keySet()
        ) {
            System.out.println(basket.get(keyMan));
        }
        System.out.println("--------------------------------");

        for (Map.Entry<Man, Fruit> key : basket.entrySet()
        ) {
            System.out.println(key.getKey() + ": " + key.getValue());
        }

    }
}
