package ru.itsjava.collections.lists.linkedlist;

import java.util.List;

public class MyLinkedListPracticeHW_314 {
    public static void main(String[] args) {
        MyLinkedListHW_314 listHW_314 = new MyLinkedListHW_314();
        listHW_314.add("Строка_1");
        System.out.println("listHW_314 = " + listHW_314);
        listHW_314.add("Строка_2");
        System.out.println("listHW_314 = " + listHW_314);
        listHW_314.add("Строка_3");
        System.out.println("listHW_314 = " + listHW_314);

        System.out.println("listHW_314.size() = " + listHW_314.size());
        System.out.println("listHW_314.isEmpty() = " + listHW_314.isEmpty());
        System.out.println("listHW_314.contains(\"Строка_2\") = " + listHW_314.contains("Строка_2"));
    }

}
