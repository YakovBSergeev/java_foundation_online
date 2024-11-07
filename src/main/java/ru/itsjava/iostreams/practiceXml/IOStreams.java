package ru.itsjava.iostreams.practiceXml;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class IOStreams {

    public static void main(String[] args) throws IOException {

        String path = "src/main/resources/Ценовые заявки (01.03.2024).xml";
        File file = new File( path );

        List<String> file01 = new ArrayList<>();
        List<String> vsvgoP0 = new ArrayList<>();
        List<String> vsvgoC0 = new ArrayList<>();
        List<String> vsvgoP1 = new ArrayList<>();
        List<String> vsvgoC1 = new ArrayList<>();
        List<String> vsvgoP2 = new ArrayList<>();
        List<String> vsvgoC2 = new ArrayList<>();
        List<String> vsvgoCOn = new ArrayList<>();
        List<String> rsvBrP0 = new ArrayList<>();
        List<String> rsvBrC0 = new ArrayList<>();
        List<String> rsvBrP1 = new ArrayList<>();
        List<String> rsvBrC1 = new ArrayList<>();
        List<String> rsvBrP2 = new ArrayList<>();
        List<String> rsvBrC2 = new ArrayList<>();
        List<String> modification = new ArrayList<>();
        List<String> ocps = new ArrayList<>();
        List<String> ocpu = new ArrayList<>();
        String date = null;
        String Rge = null;
        String Rge_name = null;
        String ats_group = null;
        String ego_in_group = null;
        String Gtp = null;
        String Gtp_name = null;

        try (BufferedReader reader = new BufferedReader( new InputStreamReader( new FileInputStream( file ), StandardCharsets.UTF_8 ) )) {
            String input;
            while ((input = reader.readLine()) != null) {
                if (input.contains( "date" )) {
                    date = (input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) ));
                }
                if (input.contains( "Rge code=" )) {
                    Rge = input.substring( input.indexOf( "\"" ) + 1, input.indexOf( "\"" ) + 6 );
                    Rge_name = input.substring( input.indexOf( "name=\"" ) + 6, input.lastIndexOf( "\"" ) );
                }
                if (input.contains( "ats_group" )) {
                    ats_group = input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) );
                }
                if (input.contains( "ego_in_group" )) {
                    ego_in_group = input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) );
                }
                if (input.contains( "Gtp code=" )) {
                    Gtp = input.substring( input.indexOf( "\"" ) + 1, input.indexOf( "\"" ) + 9 );
                    Gtp_name = input.substring( input.lastIndexOf( "=" ) + 2, input.lastIndexOf( "\"" ) );
                }

                if (input.contains( "p_0" ) && Gtp == null) {
                    vsvgoP0.add( input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) ) );
                }
                if (input.contains( "c_0" ) && Gtp == null) {
                    vsvgoC0.add( input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) ) );
                }
                if (input.contains( "p_1" ) && Gtp == null) {
                    vsvgoP1.add( input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) ) );
                }
                if (input.contains( "c_1" ) && Gtp == null) {
                    vsvgoC1.add( input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) ) );
                }
                if (input.contains( "p_2" ) && Gtp == null) {
                    vsvgoP2.add( input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) ) );
                }
                if (input.contains( "c_2" ) && Gtp == null) {
                    vsvgoC2.add( input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) ) );
                }
                if (input.contains( "c_on" ) && Gtp == null) {
                    vsvgoCOn.add( input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) ) );
                }

                if (input.contains( "p_0" ) && Gtp != null) {
                    rsvBrP0.add( input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) ) );
                }
                if (input.contains( "c_0" ) && Gtp != null) {
                    rsvBrC0.add( input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) ) );
                }
                if (input.contains( "p_1" ) && Gtp != null) {
                    rsvBrP1.add( input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) ) );
                }
                if (input.contains( "c_1" ) && Gtp != null) {
                    rsvBrC1.add( input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) ) );
                }
                if (input.contains( "p_2" ) && Gtp != null) {
                    rsvBrP2.add( input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) ) );
                }
                if (input.contains( "c_2" ) && Gtp != null) {
                    rsvBrC2.add( input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) ) );
                }
                if (input.contains( "modification" ) && Gtp != null) {
                    modification.add( input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) ) );
                }
                if (input.contains( "OCPU" ) && Gtp != null) {
                    ocpu.add( input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) ) );
                }
                if (input.contains( "OCPS" ) && Gtp != null) {
                    ocps.add( input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) ) );
                }

                file01.add( input );
            }
            System.out.println();
            System.out.println( "date: " + date );
            System.out.println( "Код РГЕ:" + Rge );
            System.out.println( "Имя РГЕ: " + Rge_name );
            System.out.println( "ats_group = " + ats_group );
            System.out.println( "Номер блока: " + ego_in_group );
            System.out.println();
            System.out.println( "vsvgoP0 = " + vsvgoP0 );
            System.out.println( "vsvgoC0 = " + vsvgoC0 );
            System.out.println( "vsvgoP1 = " + vsvgoP1 );
            System.out.println( "vsvgoC1 = " + vsvgoC1 );
            System.out.println( "vsvgoP2 = " + vsvgoP2 );
            System.out.println( "vsvgoC2 = " + vsvgoC2 );
            System.out.println( "vsvgoCOn = " + vsvgoCOn );
            System.out.println();
            System.out.println( "Код ГТП: " + Gtp );
            System.out.println( "Наименование ГТП: " + Gtp_name );
            System.out.println();
            System.out.println( "rsvBrP0 = " + rsvBrP0 );
            System.out.println( "rsvBrC0 = " + rsvBrC0 );
            System.out.println( "rsvBrP1 = " + rsvBrP1 );
            System.out.println( "rsvBrC1 = " + rsvBrC1 );
            System.out.println( "rsvBrP2 = " + rsvBrP2 );
            System.out.println( "rsvBrC2 = " + rsvBrC2 );
            System.out.println( "modification = " + modification );
            System.out.println( "ocpu = " + ocpu );
            System.out.println( "ocps = " + ocps );
            System.out.println();
            System.out.println( "file01 = " + file01 );

        } catch (FileNotFoundException e) {
            throw new RuntimeException( e );
        } catch (IOException e) {
            throw new RuntimeException( e );
        }
    }
}

