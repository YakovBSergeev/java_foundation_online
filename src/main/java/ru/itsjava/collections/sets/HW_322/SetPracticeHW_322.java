package ru.itsjava.collections.sets.HW_322;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetPracticeHW_322 {
    public static void main(String[] args) {
        Fruit apple0 = new Fruit( "красное яблоко", 0.2 );
        Fruit apple1 = new Fruit( "белый налив", 0.25 );
        Fruit apple2 = new Fruit( "аппорт", 0.8 );
        Fruit apple3 = new Fruit( "медовое", 0.15 );

        Set<Fruit> fruitSet = new HashSet<Fruit>(Arrays.asList( apple0, apple1, apple2, apple3) );
        System.out.println( "fruitSet = " + fruitSet );

        System.out.println( "fruitSet.add( apple3 ) = " + fruitSet.add( apple3 ) );
        Fruit apple4 = new Fruit( "медовое", 0.18 );
        System.out.println( "fruitSet.add( apple4 ) = " + fruitSet.add( apple4 ) );
        System.out.println( "fruitSet = " + fruitSet );
        System.out.println( "fruitSet.contains( apple1 ) = " + fruitSet.contains( apple1 ) );
        System.out.println( "fruitSet.remove( apple4 ) = " + fruitSet.remove( apple4 ) );
        System.out.println( "fruitSet = " + fruitSet );

    }
}
