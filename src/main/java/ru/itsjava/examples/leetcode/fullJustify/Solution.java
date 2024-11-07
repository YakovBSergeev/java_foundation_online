package ru.itsjava.examples.leetcode.fullJustify;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        long time = System.nanoTime();
        List<String> result = new ArrayList<>();

        for (int i = 0, wordCount, lineLength; i < words.length; i += wordCount) {
            for (wordCount = 0, lineLength = 0;
                 i + wordCount < words.length &&
                         lineLength + words[i + wordCount].length() + wordCount <= maxWidth;
                 wordCount++) {
                lineLength += words[i + wordCount].length();
            }

            StringBuilder lineBuilder = new StringBuilder( words[i] );

            if (wordCount == 1 || i + wordCount == words.length) {
                for (int j = 1; j < wordCount; j++) {
                    lineBuilder.append( " " ).append( words[i + j] );
                }
                lineBuilder.append( " ".repeat( maxWidth - lineBuilder.length() ) );
            } else {
                int totalSpaces = (maxWidth - lineLength) / (wordCount - 1);
                int extraSpaces = (maxWidth - lineLength) % (wordCount - 1);

                for (int j = 1; j < wordCount; j++) {
                    int spacesToAdd = totalSpaces + (extraSpaces-- > 0 ? 1 : 0);
                    lineBuilder.append( " ".repeat( spacesToAdd ) ).append( words[i + j] );
                }
            }
            result.add( lineBuilder.toString() );
        }
        System.out.println( result );
        System.out.println( System.nanoTime() - time );
        return result;
    }


    public static List<String> fullJustifyBest(String[] words, int maxWidth) {
        long time = System.nanoTime();
        List<String> res = new ArrayList<>();
        int l = 0, index = 0;
        while (index < words.length) {
            int len = -1;
            while (index < words.length && len + words[index].length() + 1 <= maxWidth) {
                len += words[index++].length() + 1;
            }
            StringBuilder sb = new StringBuilder();
            int space = 1;
            int extra = 0;
            if (index != l + 1 && index != words.length) {
                int num = index - l;
                space = 1 + (maxWidth - len) / (num - 1);
                extra = (maxWidth - len) % (num - 1);
            }
            for (int i = l; i < index; i++) {
                sb.append( words[i] );
                if (i != index - 1) {
                    for (int j = 0; j < space; j++) sb.append( " " );
                }
                if (extra > 0) {
                    sb.append( " " );
                    extra--;
                }
            }
            while (sb.length() < maxWidth) sb.append( " " );
            l = index;
            res.add( sb.toString() );
        }

        System.out.println( res );
        System.out.println( System.nanoTime() - time );
        return res;
    }

    public static void main(String[] args) {
//        fullJustify( new String[]{"654564", "fgsgfwer", "ew", "dwqe", "ldmfklwdfl", "eewe", "pwefw[e", "wqw"}, 25 );
        fullJustifyBest( new String[]{"654564", "fgsgfwer", "ew", "dwqe", "ldmfklwdfl", "eewe", "pwefw[e", "wqw"}, 25 );
        System.out.println( 24 % 5 );
    }
}
