package ru.itsjava.collections.lists.arraylist;

public class MyArrayListPracticeHW_311 {

    public static void main(String[] args) {

        MyArrayListHW_311 listHW311 = new MyArrayListHW_311();

//        System.out.println("Метод boolean add(Object o)");
//        System.out.println("listHW311.size() = " + listHW311.size());
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
//        System.out.println(listHW311);
//        System.out.println("listHW311.size() = " + listHW311.size());
//        System.out.println("Метод toString()");
//        System.out.println("listHW311.toString() = " + listHW311.toString());
        System.out.println("Метод boolean isEmpty()");
        listHW311.isEmpty();
        System.out.println("Метод boolean contains");
//        listHW311.contains(listHW311.get(1));
        listHW311.contains("Я здесь.");
        listHW311.contains(" ");
        System.out.println("Метод void clear");
        listHW311.clear();
        System.out.println(listHW311);

    }
}
