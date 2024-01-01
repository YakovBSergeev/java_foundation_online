package ru.itsjava.interfaces;

public class InterfacesPractice {

    public static void main(String[] args) {
        Creatable khotabich = new Gin();
        khotabich.createWish();

        Creatable badGin = new BadGin();
        badGin.createWish();

        khotabich.canYouCreateWish();
        badGin.canYouCreateWish();
    }
}
