package ru.itsjava.examples.leetcode.zigzagConversion;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String convert(String s, int numRows) {
        long startTime = System.nanoTime();
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        int idx = 0, d = 1;
        List<Character>[] rows = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new ArrayList<>();
        }

        for (char c : s.toCharArray()) {
            rows[idx].add( c );
            if (idx == 0) {
                d = 1;
            } else if (idx == numRows - 1) {
                d = -1;
            }
            idx += d;
        }

        StringBuilder result = new StringBuilder();
        for (List<Character> row : rows) {
            for (char c : row) {
                result.append( c );
            }
        }
        System.out.println( System.nanoTime() - startTime );
        return result.toString();
    }

    public static String convert1(String s, int numRows) {
        long startTime = System.nanoTime();
        if (numRows == 1 || numRows >= s.length())
            return s;

        int n = s.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            int step1 = (numRows * 2) - 2;
            int step2 = i * 2;

            for (int j = i; j < n; j += step1) {
                sb.append( s.charAt( j ) );

                if (step2 > 0 && step2 < step1 && j + step1 - step2 < n) {
                    sb.append( s.charAt( j + step1 - step2 ) );
                }
            }
        }
        System.out.println( System.nanoTime() - startTime );
        return sb.toString();
    }

    public static String convert2 (String s, int numRows) {
        long startTime = System.nanoTime();
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        List<StringBuilder> rows= new ArrayList<>();
        for(int i=0; i< numRows; i++){ // intializing SB objects in list
            rows.add(new StringBuilder());
        }

        boolean goingDown= true; // to track the direction
        int i= 0;
        for(char c : s.toCharArray()){ // taking the chars of the string one by one
            rows.get(i).append(c); // appedn in the curr row
            if(i == numRows -1){ // if reached end of row the reverse direction
                goingDown= false;
            }else if(i == 0){ //if reached in the first row the  reverse the direction
                goingDown= true;
            }

            if(goingDown) i+= 1; // go from top to down
            else i-= 1; // go from down to top
        }
        StringBuilder ans= new StringBuilder();
        for(StringBuilder rowsStringBuilder : rows){ // apend all the row stinrg in one ans string and return
            ans.append(rowsStringBuilder);
        }
        System.out.println( System.nanoTime() - startTime );
        return ans.toString();
    }

    public static String convert03(String s, int n) {
        long startTime = System.nanoTime();
        int len = s.length();
        if (n == 1 || n >= len)
            return s;

        char[] arr = new char[len];

        int p = 0;

        for(int i=0; i<n ; i++){

            int j = i;
            while(j<len){
                if(i ==0 || i==n-1){
                    arr[p] = s.charAt(j);
                    j += n + n-2;
                    p++;
                }
                else{
                    arr[p] = s.charAt(j);
                    j += n-i-1 + n-i-1;
                    p++;
                    if(j>=len){
                        break;
                    }
                    arr[p] = s.charAt(j);
                    j += i + i;
                    p++;
                }
            }
        }
        String ans = new String(arr);
        System.out.println( System.nanoTime() - startTime );
        return ans;
    }

    public static void main(String[] args) {
        System.out.println( convert( "fjwhfiwefhwfwegergergtjqewirjgierjjgtjwerjttwjtiwjgfjwjgiwt0uw3tu4u9trwiejfwejfrweru09r90234rwejfjke9kj0i4e0ri2034r", 12 ) );
        System.out.println( convert1( "fjwhfiwefhwfwegergergtjqewirjgierjjgtjwerjttwjtiwjgfjwjgiwt0uw3tu4u9trwiejfwejfrweru09r90234rwejfjke9kj0i4e0ri2034r", 12 ) );
        System.out.println( convert2( "fjwhfiwefhwfwegergergtjqewirjgierjjgtjwerjttwjtiwjgfjwjgiwt0uw3tu4u9trwiejfwejfrweru09r90234rwejfjke9kj0i4e0ri2034r", 12 ) );
        System.out.println( convert03( "fjwhfiwefhwfwegergergtjqewirjgierjjgtjwerjttwjtiwjgfjwjgiwt0uw3tu4u9trwiejfwejfrweru09r90234rwejfjke9kj0i4e0ri2034r", 12 ) );
    }
}
