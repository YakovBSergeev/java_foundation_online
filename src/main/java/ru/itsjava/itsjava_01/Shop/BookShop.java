package ru.itsjava.shop.first_app.src.ru.itsjava.Shop;

import java.util.Scanner;

public class BookShop {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в магазин книг!");

        String[] books = new String[]{"Философия_Java", "Изучаем_Java", "Совершенный_код", "Гарри_Поттер"};

        printMenu();
        Scanner console = new Scanner(System.in);

        System.out.println("Введите номер меню");
        int menuNum = console.nextInt();

        while (true) {
            if (menuNum == 1) {
                printAllBooks(books);
            } else if (menuNum == 2) {
                books = addBook(console, books);
            } else if (menuNum == 3) {
                books = removeBook(console, books);
            } else if (menuNum == 4) {
                bubbleSort(books);
            } else if (menuNum == 0) {
                System.out.println("Спасибо, что воспользовались нашим магазином");
                System.exit(0);
            }

            System.out.println("Введите номер меню");
            menuNum = console.nextInt();
        }

    }

    //           0 1 2 3 4
    //books:     a b c d e
    //resArray:  a b d e
    private static String[] removeBook(Scanner console, String[] books) {
        System.out.println("Введите название книги");
        String inputBook = console.next();
        String[] resArray = new String[books.length - 1];

        int delIndex;
        for (delIndex = 0; delIndex < books.length; delIndex++) {
            if (books[delIndex].equals(inputBook)) {
                break;
            }
            resArray[delIndex] = books[delIndex];
        }

        for (int i = delIndex; i < resArray.length; i++) {
            resArray[i] = books[i + 1];
        }

        return resArray;
    }

    private static String[] addBook(Scanner console, String[] books) {
        System.out.println("Введите название книги");
        String inputBook = console.next();
        String[] resArray = new String[books.length + 1];

        for (int i = 0; i < books.length; i++) {
            resArray[i] = books[i];
        }
        resArray[books.length] = inputBook;

        return resArray;
    }

    private static void printAllBooks(String[] books) {
        System.out.println("Наши книги: ");
        for (int i = 0; i < books.length; i++) {
            System.out.print(books[i] + " ");
        }
        System.out.println();
    }

    private static void bubbleSort(String[] books) {
        for (int j = 0; j < books.length; j++) {
            for (int i = 0; i < books.length - j - 1; i++) {
                if (books[i].charAt(0) > books[i + 1].charAt(0)) {
                    String temp = books[i];
                    books[i] = books[i + 1];
                    books[i + 1] = temp;
                }
            }
        }
    }

    public static void printMenu() {
        System.out.println("Меню:\n" +
                "1. Вывести все книги\n" +
                "2. Добавить книгу\n" +
                "3. Удалить книгу\n" +
                "4. Отсортировать книги\n" +
                "0. Выход");
    }
}

// Меню:
// 1. Вывести все книги
// 2. Добавить книгу
// 3. Удалить книгу
// 4. Отсортировать книги
// 0. Выход
