package ru.itsjava.enums.money;

enum Coin {
    NICKEL( 5 ),   // constants must appear first
    DIME( 10 ),
    QUARTER( 25 ),
    DOLLAR( 100 ); // the semicolon is required
    private final int valueInPennies;

    Coin(int valueInPennies) {
        this.valueInPennies = valueInPennies;
    }

    int toCoins(int pennies) {
        return pennies / valueInPennies;
    }
}

public class Coins {
    public static void main(String[] args) {
        args = new String[]{"201"};
        if (args.length != 1) {
            System.err.println( "usage: java Coins amountInPennies" );
            return;
        }
        int pennies = Integer.parseInt( args[0] );
        for (int i = 0; i < Coin.values().length; i++)
            System.out.println( pennies + " pennies contains " +
                    Coin.values()[i].toCoins( pennies ) + " " +
                    Coin.values()[i].toString().toLowerCase() + "s" );
    }
}
