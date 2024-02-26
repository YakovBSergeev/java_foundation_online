package ru.itsjava.iostreams;

import ru.itsjava.collections.maps.Man;

import java.io.*;

public class SerializationPractice {

    public static void main(String[] args) {
//        Man man = new Man("Vitalik");
//
//        try (ObjectOutputStream outputStream = new ObjectOutputStream(
//                new FileOutputStream("src/main/resources/man.out"))) {
//            outputStream.writeObject(man);
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }

        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("src/main/resources/man.out"))) {

            Object obj = inputStream.readObject();
            Man man = (Man) obj;
            System.out.println("man = " + man);
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }


    }
}
