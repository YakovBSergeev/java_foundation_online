package ru.itsjava.examples.leetcode.longestPalindrome;

public class SolutionBest {
    static int start = 0;
    static int end = 0;
    public static String longestPalindrome(String s) {
        helper(s.toCharArray(), 0);
        System.out.println( s.substring( start, end + 1 ) );
        return s.substring(start, end+1);
    }
    public static void helper(char[] str, int i){
        int n = str.length;
        if(i>=n-1){
            return;
        }
        int l = i;
        int r = i;
        while(r<n-1 && str[r] == str[r+1]){
            r++;
        }
        i = r;
        while(l>0 && r<n-1 && str[l-1]==str[r+1]){
            l--;
            r++;
        }
        if((end-start) < (r-l)){
            end = r;
            start = l;
        }
        helper(str, i+1);
    }

    public static void main(String[] args) {
        longestPalindrome( "rqdsaasdfghjklkjhgfdsasdfie" );
    }
}
