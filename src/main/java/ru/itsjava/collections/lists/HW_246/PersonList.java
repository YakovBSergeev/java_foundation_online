package ru.itsjava.collections.lists.HW_246;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonList {
    public static void main(String[] args) {
        Person vanya = new Person( "Vanya", 22, "man" );
        Person roma = new Person( "Roma", 42, "man" );
        Person sonya = new Person( "Sonya", 62, "man" );
        Person noi = new Person( "Noi", 9, "man" );
        Person bairan = new Person( "Bairan", 15, "man" );
        Person fedor = new Person( "Fedor", 30, "man" );
        Person semen = new Person( "Semen", 18, "man" );
        Person nikolas = new Person( "Nikolas", 24, "man" );

        List<Person> listN = new ArrayList<>( Arrays.asList( vanya, roma, sonya, noi, bairan, fedor, semen, nikolas ) );
//        System.out.println( listN.get( 1 ).getName().charAt( 0 ) );
//        System.out.println( listN.get( 1 ).getName().substring( 0,1 ) );

        System.out.println( "Вернуть всех военнообязанных мужчин, которым меньше 30, больше 18 и имя начинается на N." );
        for (int i = 0; i < listN.size(); i++) {
            if (listN.get( i ).getName().substring( 0, 1 ).equals( "N" ) && listN.get( i ).getAge() > 18 && listN.get( i ).getAge() < 30 && listN.get( i ).getIsMale().equals( "man" )) {
                System.out.println( listN.get( i ).getName() + " " + listN.get( i ).getAge() + " " + listN.get( i ).getIsMale() );

            }
        }

    }
}
