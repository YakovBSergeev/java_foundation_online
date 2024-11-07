package ru.itsjava.downloadFile.workTest;

import ru.itsjava.downloadFile.DownloadFileJavaIO;
import ru.itsjava.downloadFile.ssl_tls.SSLUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class DownloadPart {
    private final String date;
    private final String day;

    public DownloadPart(String date, String day) {
        this.date = date;
        this.day = day;
    }

    public void downloadPart() throws Exception {
        SSLUtils.disableCertificateValidation();
        DownloadFileJavaIO downloadFileJavaIO = new DownloadFileJavaIO();
        ArrayList<String> zone = new ArrayList<>();
        zone.add( "sib" );
        zone.add( "eur" );

        for (String string : zone) {

            URL url = new URL( "https://www.atsenergo.ru/nreport?access=public&rname=carana_sell_units&rdate=" + date + "&region=" + string );
            BufferedReader in = new BufferedReader(
                    new InputStreamReader( url.openStream() ) );

            String inputLine;
            String[] str = new String[0];
            while ((inputLine = in.readLine()) != null) {
                str = inputLine.split( "<a" );
                for (String s : str
                ) {
                    if (s.contains( "Опубликовано" ) && s.contains( "fid" )) {
//                    System.out.println( s );
                        String fid = s.substring( s.indexOf( "href=" ) + 6, s.indexOf( "href=" ) + 44 ) + s.substring( s.indexOf( "href=" ) + 48, s.indexOf( "href=" ) + 58 );
//                    System.out.println( fid );
                        String name = s.substring( s.indexOf( ">" ) + 1, s.indexOf( ">" ) + 37 );
//                    System.out.println( name );
                        downloadFileJavaIO.downLoadFromUrl_04( "https://www.atsenergo.ru/nreport" + fid, day + "/" + name );
                    }
                }
            }
            in.close();
        }

    }
}
