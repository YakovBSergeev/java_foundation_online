package ru.itsjava.iostreams;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class IOStreams_ {

    public static void main(String[] args) throws IOException{

        File file = new File( "src/main/resources/Ценовые заявки (01.03.2024).xml" );
        List<String> file01 = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader( new InputStreamReader(new FileInputStream( file ), StandardCharsets.UTF_8 ))) {
            String input;
            while ((input = reader.readLine()) != null) {
                System.out.println( "reader.readLine() = " + input );
                file01.add( input );
            }
            System.out.println( "file01 = " + file01 );

        } catch (FileNotFoundException e) {
            throw new RuntimeException( e );
        } catch (IOException e) {
            throw new RuntimeException( e );
        }


    }
}
