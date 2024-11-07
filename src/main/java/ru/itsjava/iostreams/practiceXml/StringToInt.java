package ru.itsjava.iostreams.practiceXml;

public class StringToInt {
    public static int stringToIntM(String s) {
        try {
            return Integer.parseInt( s );
        } catch (NumberFormatException n) {
            System.out.println( n.getMessage() );
            return -1;
        }
    }

}
