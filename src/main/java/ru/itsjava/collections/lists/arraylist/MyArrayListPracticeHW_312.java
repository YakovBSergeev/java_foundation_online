package ru.itsjava.collections.lists.arraylist;

public class MyArrayListPracticeHW_312 {
    public static void main(String[] args) {
        MyArrayListHW_311 listHW311 = new MyArrayListHW_311();


        listHW311.add("Где ты?");
        listHW311.add("Я здесь.");
        listHW311.add("Я здесь.");
        listHW311.add("Я здесь.");
        listHW311.add("Я здесь.");
        listHW311.add("Я здесь.");
        listHW311.add("Я здесь.");
        listHW311.add("Я здесь.");
        listHW311.add("Я здесь.");
        listHW311.add("Я здесь.");
        listHW311.add("Я здесь.");
        System.out.println(listHW311);
        System.out.println(" ");
//        System.out.println("Метод boolean remove(Object o)");
//        listHW311.remove("Где ты?");
//        System.out.println(listHW311);
//        System.out.println("Метод Object remove(int index)");
//        listHW311.remove(1);
//        System.out.println(listHW311);
        System.out.println("Метод Object get(int index)");
        System.out.println("listHW311.get(1) " + listHW311.get(1));
        System.out.println(" ");

        System.out.println("Метод Object set(int index, Object element)");
        listHW311.set(1, "Где ты?");
        System.out.println(listHW311);
        System.out.println(" ");

        System.out.println("Метод void add(int index, Object element)");
        listHW311.add(2, "Привет!");
        System.out.println(listHW311);
        System.out.println(" ");

        System.out.println("Метод int indexOf(Object o)");
        System.out.println( "listHW311.indexOf( \"Я здесь.\" ) = " + listHW311.indexOf( "Я здесь." ) );
        System.out.println(" ");

        System.out.println("Метод int lastIndexOf(Object o)");
        System.out.println( "listHW311.lastIndexOf( \"Я здесь.\" ) = " + listHW311.lastIndexOf( "Я здесь." ) );
        System.out.println( "listHW311.lastIndexOf( \"Привет!\" ) = " + listHW311.lastIndexOf( "Привет!" ) );

    }
}
