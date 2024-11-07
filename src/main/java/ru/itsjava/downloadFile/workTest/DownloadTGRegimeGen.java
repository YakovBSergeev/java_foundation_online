package ru.itsjava.downloadFile.workTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DownloadTGRegimeGen {
    public static void main(String[] args) throws Exception {


        Scanner scanner = new Scanner( System.in );
        System.out.println( "Введите начальную дату yyyymmdd" );
        String dateStringStart = scanner.next();
        System.out.println( "Введите конечную дату yyyymmdd" );
        String dateStringEnd = scanner.next();
        long time = System.nanoTime();
        DateTimeFormatter yyyyMMdd = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate localDateStart = LocalDate.parse( dateStringStart, yyyyMMdd );
        LocalDate localDateEnd = LocalDate.parse( dateStringEnd, yyyyMMdd );

        while (!localDateStart.isAfter( localDateEnd )) {
            dateStringStart = localDateStart.format( DateTimeFormatter.ofPattern( "yyyyMMdd" ) );
            PathCreate pathCreate = new PathCreate( dateStringStart );
            String day = pathCreate.pathCreate();
            DownloadPart downloadPart = new DownloadPart( dateStringStart, day );
            downloadPart.downloadPart();
            localDateStart = localDateStart.plusDays( 1 );
        }
        System.out.println( System.nanoTime() - time );
    }
}
