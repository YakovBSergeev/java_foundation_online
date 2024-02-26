package ru.itsjava.iostreams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOStreamsPracticeHW_332 {

    public static void main(String[] args) {

        File file = new File( "src/main/resources/file.txt" );
        File fileNext = new File( "src/main/resources/fileNext.txt" );
        List<String> file01 = new ArrayList<>();
        List<String> file02 = new ArrayList<>();

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
            while ((input = reader.readLine()) != null) {
                System.out.println( "reader.readLine() = " + input );
                file02.add( input );
            }
            System.out.println( "file02 = " + file02 );
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try (PrintWriter printWriter = new PrintWriter( file )) {
            for (int i = 0; i < file02.size(); i++) {
                printWriter.println( file02.get( i ) );
            }
            file02.clear();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader( new FileReader( file ) )) {
            String input;
            while ((input = reader.readLine()) != null) {
                System.out.println( "reader.readLine() = " + input );
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try (PrintWriter printWriter = new PrintWriter( fileNext )) {
            for (int i = 0; i < file01.size(); i++) {
                printWriter.println( file01.get( i ) );
            }
            file01.clear();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader( new FileReader( fileNext ) )) {
            String input;
            while ((input = reader.readLine()) != null) {
                System.out.println( "reader.readLine() = " + input );
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        System.out.println( "file01 = " + file01 );
        System.out.println( "file02 = " + file02 );

    }
}
