package ru.itsjava.shop.first_app.src.ru.itsjava.Shop;

import java.util.Scanner;

public class TShirtShop {

    public static void main(String[] args) {
        System.out.println( "Добро пожаловать в магазин футболок!" );

        String[] tshirt = new String[]{"Белая", "Серая", "Черная", "Синяя", "Коричневая"};

        printMenu();
        Scanner console = new Scanner( System.in );

        System.out.print( "Введите номер меню: " );
        int menuNum = console.nextInt();

        while (true) {
            if (menuNum == 1) {
                printAllTsirt( tshirt );
            } else if (menuNum == 2) {
                tshirt = addTshirt( console, tshirt );
            } else if (menuNum == 3) {
                tshirt = deleteShirt( console, tshirt );
            } else if (menuNum == 4) {
                int low = 0, hihg = tshirt.length - 1;
                sortingQuickShirt( tshirt, low, hihg );
            } else if (menuNum == 0) {
                System.out.println( "Спасибо, что воспользовались нашим магазином!" );
                System.exit( 0 );
            } else {
                break;
            }

            System.out.print( "Введите номер меню: " );
            menuNum = console.nextInt();

        }

    }

    private static void sortingQuickShirt(String[] tshirt, int low, int high) {
        int middle = low + (high - low) / 2;
        String pivot = tshirt[middle];
        if (tshirt.length == 0)
            return;
        if (low >= high)
            return;

        int i = low, j = high;
        while (i <= j) {
            while (tshirt[i].charAt( 0 ) < pivot.charAt( 0 )) {
                i++;
            }
            while (tshirt[j].charAt( 0 ) > pivot.charAt( 0 )) {
                j--;
            }
            if (i <= j) {
                String temp = tshirt[i];
                tshirt[i] = tshirt[j];
                tshirt[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            sortingQuickShirt( tshirt, low, j );
        if (high > i)
            sortingQuickShirt( tshirt, i, high );
    }

    private static String[] deleteShirt(Scanner console, String[] tshirt) {
        System.out.print( "Введите цвет футболки: " );
        String inputTshirt = console.next();
        String[] arrDel = new String[tshirt.length - 1];
        int delIndex;
        for (delIndex = 0; delIndex < tshirt.length; delIndex++) {
            if (tshirt[delIndex].equals( inputTshirt )) {
                break;
            } else if (delIndex == tshirt.length - 1) {
                System.out.println( "Нет такой футболки" );
                System.exit( 0 );
            }
            arrDel[delIndex] = tshirt[delIndex];
        }
        for (int i = delIndex; i < tshirt.length - 1; i++) {
            arrDel[i] = tshirt[i + 1];
        }
        tshirt = arrDel;
        return tshirt;
    }

    private static String[] addTshirt(Scanner console, String[] tshirt) {
        System.out.print( "Введите цвет футболки: " );
        String inputTshirt = console.next();
        String[] arrAdd = new String[tshirt.length + 1];

        for (int i = 0; i < tshirt.length; i++) {
            arrAdd[i] = tshirt[i];
        }
        arrAdd[tshirt.length] = inputTshirt;

        tshirt = arrAdd;
        return tshirt;
    }


    private static void printAllTsirt(String[] tshirt) {
        System.out.println( "Футболки в наличии: " );
        for (int i = 0; i < tshirt.length; i++) {
            System.out.print( tshirt[i] + " " );

        }
        System.out.println();
    }

    public static void printMenu() {
        System.out.println( "Меню: \n" +
                "1. Вывести весь ассортимент \n" +
                "2. Добавить футболку\n" +
                "3. Удалить футболку\n" +
                "4. Отсортировать\n" +
                "0. Выход" );
    }


}


// Меню:
// 1. Вывести весь ассортимент
// 2. Добавить футболку
// 3. Удалить футболку
// 4. Отсортировать
// 5. Выход
