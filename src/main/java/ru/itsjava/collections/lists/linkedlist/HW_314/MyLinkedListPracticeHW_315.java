package ru.itsjava.collections.lists.linkedlist.HW_314;

public class MyLinkedListPracticeHW_315 {
    public static void main(String[] args) {
        MyLinkedListHW_314 listHW_314 = new MyLinkedListHW_314();
        listHW_314.add("Строка_1");
        listHW_314.add("Строка_2");
        listHW_314.add("Строка_3");
        System.out.println("listHW_314 = " + listHW_314);

        System.out.println("listHW_314.remove(1) = " + listHW_314.remove(2));
        System.out.println("listHW_314 = " + listHW_314);

        System.out.println("listHW_314.get(1) = " + listHW_314.get(1));
        listHW_314.add("Str_12");
        listHW_314.add("Str_15");
        System.out.println("listHW_314 = " + listHW_314);
        System.out.println("listHW_314.set(2, 28) = " + listHW_314.set(2, 28));
        System.out.println("listHW_314 = " + listHW_314);
        listHW_314.clear();
        System.out.println("listHW_314 = " + listHW_314);
    }

}
