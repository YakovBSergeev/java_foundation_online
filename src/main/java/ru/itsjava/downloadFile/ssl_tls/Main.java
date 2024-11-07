package ru.itsjava.downloadFile.ssl_tls;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.CertificateException;

public class Main {
    public static void main(String[] args) throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, KeyManagementException {

        System.out.println("Keystore: " +
                (System.getProperty("javax.net.ssl.keyStore") != null ? System.getProperty("javax.net.ssl.keyStore") : KeyStore.getDefaultType() + " находится в " + System.getProperty("java.home") + "/lib/security/cacerts"));
        System.out.println("Пароль: " +
                (System.getProperty("javax.net.ssl.keyStorePassword") != null ? System.getProperty("javax.net.ssl.keyStorePassword") : "Changeit (по умолчанию)"));
        System.out.println( System.getProperty( "javax.net.ssl.keyStorePassword" ) );
        System.out.println( System.getProperty( "javax.net.ssl.trustStore" ) );


////Получить путь к файлу truststore и пароль:
//        String trustStorePath = System.getProperty("javax.net.ssl.trustStore", "C:/Program Files/Java/jdk-17/lib/security/cacerts");
//        String trustStorePassword = System.getProperty("javax.net.ssl.trustStorePassword", "changeit");
////Загрузите truststore:
//        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
//        System.out.println( KeyStore.getInstance( KeyStore.getDefaultType() ) );
//        FileInputStream trustStoreStream = new FileInputStream(trustStorePath);
//        trustStore.load(trustStoreStream, trustStorePassword.toCharArray());
////Создайте TrustManagerFactory:
//        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance( TrustManagerFactory.getDefaultAlgorithm());
//        trustManagerFactory.init(trustStore);
////Создайте SSLContext:
//        SSLContext sslContext = SSLContext.getInstance("TLS");
//        sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
////        Установите SSLContext по умолчанию:
//        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

//        System.out.println("javax.net.ssl.trustStore = " + trustStore);



//        System.setProperty("javax.net.ssl.keyStoreType", "pkcs12");
//        System.setProperty("javax.net.ssl.trustStoreType", "jks");


//        System.setProperty("javax.net.ssl.keyStore", "keystore.jks");
//        System.setProperty("javax.net.ssl.trustStore", "cacerts.jks");
//        System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
//

    }
}



//keytool -importcert -trustcacerts -file "C:\Users\sergeev_yb\Desktop\_.np-sr.ru.crt" -alias npsr -keystore "C:\Program Files\Java\jdk-17/lib/security/cacerts"    - импорт сертификата в хранилище java
//C:\WINDOWS\system32>cd/ или //C:\WINDOWS\system32>cd ms   - переход в командной строке по каталогам
//C:\WINDOWS\system32>keytool вызов команд
//keytool -list -cacerts просмотр сертификатов
