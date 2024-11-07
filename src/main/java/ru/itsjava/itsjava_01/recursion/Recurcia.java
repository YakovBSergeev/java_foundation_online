package ru.itsjava.itsjava_01.recursion;

public class Recurcia {
    public static void main(String[] args) {
        System.out.println("Факториал 23!: " + fact(23));
    }

    public static long fact(long num) {
        if ((num == 1) || (num == 0)) {
            return 1;
        } else if (num < 0) {
            System.err.println("факториал не сущуствует");
            return -1;
        } else {
            return num * fact(num - 1);

        }

    }
}