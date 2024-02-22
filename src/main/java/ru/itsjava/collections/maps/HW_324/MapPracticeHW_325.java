package ru.itsjava.collections.maps.HW_324;

import java.util.HashMap;
import java.util.Map;

public class MapPracticeHW_325 {
    public static void main(String[] args) {

        Map<Man, Fruit> basket = new HashMap<>();
        Man artem = new Man( "Артем" );
        Man grigor = new Man( "Григорий" );
        Man gretta = new Man( "Гретта" );
        Man georg = new Man( "Георгий" );
        Man gala = new Man( "Галя" );
        Fruit fr0 = new Fruit( "арбуз", 7.5 );
        Fruit fr1 = new Fruit( "дыня", 5.2 );
        Fruit fr2 = new Fruit( "банан", 1.0 );
        Fruit fr3 = new Fruit( "гранат", 0.5 );
        Fruit fr4 = new Fruit( "груша", 0.3 );
        basket.put( artem, fr0 );
        basket.put( gretta, fr4 );
        basket.put( georg, fr3 );
        basket.put( grigor, fr1 );
        basket.put( gala, fr2 );
        System.out.println( "----------Ключи с длиной имени больше пяти----------------------" );
        for (Map.Entry<Man, Fruit> pair : basket.entrySet()
        ) {
            if (pair.getKey().getName().length() > 5) {
                System.out.println( pair.getKey() );
            }
        }
        System.out.println( "----------Количество дынь----------------------" );
        int count = 0;
        for (Map.Entry<Man, Fruit> pair : basket.entrySet()
        ) {
            if (pair.getValue().getName().equals( "дыня" )) {
                count++;
            }
        }
        System.out.println( "дынь: " + count );

        System.out.println( "----------Вывести названия элементов, пропустив два арбуза----------------------" );
        count = 0;
        for (Map.Entry<Man, Fruit> pair : basket.entrySet()
        ) {
            if (!(pair.getValue().getName().equals( "арбуз" ) && count < 2)) {
                System.out.println( pair.getValue() );
            } else if (pair.getValue().getName().equals( "арбуз" )) {
                count++;
            }
        }
        System.out.println( "----------Вывести названия элементов, пропустив два ключа на \"А\"----------------------" );
        count = 0;
        for (Map.Entry<Man, Fruit> pair : basket.entrySet()
        ) {
            if (!(pair.getKey().getName().startsWith( "А" ) && count < 2)) {
                System.out.println( pair.getValue() );
            } else if (pair.getKey().getName().startsWith( "А" )) {
                count++;
            }
        }
        System.out.println( "----------Возвратить элемент арбуз или Арбуз или АРбУз----------------------" );
        retFruit( basket );
        System.out.println( "----------Возвратить  все элементы арбуз или дыня в другую карту----------------------" );
        System.out.println( "retFruitPart( basket ) = " + retFruitPart( basket ) );
        System.out.println( "----------Средний вес всех фруктов----------------------" );
        System.out.println( "weightFruit( basket ) = " + weightFruit( basket ) );
    }

    public static Fruit retFruit(Map<Man, Fruit> basket) {
        for (Map.Entry<Man, Fruit> pair : basket.entrySet()) {
            if ((pair.getValue().getName().equals( "арбуз" ) || pair.getValue().getName().equals( "Арбуз" ) || pair.getValue().getName().equals( "АРбУз" ))) {
                System.out.println( pair.getValue() );
                return pair.getValue();
            }
        }
        return null;
    }

    public static Map<Man, Fruit> retFruitPart(Map<Man, Fruit> basket) {
        Map<Man, Fruit> basketNew = new HashMap<>();
        for (Map.Entry<Man, Fruit> pair : basket.entrySet()) {
            if ((pair.getValue().getName().equals( "арбуз" ) || pair.getValue().getName().equals( "дыня" ))) {
                basketNew.put( pair.getKey(), pair.getValue() );
            }
        }
        return basketNew;
    }

    public static double weightFruit(Map<Man, Fruit> basket) {
        int count = 0;
        double weight = 0;
        for (Map.Entry<Man, Fruit> pair : basket.entrySet()) {
            weight = weight + pair.getValue().getWeight();
            count++;
        }
        return weight / count;
    }

}

