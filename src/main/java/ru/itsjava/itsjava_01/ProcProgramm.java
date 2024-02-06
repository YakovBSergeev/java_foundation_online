package ru.itsjava;

public class ProcProgramm {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = -1;
        int min = minOf(num1, num2);
        conditionEqual(num1, num2);
        printMinOf(num1, num2);
    }

    public static int minOf(int num1, int num2) {
        if (num1 >= num2) {
            return num2;
        } else {
            return num1;
        }
    }

    public static void printMinOf(int num1, int num2) {
        if (num1 >= num2) {
            System.out.println("Минимальное значение: " + num2);
        } else {
            System.out.println("Минимальное значение: " + num1);
        }
    }

    public static void conditionEqual(int num1, int num2) {
        if (num1 == num2) {
            System.out.println("Числа равны");
        } else {
            System.out.println("Числа не равны");
        }
    }

}