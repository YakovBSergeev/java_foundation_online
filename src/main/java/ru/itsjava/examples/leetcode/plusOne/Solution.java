package ru.itsjava.examples.leetcode.plusOne;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;

@Data
public class Solution {
    public static int[] plusOne(int[] digits) {
        ArrayList<Integer> finaly = new ArrayList<Integer>();
        int range = 0;
        for (int i = digits.length - 1; i > -1; i--) {
            if (digits[i] == 9 && range != -1) {
                digits[i] = 0;
                range = 1;
            } else if (range != -1) {
                digits[i] = digits[i] + 1;
                range = -1;
            }
            if (i == 0 && range == 1) {
                finaly.add( 0 );
                finaly.add( 1 );
            } else {
                finaly.add( digits[i] );
            }
        }
        Collections.reverse( finaly );
        return finaly.stream().mapToInt( i -> i ).toArray();
    }

    public static int[] plusOneBest(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 9, 9};
        plusOne( arr );
        for (int a:arr
             ) {
            System.out.print( a + " " );

        }
        plusOneBest( arr );
        for (int a:arr
        ) {
            System.out.print( a + " " );

        }
    }
}


