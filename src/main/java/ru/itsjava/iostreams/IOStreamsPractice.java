package ru.itsjava.iostreams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOStreamsPractice {

    public static void main(String[] args) {
//        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            String input = console.readLine();
//            System.out.println("Ваш input равен " + input);
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        } finally {
//            try {
//                console.close();
//            } catch (IOException exception) {
//                exception.printStackTrace();
//            }
//        }

//        //try with resources
//        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
//            String input = console.readLine();
//            System.out.println("Ваш input равен " + input);
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }

        File file = new File( "src/main/resources/file.txt" );
        File fileNext = new File( "src/main/resources/fileNext.txt" );

        try (PrintWriter printWriter = new PrintWriter( file )) {
            printWriter.println( "Строка1" );
            printWriter.println( "Строка2" );
            printWriter.println( "Строка3" );
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        try (PrintWriter printWriter = new PrintWriter( fileNext )) {
            printWriter.println( "Строка4" );
            printWriter.println( "Строка5" );
            printWriter.println( "Строка6" );
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }


        try (BufferedReader reader = new BufferedReader( new FileReader( file ) )) {
            String input;
            List<String> file01 = new ArrayList<>();
            while ((input = reader.readLine()) != null) {
                System.out.println( "reader.readLine() = " + input );
                file01.add( input );
            }
            System.out.println( "file01 = " + file01 );
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader( new FileReader( fileNext ) )) {
            String input;
            List<String> file02 = new ArrayList<>();
            while ((input = reader.readLine()) != null) {
                System.out.println( "reader.readLine() = " + input );
                file02.add( input );
            }
            System.out.println( "file01 = " + file02 );
        } catch (IOException exception) {
            exception.printStackTrace();
        }



    }
}
