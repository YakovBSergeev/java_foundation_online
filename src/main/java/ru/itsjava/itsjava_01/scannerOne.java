package ru.itsjava.itsjava_01;

import java.io.Console;
import java.util.Scanner;

public class scannerOne {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        //Задание_1 (Максимум из дыух чисел)
        System.out.println("Введите два целых числа");
        int num1 = console.nextInt();
        int num2 = console.nextInt();
        if ((num1 - num2) > 0) {
            System.out.println(num1);
            System.out.println("максимум из двух чисел");
        } else if ((num1 - num2) < 0) {
            System.out.println(num2);
            System.out.println("максимум из двух чисел");
        } else {
            System.out.println("числа равны друг другу");
        }

        //Задание_2 (Минимум из трех чисел)
        System.out.println("Введите три целых числа");
        int num3 = console.nextInt();
        int num4 = console.nextInt();
        int num5 = console.nextInt();
        if (num3 == num4 && num4 == num5) {
            System.out.println("числа равны друг другу");
            System.out.println("минимальное число");
            System.out.println(num3);
        } else if ((num3 <= num4) && (num3 <= num5) && ((num3 != num5) || (num3 != num4) || (num3 != num4))) {
            System.out.println("минимальное число");
            System.out.println(num3);
        } else if ((num4 <= num3) && (num4 <= num5) && ((num3 != num5) || (num3 != num4) || (num3 != num4))) {
            System.out.println("минимальное число");
            System.out.println(num4);
        } else if ((num5 <= num3) && (num5 <= num4) && ((num3 != num5) || (num3 != num4) || (num3 != num4))) {
            System.out.println("минимальное число");
            System.out.println(num5);
        } else {

        }

        //Задание_3 (Распределение по возрасту)
        System.out.println("Введите возраст человека");
        int age = console.nextInt();
        if (age < 0 || age > 100) {
            System.out.println("возраст некорректен");
        } else if (age >= 0 && age < 18) {
            System.out.println("еще слишком мал");
        } else if (age >= 18 && age < 27) {
            System.out.println("служи");
        } else System.out.println("уже слишком поздно");


        //Задание_5 (Поменять значения двух переменных местами)
        int num01 = 3;
        int num02 = 5;
        System.out.println(num01 ^= num02);
        System.out.println(num02 ^= num01);
        System.out.println(num01 ^= num02);


        //Задание_6 (нахождение корней квадратного уравняния)

        System.out.println("Введите ...");
        double x, D;
        double a = console.nextInt();
        double b = console.nextInt();
        double c = console.nextInt();
        D = (b * b) - (4 * a * c);
        if (D < 0) {
            System.out.println("в квадратном уравнении нет действительных корней");
        } else if (D == 0) {
            System.out.println("корни квадратного уравнения");
            System.out.println(-b / (2 * a));
        } else if (D > 0) {          //Почему, если вместо else if поставить else, при D=0 выдает три решения (Поставить оператор > во втором условии)??? Что значит NaN в решении кв.ур.?
            System.out.println("корни квадратного уравнения");
            System.out.println((-b - Math.sqrt(D)) / (2 * a));
            System.out.println((-b + Math.sqrt(D)) / (2 * a));

        }
    }


}