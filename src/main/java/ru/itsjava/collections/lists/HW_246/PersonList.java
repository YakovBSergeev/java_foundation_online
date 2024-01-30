package ru.itsjava.collections.lists.HW_246;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonList {
    public static void main(String[] args) {
        Person vanya = new Person( "Vanya", 22, "man" );
        Person roma = new Person( "Roma", 42, "man" );
        Person sonya = new Person( "Sonya", 62, "female" );
        Person noi = new Person( "Noi", 9, "man" );
        Person bairan = new Person( "Bairan", 15, "man" );
        Person fedor = new Person( "Fedor", 30, "man" );
        Person sofia = new Person( "Sofia", 18, "female" );
        Person nikolas = new Person( "Nikolas", 24, "man" );

        List<Person> listN = new ArrayList<>( Arrays.asList( vanya, roma, sonya, noi, bairan, fedor, sofia, nikolas ) );
//        System.out.println( listN.get( 1 ).getName().charAt( 0 ) );
//        listN.get( i ).getName().substring( 0, 1 ).equals( "N" ));

        System.out.println( "Вернуть всех военнообязанных мужчин, которым меньше 30, больше 18 и имя начинается на N." );
        for (int i = 0; i < listN.size(); i++) {
            if (listN.get( i ).getName().charAt( 0 ) == 'N' && listN.get( i ).getAge() > 18 && listN.get( i ).getAge() < 30 && listN.get( i ).getIsMale().equals( "man" )) {
                System.out.println( listN.get( i ).getName() + " " + listN.get( i ).getAge() + " " + listN.get( i ).getIsMale() );

            }
        }
        System.out.println();
        System.out.println( "Найти средний возраст всех женщин." );
        double ageMix = 0;
        int countFemale = 0;
        for (int i = 0; i < listN.size(); i++) {
            if (listN.get( i ).getIsMale().equals( "female" )) {
                countFemale++;
                ageMix = (ageMix*(countFemale-1) + listN.get( i ).getAge())/countFemale;

            }

        }
        System.out.println( ageMix );
    }
}
