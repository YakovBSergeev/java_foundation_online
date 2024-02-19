package ru.itsjava.collections.lists.linkedlist.HW_314;

public class MyLinkedListPracticeHW_316 {
    public static void main(String[] args) {
        MyLinkedListHW_314 listHW_314 = new MyLinkedListHW_314();
        listHW_314.add("Строка_1");
        listHW_314.add("Строка_2");
        listHW_314.add("Строка_3");
        listHW_314.add("Строка_3");
        listHW_314.add("Строка_2");
        listHW_314.add("Строка_1");
        System.out.println("listHW_314 = " + listHW_314);
        System.out.println("listHW_314.indexOf(\"Строка_3\") = " + listHW_314.indexOf("Строка_3"));
        System.out.println("listHW_314.lastIndexOf(\"Строка_1\") = " + listHW_314.lastIndexOf("Строка_1"));


    }

}
