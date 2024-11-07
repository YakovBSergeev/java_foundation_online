package ru.itsjava.downloadFile.workTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathCreate {
    private final String date;

    public PathCreate(String date) {
        this.date = date;
    }

    public String pathCreate() throws IOException {
        Path path = Paths.get( "c:/Users/sergeev_yb/Downloads/Test/" + date.substring( 0, 4 ) );
        Path path1;
        Path path2;
        if (!Files.exists( path )) {
            Files.createDirectory( path );
        }
        path1 = Paths.get( path + "/" + date.substring( 4, 6 ) );
        if (!Files.exists( path1 )) {
            Files.createDirectory( path1 );
        }
        path2 = Paths.get( path + "/" + date.substring( 4, 6 ) + "/" + date.substring( 6, 8 ) );
        if (!Files.exists( path2 )) {
            Files.createDirectory( path2 );
        }
        return String.valueOf( path2 );
    }
}

