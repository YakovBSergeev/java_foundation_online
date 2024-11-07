package ru.itsjava.examples.leetcode.longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Solution {

    public static int lengthOfLongestSubstringSolution(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        long startTime = System.nanoTime();
        for (int right = 0; right < n; right++) {
            if (!charSet.contains( s.charAt( right ) )) {
                charSet.add( s.charAt( right ) );
                maxLength = Math.max( maxLength, right - left + 1 );
            } else {
                while (charSet.contains( s.charAt( right ) )) {
                    charSet.remove( s.charAt( left ) );
                    left++;
                }
                charSet.add( s.charAt( right ) );
            }
        }
        System.out.println( System.nanoTime() - startTime );
        return maxLength;
    }

    public static void lengthOfLongestSubstring(String s) {
        int repeat = 0;
        Set<Character> hashSet = new HashSet();
        StringBuilder stringBuilderLarge = new StringBuilder();
        long startTime = System.nanoTime();
        for (int k = 0; k < s.length(); k++) {
            int count = 0;
            StringBuilder stringBuilder = new StringBuilder();
            if (s.length() - k >= repeat) {
                for (int i = k; i < s.length(); i++) {
                    if (hashSet.add( s.charAt( i ) )) {
                        count++;
                        stringBuilder.append( s.charAt( i ) );
                    } else {
                        hashSet.clear();
                        break;
                    }
                    repeat = Math.max( count, repeat );
                }
            }
            if (stringBuilder.length() > stringBuilderLarge.length()) {
                stringBuilderLarge = stringBuilder;
            }
        }
        System.out.println( System.nanoTime() - startTime );
        System.out.println( stringBuilderLarge );
        System.out.println( repeat );
    }

    public static void main(String[] args) {
        Random r = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            char c = (char) (r.nextInt( 30) + 'a');
            stringBuilder.append( c );
        }
        String s1 = String.valueOf( stringBuilder );
//        String s = "pwwkewsrgwe  wqretlkqwotkq[rtg234d56gh4ws;hkshey3565+6aw5f6wae+9wae+98fgtwfg5+aswt9+q34twe'.fim3t vwfle";
        System.out.println( lengthOfLongestSubstringSolution( s1 ) );
        lengthOfLongestSubstring( s1 );
//        System.out.println( s1 );
        System.out.println( 1234766785 % 100 );
        System.out.println( 1234766785 / 10 );
    }
}