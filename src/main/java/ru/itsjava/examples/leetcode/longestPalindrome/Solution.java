package ru.itsjava.examples.leetcode.longestPalindrome;

public class Solution {
    public static String longestPalindrome(String s) {
        String longestPalindrome = null;
        char[] chars = s.toCharArray();
        int maxLength = 0;
        if (chars.length == 1) {
            longestPalindrome = s;
        } else {
            for (int i = 0; i < chars.length - 1; i++) {
                int length = 0;
                if (maxLength > s.substring( i, chars.length ).length()) {
                    break;
                }
                for (int k = i + 1; k < chars.length; k++) {
                    if (palindrome( s.substring( i, k + 1 ) )) {
                        length = s.substring( i, k ).length();
                    }
                    if (length > maxLength) {
                        longestPalindrome = s.substring( i, k + 1 );
                        maxLength = length;
                    }
                }
            }
        }
        if (longestPalindrome == null) {
            longestPalindrome = String.valueOf( chars[0] );
        }
        System.out.println( longestPalindrome );
        return longestPalindrome;
    }

    private static boolean palindrome(String s) {
        boolean palidrome = false;
        int j = s.length();
        for (int i = 0; i < s.length(); i++, j--) {
            if (s.charAt( i ) == s.charAt( j - 1 )) {
                palidrome = true;
            } else {
                palidrome = false;
                break;
            }
        }
        return palidrome;
    }



    public static void main(String[] args) {
        longestPalindrome( "aaabbbbnnvnvoijrijgvasdm[   oeeoeeomvvvvvvvvvvvvwerijfkwamf" );
    }
}
