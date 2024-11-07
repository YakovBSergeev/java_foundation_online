package ru.itsjava.downloadFile;

import ru.itsjava.downloadFile.ssl_tls.SSLUtils;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DownloadFileJavaIO {
    public static void downLoadFromUrl_01(String URL, String FILE_NAME) throws Exception {
        try (InputStream in = new URL( URL ).openStream()) {
            Files.copy( in, new File( FILE_NAME ).toPath(), StandardCopyOption.REPLACE_EXISTING );
        } catch (
                IOException e) {
        }
    }

    public static void downLoadFromUrl_02(String URL, String FILE_NAME) throws Exception {
        try (BufferedInputStream in = new BufferedInputStream( new URL( URL ).openStream() );
             FileOutputStream fileOutputStream = new FileOutputStream( FILE_NAME )) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read( dataBuffer, 0, 1024 )) != -1) {
                fileOutputStream.write( dataBuffer, 0, bytesRead );
            }
        } catch (IOException e) {
            // handle exception
        }
    }

    public static void downLoadFromUrl_03(String URL, String FILE_NAME) throws Exception {
        URI url = URI.create( URL );
        Path path = Path.of( FILE_NAME ); // output file path
        HttpClient.newHttpClient().send( HttpRequest.newBuilder( url ).build(), HttpResponse.BodyHandlers.ofFile( path ) );
    }

    public void downLoadFromUrl_04(String URL, String FILE_NAME) throws IOException {
        try (InputStream in = URI.create( URL ).toURL().openStream()) {
            Files.copy( in, Paths.get( FILE_NAME ), StandardCopyOption.REPLACE_EXISTING );
        }
    }


    public static void main(String[] args) throws Exception {
        SSLUtils.disableCertificateValidation();
        DownloadFileJavaIO downloadFileJavaIO = new DownloadFileJavaIO();



//        downLoadFromUrl_01( "https://www.np-sr.ru/sites/default/files/2024-10-01_informaciya_o_moderniziruemyh_generiruyushchih_obektah_v_ncz.xlsx", "c:/Users/sergeev_yb/Downloads/1.xlsx" );
//        downLoadFromUrl_02( "https://www.np-sr.ru/sites/default/files/2024-10-01_informaciya_o_moderniziruemyh_generiruyushchih_obektah_v_ncz.xlsx", "c:/Users/sergeev_yb/Downloads/1.xlsx" );
//        downLoadFromUrl_03( "https://www.np-sr.ru/sites/default/files/2024-10-01_informaciya_o_moderniziruemyh_generiruyushchih_obektah_v_ncz.xlsx", "c:/Users/sergeev_yb/Downloads/1.xlsx" );
//        downloadFileJavaIO.downLoadFromUrl_04( "https://www.np-sr.ru/sites/default/files/2024-10-01_informaciya_o_moderniziruemyh_generiruyushchih_obektah_v_ncz.xlsx", "c:/Users/sergeev_yb/Downloads/Test/1.xlsx" );
//        downloadFileJavaIO.downLoadFromUrl_04( "https://www.atsenergo.ru/nreport?fid=25C746DB6C1002C2E0630A4900E1F537&region=sib&zip=1", "c:/Users/sergeev_yb/Downloads/1.zip" );

    }
}
// https://www.atsenergo.ru/nreport?fid=258AE62DCCC602A4E0630A4900E13455&region=sib
//https://www.np-sr.ru/sites/default/files/2024-10-01_informaciya_o_moderniziruemyh_generiruyushchih_obektah_v_ncz.xlsx
//https://www.atsenergo.ru/nreport?fid=2366B9146AA1022CE0630A4900E1E1FD&region=eur
//https://www.atsenergo.ru/nreport?fid=25C755389C500464E0630A4900E10C5C&region=eur
//https://www.atsenergo.ru/nreport?fid=25C746DB6C1002C2E0630A4900E1F537&region=sib&zip=1