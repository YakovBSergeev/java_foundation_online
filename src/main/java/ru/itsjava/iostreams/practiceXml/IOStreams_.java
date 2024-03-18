package ru.itsjava.iostreams.practiceXml;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static ru.itsjava.iostreams.practiceXml.StringToInt.stringToIntM;

public class IOStreams_ {

    public static void main(String[] args) throws IOException {

        File file = new File( "src/main/resources/Ценовые заявки (01.03.2024).xml" );
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
        int hour = 0;

        try (BufferedReader reader = new BufferedReader( new InputStreamReader( new FileInputStream( file ), StandardCharsets.UTF_8 ) )) {
            String input;
            while ((input = reader.readLine()) != null) {
                if (input.contains( "date" )) {
                    date = (input.substring( input.indexOf( ">" ) + 1, input.lastIndexOf( "<" ) ));
                }
                file01.add( input );
            }
            System.out.println( "date: " + date );
            System.out.println();

        } catch (FileNotFoundException e) {
            throw new RuntimeException( e );
        } catch (IOException e) {
            throw new RuntimeException( e );
        }

        for (int i = 0; i < file01.lastIndexOf( "  </Vsvgo>" ); i++) {
            if (file01.get( i ).contains( "Rge code=" )) {
                Rge = file01.get( i ).substring( file01.get( i ).indexOf( "\"" ) + 1, file01.get( i ).lastIndexOf( "\" " ) );
                Rge_name = file01.get( i ).substring( file01.get( i ).lastIndexOf( "=\"" ) + 2, file01.get( i ).lastIndexOf( "\"" ) );
            }
            if (file01.get( i ).contains( "ats_group" )) {
                ats_group = file01.get( i ).substring( file01.get( i ).indexOf( ">" ) + 1, file01.get( i ).lastIndexOf( "<" ) );
            }
            if (file01.get( i ).contains( "ego_in_group" )) {
                ego_in_group = file01.get( i ).substring( file01.get( i ).indexOf( ">" ) + 1, file01.get( i ).lastIndexOf( "<" ) );
            }

            if (file01.get( i ).contains( "hour number=" ) &&
                    (stringToInt( file01.get( i ).substring( file01.get( i ).indexOf( "\"" ) + 1, file01.get( i ).lastIndexOf( "\"" ) ) ) == hour)) {

                vsvgoP0.add( file01.get( i + 3 ).substring( file01.get( i + 3 ).indexOf( ">" ) + 1, file01.get( i + 3 ).lastIndexOf( "<" ) ) );
                vsvgoC0.add( file01.get( i + 4 ).substring( file01.get( i + 4 ).indexOf( ">" ) + 1, file01.get( i + 4 ).lastIndexOf( "<" ) ) );
                vsvgoP1.add( file01.get( i + 5 ).substring( file01.get( i + 5 ).indexOf( ">" ) + 1, file01.get( i + 5 ).lastIndexOf( "<" ) ) );
                vsvgoC1.add( file01.get( i + 6 ).substring( file01.get( i + 6 ).indexOf( ">" ) + 1, file01.get( i + 6 ).lastIndexOf( "<" ) ) );
                vsvgoP2.add( file01.get( i + 7 ).substring( file01.get( i + 7 ).indexOf( ">" ) + 1, file01.get( i + 7 ).lastIndexOf( "<" ) ) );
                vsvgoC2.add( file01.get( i + 8 ).substring( file01.get( i + 8 ).indexOf( ">" ) + 1, file01.get( i + 8 ).lastIndexOf( "<" ) ) );
                vsvgoCOn.add( file01.get( i + 9 ).substring( file01.get( i + 9 ).indexOf( ">" ) + 1, file01.get( i + 9 ).lastIndexOf( "<" ) ) );

                hour++;
            }
        }
        hour = 0;
        System.out.println( "Код РГЕ: " + Rge );
        System.out.println( "Имя РГЕ: " + Rge_name );
        System.out.println( "ats_group: " + ats_group );
        System.out.println( "Номер блока: " + ego_in_group );
        System.out.println( "vsvgoP0 = " + vsvgoP0 );
        System.out.println( "vsvgoC0 = " + vsvgoC0 );
        System.out.println( "vsvgoP1 = " + vsvgoP1 );
        System.out.println( "vsvgoC1 = " + vsvgoC1 );
        System.out.println( "vsvgoP2 = " + vsvgoP2 );
        System.out.println( "vsvgoC2 = " + vsvgoC2 );
        System.out.println( "vsvgoCOn = " + vsvgoCOn );

        for (int i = file01.indexOf( "  <RsvBr>" ); i < file01.lastIndexOf( "  </RsvBr>" ); i++) {
            if (file01.get( i ).contains( "Gtp code=" )) {
                Gtp = file01.get( i ).substring( file01.get( i ).indexOf( "\"" ) + 1, file01.get( i ).indexOf( "\"" ) + 9 );
                Gtp_name = file01.get( i ).substring( file01.get( i ).lastIndexOf( "=" ) + 2, file01.get( i ).lastIndexOf( "\"" ) );
            }
            if (file01.get( i ).contains( "hour number=" ) &&
                    (stringToIntM( file01.get( i ).substring( file01.get( i ).indexOf( "\"" ) + 1, file01.get( i ).lastIndexOf( "\"" ) ) ) == hour)) {
                rsvBrP0.add( file01.get( i + 1 ).substring( file01.get( i + 1 ).indexOf( ">" ) + 1, file01.get( i + 1 ).lastIndexOf( "<" ) ) );
                rsvBrC0.add( file01.get( i + 2 ).substring( file01.get( i + 2 ).indexOf( ">" ) + 1, file01.get( i + 2 ).lastIndexOf( "<" ) ) );
                rsvBrP1.add( file01.get( i + 3 ).substring( file01.get( i + 3 ).indexOf( ">" ) + 1, file01.get( i + 3 ).lastIndexOf( "<" ) ) );
                rsvBrC1.add( file01.get( i + 4 ).substring( file01.get( i + 4 ).indexOf( ">" ) + 1, file01.get( i + 4 ).lastIndexOf( "<" ) ) );
                rsvBrP2.add( file01.get( i + 5 ).substring( file01.get( i + 5 ).indexOf( ">" ) + 1, file01.get( i + 5 ).lastIndexOf( "<" ) ) );
                rsvBrC2.add( file01.get( i + 6 ).substring( file01.get( i + 6 ).indexOf( ">" ) + 1, file01.get( i + 6 ).lastIndexOf( "<" ) ) );
                modification.add( file01.get( i + 7 ).substring( file01.get( i + 7 ).indexOf( ">" ) + 1, file01.get( i + 7 ).lastIndexOf( "<" ) ) );
                ocpu.add( file01.get( i + 8 ).substring( file01.get( i + 8 ).indexOf( ">" ) + 1, file01.get( i + 8 ).lastIndexOf( "<" ) ) );
                ocps.add( file01.get( i + 9 ).substring( file01.get( i + 9 ).indexOf( ">" ) + 1, file01.get( i + 9 ).lastIndexOf( "<" ) ) );

                hour++;
            }

        }
        System.out.println();
        System.out.println( "Код ГТП: " + Gtp );
        System.out.println( "Наименование ГТП: " + Gtp_name );
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
    }

    public static int stringToInt(String s) {
        try {
            return Integer.parseInt( s );
        } catch (NumberFormatException n) {
            System.out.println( n.getMessage() );
            return -1;
        }
    }

}

