package ru.itsjava.examples.arrayLinked;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import static java.lang.Math.random;

public class Main {
    public static void main(String[] args) {
        ArrayList<BigInteger> arrayList = new ArrayList<>();
        ArrayList<BigInteger> arrayList01 = new ArrayList<>();
        int m = 10000, n = 10, k = 0;
        for (int i = 0; i < m; i++) {
            arrayList.add( BigInteger.valueOf( (int) ((double) (random()) * 100) ) );
            arrayList01.add( BigInteger.valueOf( (int) ((double) (random()) * 100) ) );
        }
//        arrayList.toArray();
/*Убираем из коллекции все повторы*/
        for (int i = 0; i < arrayList.size(); i++) {
            int kCount = 0;
            BigInteger entry = arrayList.get( i );
            Iterator<BigInteger> nextIterator = arrayList.iterator();
            while (nextIterator.hasNext()) {
                BigInteger arrayArray = nextIterator.next();
                if (entry.equals( arrayArray ) && kCount > i) {
                    nextIterator.remove();
                }
                kCount++;
            }
        }
//        long startTime = System.nanoTime();
        /*Убираем из коллекции все повторы*/
        Object[] array = arrayList01.toArray();
        for (int j = 0; j < array.length; j++) {
            for (int i = j + 1; i < array.length; i++) {
                if (array[j] != null && array[j].equals( array[i] )) {
                    k++;
                    array[i] = null;
                }
            }
        }
        arrayList01.clear();
        for (Object a : array
        ) {
            if (a != null) {
                arrayList01.add( (BigInteger) a );
            }
        }


//        k++;
//        System.out.println( k + " j=" + j + "; " + arrayList.get( j ) + "; i=" + i + "; " + arrayList.get( i ) + "; " );

//        System.out.println( System.nanoTime() - startTime );

//        startTime = System.nanoTime();
//        for (int i = 0; i < n; i++) {
//            linkedList.get( (int) (random() * (m - 1)) );
//        }

        //        System.out.println( System.nanoTime() - startTime );
//        System.out.println( arrayList );
        HashSet<BigInteger> hashSet = new HashSet<>( arrayList );
        HashSet<BigInteger> hashSet01 = new HashSet<>( arrayList01 );


//         removeDuplicates( arrayList );

        int count = 0;
//        for (int a : hashSet
//        ) {
//            count++;
//        }

        for (
                int i = 0; i < arrayList01.size(); i++) {
            count++;
        }


        System.out.println();
        System.out.println( arrayList.size() );
//        System.out.println( arrayList );
        System.out.println( hashSet.size() );
        System.out.println();
        System.out.println( count );
        System.out.println( k );
        System.out.println( arrayList01.size() );
//        System.out.println( arrayList01 );
        System.out.println( hashSet01.size() );
    }

    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        return new HashSet<>( collection );
    }

}

