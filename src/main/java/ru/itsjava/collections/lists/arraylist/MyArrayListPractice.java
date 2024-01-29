package ru.itsjava.collections.lists.arraylist;

public class MyArrayListPractice {
    public static void main(String[] args) {
//        MyArrayList list = new MyArrayList();
//        System.out.println(list.size());
//        list.add("Привет");
//        list.add("Пока");
//        System.out.println("После добавления двух элементов размер равен "
//                + list.size());
//        list.add("Пока");
//        list.add("Пока");
//        list.add("Пока");
//        list.add("Пока");
//        list.add("Пока");
//        list.add("Пока");
//        list.add("Пока");
//        list.add("Пока");
//        list.add("Пока");
//        System.out.println("list.size() = " + list.size());
//
//        System.out.println(list);
//        System.out.println("list.remove(\"Привет\") = " + list.remove("Привет"));
//        System.out.println("list.size() = " + list.size());
//        System.out.println(list);
//
//        System.out.println("list.remove(\"Пока\") = " + list.remove("Пока"));
//        System.out.println(list);
//
//        list.add("До_свидания");
//        System.out.println(list);
//        list.remove(9);
//        System.out.println(list);
//
//        list.remove(1);
//        System.out.println(list);


        MyArrayList list = new MyArrayList();
        list.add("element1");
        list.add("element2");
        list.add("element3");
        list.add("element4");

//        list.remove(1);
//        System.out.println(list);
//
//        list.remove(0);
//        System.out.println(list);
        list.remove("element1");
        System.out.println(list);
        list.remove("element3");
        System.out.println(list);
    }
}
