package ru.itsjava.downloadFile.readingDirectlyFromURL;

import ru.itsjava.downloadFile.ssl_tls.SSLUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class URLReader {
    public static void main(String[] args) throws Exception {

        SSLUtils.disableCertificateValidation();

        Scanner scanner = new Scanner( System.in );
        System.out.println( "Введите дату отчета yyyymmdd" );
        String date = scanner.next();

        URL url = new URL( "https://www.atsenergo.ru/nreport?access=public&rname=carana_sell_units&rdate=" + date + "&region=sib" );
        BufferedReader in = new BufferedReader(
                new InputStreamReader( url.openStream() ) );

        String inputLine;
        String[] str = new String[0];
        while ((inputLine = in.readLine()) != null) {
            str = inputLine.split( "<a" );
            for (String s : str
            ) {
                if (s.contains( "Опубликовано" ) && s.contains( "fid" )) {
                    System.out.println( s );
//                    String fid = s.substring( s.indexOf( "href=" ) + 6, s.indexOf( "href=" ) + 44 ) + s.substring( s.indexOf( "href=" ) + 48, s.indexOf( "href=" ) + 58 );
//                    System.out.println( fid );
//                    String name = s.substring( s.indexOf( ">" ) + 1, s.indexOf( ">" ) + 37 );
//                    System.out.println( name );
                }
            }
        }
        in.close();

    }
}
