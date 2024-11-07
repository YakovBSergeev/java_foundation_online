package ru.itsjava.examples.leetcode.regularExpressionMatching;

import java.util.Arrays;

enum Result {
    TRUE, FALSE
}

public class Solution {
    public static boolean isMatch(String s, String p) {
        boolean match = false;
        char[] one = s.toCharArray();
        char[] next = p.toCharArray();
        for (int j = 0; j < next.length; j++) {
            if (one.length > next.length - j) {
                break;
            }
            for (int i = j; i < (j + one.length); i++) {
                if (next[i] == one[i - j] || next[i] == '.') {
                    match = true;
                } else if (i > 0 && ((next[i] == '*' && next[i - 1] == '.') ||
                        (one[i - j] == next[i - 1] && next[i] == '*'))) {
                    match = true;
                } else {
                    match = false;
                    break;
                }
            }
        }
        return match;
    }

    static Result[][] memo;

    public static boolean isMatchBest(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp( 0, 0, text, pattern );
    }

    public static boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()) {
            ans = i == text.length();
        } else {
            boolean first_match = (i < text.length() &&
                    (pattern.charAt( j ) == text.charAt( i ) ||
                            pattern.charAt( j ) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt( j + 1 ) == '*') {
                ans = (dp( i, j + 2, text, pattern ) ||
                        first_match && dp( i + 1, j, text, pattern ));
            } else {
                ans = first_match && dp( i + 1, j + 1, text, pattern );
            }
        }
        System.out.println( Arrays.deepToString( memo ) );
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;

    }

    public static void main(String[] args) {
//        System.out.println( isMatch( "aaa", "aaaaa" ) );
        System.out.println( isMatchBest( "a", "a" ) );

    }
}
