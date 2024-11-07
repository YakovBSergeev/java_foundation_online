package ru.itsjava.downloadFile.ssl_tls;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class SignVerifyJar
{
    private final  String jar_path = "D:/certificate-reader.jar";

    SignVerifyJar() {
        try {
            JarFile jfile = new JarFile(jar_path);
            System.out.println("verify = " + jarVerify(jfile));
        } catch (IOException e) {}
    }
    private static boolean jarVerify(JarFile jar)
            throws IOException {
        Enumeration<JarEntry> entries = jar.entries();
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            System.out.println("entry.name = " + entry.getName());
            try {
                byte[] buffer = new byte[16384];
                InputStream is = jar.getInputStream(entry);
                while ((is.read(buffer,0,buffer.length)) != -1){
                    // Только чтение, которое может вызвать
                    // SecurityException, если цифровая подпись
                    // нарушена.
                }
            } catch (SecurityException se) {
                System.err.println("SecurityException : " +
                        se.getMessage());
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException
    {
        new SignVerifyJar();
        System.exit(0);
    }
}
