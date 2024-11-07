package ru.itsjava.enums.enumsHW_346;

public class EnumHW_346 {
    public static void main(String[] args) {
        Days day0 = Days.Sunday;
        Days day1 = Days.Monday;

        System.out.println( day0.toString() );
        System.out.println( day1.getTranslate() );
        System.out.println( day1.name() );
        System.out.println( "day1.ordinal() = " + day1.ordinal() );

    }
}
