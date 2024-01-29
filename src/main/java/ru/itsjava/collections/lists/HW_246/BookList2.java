package ru.itsjava.collections.lists.HW_246;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookList2 {

    public static void main(String[] args) {

        Book bloh = new Book( "Java. Эффективное программирование.", "Блох Дж.", 219 );
        Book java01 = new Book( "Java", "JavaEE", 219 );
        Book vijay = new Book( "Предметно-ориентированное проектирование в Enterprise Java.", "Виджей Наир", 306 );
        Book bauer = new Book( "Java Persistence API и Hibernate.", "Бауэр К., Кинг Г., Грегори Г.", 632 );
        Book java02 = new Book( "Java", "JavaSE", 219 );
        Book java03 = new Book( "Java", "Java00", 219 );
        Book kousen = new Book( "Современный Java: рецепты программирования.", "Кен Коузен", 274 );
        Book java04 = new Book( "Java", "Java01", 219 );
        Book macCormick = new Book( "Девять алгоритмов, которые изменили мир.", "Дж. Маккормик", 236 );

        List<Book> books = new ArrayList<>( Arrays.asList( bloh, java01, vijay, bauer, java02, java03, kousen, java04, macCormick ) );

//        6. Отфильтровать список вернуть записи по некоторому условию.
        System.out.println( "Книги, индекс в списке которых делится на три." );
        for (int i = 0; i < books.size(); i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println( books.get( i ).getTitle() + " " + books.get( i ).getAuthor() + " " + books.get( i ).getNumberOfPages() );
            }
        }
        System.out.println();

        System.out.println( "Вернуть колическтво книг, название которых Java" );
        int numberOfBooks = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.get( i ).getTitle().equals( "Java" )) {
                numberOfBooks++;
            }
        }
        System.out.println( "кол-во книг = " + numberOfBooks );
        System.out.println();

//        7. Пропустить несколько первых элементов.
        System.out.println( "Пропустить первые 3 книги в списке." );
        for (int i = 0; i < books.size(); i++) {
            if ((i) > 2) {
                System.out.println( books.get( i ).getTitle() + " " + books.get( i ).getAuthor() + " " + books.get( i ).getNumberOfPages() );
            }
        }
        System.out.println();

//        6+7. Пропускаем элементы, которые удовлетворяют некоторому условию.
        System.out.println( "Пропустить первые две книги, которые равны" + " Java" );
        int countBooks = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.get( i ).getTitle().equals( "Java" ) && countBooks < 2) {
                countBooks++;
                continue;
            } else {
                System.out.println( books.get( i ).getTitle() + " " + books.get( i ).getAuthor() + " " + books.get( i ).getNumberOfPages() );
            }
        }
        System.out.println();

//        8. Вернуть первый подходящий элемент.
        System.out.println( "Вернуть первую книгу, длина автора которой делиться на 3" );
        for (int i = 0; i < books.size(); i++) {
            if (books.get( i ).getAuthor().length() % 3 == 0) {
                System.out.println( books.get( i ).getTitle() + " " + books.get( i ).getAuthor() + " " + books.get( i ).getNumberOfPages() );
                break;
            }
        }
        System.out.println();

//        9. Возвращаем все элементы, удовлетворяющие условию.
        System.out.println( "Вернуть все книги, длина автора которой делиться на 3" );
        for (int i = 0; i < books.size(); i++) {
            if (books.get( i ).getAuthor().length() % 3 == 0) {
                System.out.println( books.get( i ).getTitle() + " " + books.get( i ).getAuthor() + " " + books.get( i ).getNumberOfPages() );

            }
        }

    }
}
