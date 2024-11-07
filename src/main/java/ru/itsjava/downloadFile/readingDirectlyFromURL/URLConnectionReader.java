package ru.itsjava.downloadFile.readingDirectlyFromURL;

import ru.itsjava.downloadFile.ssl_tls.SSLUtils;

import java.net.*;
import java.io.*;

public class URLConnectionReader {
    SSLUtils sslUtils = new SSLUtils();

    public static void main(String[] args) throws Exception {

        SSLUtils.disableCertificateValidation();

        URL url = new URL("https://www.atsenergo.ru/nreport?access=public&rname=carana_sell_units&rdate=20241101&region=sib");
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}
