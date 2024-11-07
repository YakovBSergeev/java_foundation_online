package ru.itsjava.examples.leetcode.reverseInteger;

public class Solution {
    public static int reverse(int x) {
        int rez = 0;
        while (x != 0) {
            int y = x % 10;
            x = x / 10;
            if (((long)rez * 10 + y) > Integer.MAX_VALUE || ((long)rez * 10 + y) < Integer.MIN_VALUE) {
                return 0;
            }
            rez = rez * 10 + y;

        }
        return rez;
    }

    public static void main(String[] args) {
        System.out.println( reverse( 1534236468 ) );
    }
}
