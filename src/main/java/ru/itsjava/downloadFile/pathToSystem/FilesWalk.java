package ru.itsjava.downloadFile.pathToSystem;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class FilesWalk extends SimpleFileVisitor<Path> {
    public static void main(String[] args) {
        int maxDepth = 3;
        try (Stream<Path> files = Files.walk( Path.of( "c:/Users/sergeev_yb/Downloads/Test/" ), maxDepth, FileVisitOption.FOLLOW_LINKS )) {
            files.forEach( System.out::println );
        } catch (IOException e) {
            throw new RuntimeException( e );
        }


    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println( file ); // Привет, файл!
        return FileVisitResult.CONTINUE;
    }
}
