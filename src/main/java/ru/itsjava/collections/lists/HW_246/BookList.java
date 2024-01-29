package ru.itsjava.collections.lists.HW_246;

import java.util.ArrayList;
import java.util.List;

public class BookList {

    public static void main(String[] args) {

//        Создание списков.
        List<Book> bookList = new ArrayList<>();
        List<Book> bookList01 = new ArrayList<>( 20 );
        ((ArrayList<Book>) bookList).ensureCapacity( 10 );
        System.out.println();


//        Задачи на вставку элемента.
        Book kovi, bloh, shornig, macCormick, vijay, bauer, kousen;
        bookList.add( kovi = new Book( "7 навыков высокоэффективных людей.", "Кови", 387 ) );
        bookList.add( bloh = new Book( "Java. Эффективное программирование.", "Блох Дж.", 219 ) );
        bookList.add( shornig = new Book( "PostgreSQL 11. Мастерство разработки.", "Кови", 352 ) );
        bookList.add( macCormick = new Book( "Девять алгоритмов, которые изменили мир.", "Дж. Маккормик", 236 ) );
        bookList.add( vijay = new Book( "Предметно-ориентированное проектирование в Enterprise Java.", "Виджей Наир", 306 ) );

//        System.out.println( "bookList = " + bookList );

        bookList.add( 2, bauer = new Book( "Java Persistence API и Hibernate.", "Бауэр К., Кинг Г., Грегори Г.", 632 ) );
        bookList.add( 0, kousen = new Book( "Современный Java: рецепты программирования.", "Кен Коузен", 274 ) );

        System.out.println( "bookList = " + bookList );


        System.out.println( "bookList01.addAll( bookList ) = " + bookList01.addAll( bookList ) );
        System.out.println( "bookList01 = " + bookList01 );
        System.out.println();

//        for (int i = 0; i < bookList.size(); i++) {
//            bookList01.add( i, bookList.get( i ) );
//        }
//        System.out.println( "bookList01 = " + bookList01 );


//        Получить элемент по индексу.
        Book book00 = bookList01.get( 0 );
        Book book01 = bookList01.get( bookList01.size() - 1 );
        System.out.println( "book00 = " + book00 );
        System.out.println( "book01 = " + book01 );
        System.out.println();

//        Задачи на удаление элементов.
        bookList01.remove( vijay );
        System.out.println( "bookList01 = " + bookList01 );
        bookList01.remove( bookList01.size() - 1 );
        System.out.println( "bookList01 = " + bookList01 );
        System.out.println();

//        Проверить наличие элемента.
        System.out.println( "bookList01.contains( shornig ) = " + bookList01.contains( shornig ) );
        System.out.println();

//        Вывод списка.
        System.out.print( "List:" );
        for (Book List : bookList
        ) {
            System.out.println( "Book{" + List.getTitle() + ", " + List.getAuthor() + ", " + List.getNumberOfPages() + "}" );
        }


    }
}
