package ru.itsjava.examples.leetcode.addBinary;

public class Solution {
    public static String addBinary(String a, String b) {
        long time = System.nanoTime();
        if (a.length() > b.length()) {
            return addBinary( b, a );
        }
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        int next = 0;
        int[] bin1 = new int[a.length()];
        int[] bin2 = new int[b.length()];
        int[] bin3 = new int[b.length()];
        for (int i = a1.length, j = b1.length; j > 0; i--, j--) {
            if (i < 1) {
                bin2[j - 1] = Integer.parseInt( String.valueOf( b1[j - 1] ) );
                int i2 = bin2[j - 1];
                if (i2 + next != 2 && j != 1) {
                    bin2[j - 1] = (char) (i2 + next);
                    next = 0;
                } else if (i2 + next == 2 && j != 1) {
                    bin2[j - 1] = (char) (0);
                    next = 1;
                } else {
                    if (j == 1 && i2 + next != 2) {
                        bin2[0] = (char) (i2 + next);
                    } else {
                        System.arraycopy( bin2, 0, bin3, 0, bin2.length );
                        bin2 = new int[bin2.length + 1];
                        System.arraycopy( bin3, 0, bin2, 1, bin3.length );
                        bin2[0] = 1;
                        bin2[1] = 0;
                    }
                }
            } else if (i == 1 && j == 1) {
                bin1[i - 1] = Integer.parseInt( String.valueOf( a1[i - 1] ) );
                bin2[j - 1] = Integer.parseInt( String.valueOf( b1[j - 1] ) );
                int i1 = bin1[i - 1];
                int i2 = bin2[j - 1];
                if (i1 + i2 != 2 && next == 0 || i1 + i2 == 0 && next == 1) {
                    bin2[j - 1] = (char) (i1 + i2 + next);
                    next = 0;
                } else if (i1 + i2 == 2 && next == 0 || i1 + i2 == 1 && next == 1) {
                    System.arraycopy( bin2, 0, bin3, 0, bin2.length );
                    bin2 = new int[bin2.length + 1];
                    System.arraycopy( bin3, 0, bin2, 1, bin3.length );
                    bin2[0] = 1;
                    bin2[1] = 0;
                } else {
                    System.arraycopy( bin2, 0, bin3, 0, bin2.length );
                    bin2 = new int[bin2.length + 1];
                    System.arraycopy( bin3, 0, bin2, 1, bin3.length );
                    bin2[0] = 1;
                    bin2[1] = 1;
                }
            } else {
                bin1[i - 1] = Integer.parseInt( String.valueOf( a1[i - 1] ) );
                bin2[j - 1] = Integer.parseInt( String.valueOf( b1[j - 1] ) );
                int i1 = bin1[i - 1];
                int i2 = bin2[j - 1];
                if (i1 + i2 != 2 && next == 0 || i1 + i2 == 0 && next == 1) {
                    bin2[j - 1] = (char) (i1 + i2 + next);
                    next = 0;
                } else if (i1 + i2 == 2 && next == 0 || i1 + i2 == 1 && next == 1) {
                    bin2[j - 1] = (char) (0);
                    next = 1;
                } else {
                    bin2[j - 1] = (char) (1);
                    next = 1;
                }
            }
        }
        StringBuilder sB = new StringBuilder();
        for (int aa : bin2
        ) {
            sB.append( aa );
        }
        System.out.println(System.nanoTime()-time);
        return String.valueOf( sB );
    }

    public static String addBinaryBest(String a, String b) {
        long time = System.nanoTime();
        if (a.length() > b.length()) {
            return addBinary( b, a );
        }
        char[] ch = new char[b.length() + 1];
        int e = ch.length - 1;
        int carray = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                carray += (int) (a.charAt( i ) - '0');
                i--;
            }
            if (j >= 0) {
                carray += (int) (b.charAt( j ) - '0');
                j--;
            }
            ch[e--] = (char) ('0' + carray % 2);
            carray = carray / 2;
        }
        if (carray == 1) {
            ch[0] = '1';
            return new String( ch );
        }
        System.out.println(System.nanoTime()-time);
        return new String( ch, 1, ch.length - 1 );
    }

    public static void main(String[] args) {
//        System.out.println( addBinary( "1101010101010", "100101011" ) );
        System.out.println( addBinaryBest( "1101010101010", "100101011" ) );

        System.out.println((int)'0');
        System.out.println((int)'0'-'0');
        System.out.println((int)'1');
        System.out.println((int)'1'-'0');
    }
}
