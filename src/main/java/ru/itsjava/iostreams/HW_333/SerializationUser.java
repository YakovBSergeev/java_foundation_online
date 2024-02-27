package ru.itsjava.iostreams.HW_333;

import java.io.*;


public class SerializationUser {
    public static void main(String[] args) {
        User user = new User( "GFGFJ", "Thh@898" );

        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream( "src/main/resources/user.out" ) )) {
            outputStream.writeObject( user );
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream( "src/main/resources/user.out" ) )) {
            Object obj = inputStream.readObject();
            User userDeserialization = (User) obj;
            System.out.println( "obj = " + obj );
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}