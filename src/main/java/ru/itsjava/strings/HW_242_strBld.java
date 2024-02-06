package ru.itsjava.strings;

public class HW_242_strBld {
    public static void main(String[] args) {

        StringBuilder strBld = new StringBuilder();
        StringBuilder strBld1 = new StringBuilder( 12 );
        StringBuilder strBld2 = new StringBuilder( "Это подстрока" );
        String str = null;
        StringBuilder strBld3 = new StringBuilder().appendCodePoint( 128640 );//добавляет строковое представление аргумента.

        System.out.println( "strBld.capacity = " + strBld.capacity() ); //возвращает емкость объекта.
        System.out.println( "strBld2.capacity = " + strBld2.capacity() ); //возвращает емкость объекта.
        System.out.println( "strBld1.length() = " + strBld1.length() );//возвращает длину объекта.
        System.out.println( "strBld2.append( strBld1 ) = " + strBld2.append( strBld1 ) );//добавляет строковое представление объекта к строке.
        System.out.println( "strBld2.capacity() = " + strBld2.capacity() );//возвращает емкость объекта.
        System.out.println( "strBld2.insert( 4, str) = " + strBld2.insert( 4, str ) );// вставляет строковое представление объета в строку начиная суказанного индекса.
        System.out.println( "strBld2.delete( 4,8 ) = " + strBld2.delete( 4, 8 ) );// удаляет символы из строки в диапазоне указанных индексов.
        System.out.println( "strBld3 = " + strBld3 );
        System.out.println( "strBld3.charAt( 1 ) = " + strBld3.charAt( 1 ) );//возвращает значение символа объекта по указанному индексу.
        System.out.println( "strBld.compareTo( strBld1 ) = " + strBld.compareTo( strBld1 ) );//сравнивает два экземляра объекта исходя из лексиграфического представления.
        System.out.println( "strBld.equals( strBld1 ) = " + strBld.equals( strBld1 ) );//сравнивает объекты на совпадение элементов, хранящихся в памяти соответствующих ссылок.
        System.out.println( "strBld.hashCode(strBld1) = " + strBld.hashCode() );// возвращает хэшкод объекта.
        System.out.println( "strBld2.lastIndexOf( \"\" ) = " + strBld2.lastIndexOf( "о" ) );//возвращает индекс последней в строке указанноной подстроки.
        System.out.println( "strBld2.substring( 4 ) = " + strBld2.substring( 4 ) );//возвращает строку начиная с указанного индекса.
    }


}
