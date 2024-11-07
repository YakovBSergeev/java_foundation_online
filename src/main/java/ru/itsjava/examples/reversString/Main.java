package ru.itsjava.examples.reversString;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner( System.in );
        System.out.println( "введите строку: " );
        String str = scanner.nextLine(), nstr = "";
        char ch;

        System.out.print( "Original word: " );
        System.out.println( str ); //Example word

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt( i ); //extracts each character
            nstr = ch + nstr; //adds each character in front of the existing string
        }
        System.out.println( "Reversed word: " + nstr );


        {
            System.out.println( "введите строку: " );
            Scanner scanner1 = new Scanner( System.in );
            String input = scanner1.nextLine();

            // getBytes() method to convert string
            // into bytes[].
            byte[] strAsByteArray = input.getBytes();

            byte[] result = new byte[strAsByteArray.length];

            // Store result in reverse order into the
            // result byte[]
            for (int i = 0; i < strAsByteArray.length; i++)
                result[i] = strAsByteArray[strAsByteArray.length - i - 1];

            System.out.println( new String( result ) );
        }

        {
            System.out.println( "введите строку: " );
            Scanner scanner2 = new Scanner( System.in );
            String input0 = scanner2.nextLine();

            StringBuilder input1 = new StringBuilder();

            // append a string into StringBuilder input1
            input1.append( input0 );

            // reverse StringBuilder input1
            input1.reverse();

            // print reversed String
            System.out.println( input1 );
        }

        {
            System.out.println( "введите строку: " );
            Scanner scanner2 = new Scanner( System.in );
            String input = scanner2.nextLine();

            // convert String to character array
            // by using toCharArray
            char[] try1 = input.toCharArray();

            for (int i = try1.length - 1; i >= 0; i--)
                System.out.print( try1[i] );
            System.out.println();
        }

        {
            System.out.println( "введите строку: " );
            Scanner scanner2 = new Scanner( System.in );
            String input = scanner2.nextLine();
            char[] temparray = input.toCharArray();
            int left, right = 0;
            right = temparray.length - 1;

            for (left = 0; left < right; left++, right--) {
                // Swap values of left and right
                char temp = temparray[left];
                temparray[left] = temparray[right];
                temparray[right] = temp;
            }

            for (char c : temparray)
                System.out.print( c );
            System.out.println();
        }

        {
            System.out.println( "введите строку: " );
            Scanner scanner2 = new Scanner( System.in );
            String input = scanner2.nextLine();

            char[] hello = input.toCharArray();
            List<Character> trial1 = new ArrayList<>();

            for (char c : hello)
                trial1.add( c );

            Collections.reverse( trial1 );
            ListIterator li = trial1.listIterator();
            while (li.hasNext())
                System.out.print( li.next() );
        }

        {
            System.out.println();
            System.out.println( "введите строку: " );
            Scanner scanner2 = new Scanner( System.in );
            String s = scanner2.nextLine();

            //initializing a stack of type char
            Stack<Character> stack=new Stack<>();

            for(char c:s.toCharArray())
            {
                //pushing all the characters
                stack.push(c);
            }

            StringBuilder temp= new StringBuilder();

            while(!stack.isEmpty())
            {
                //popping all the chars and appending to temp
                temp.append( stack.pop() );
            }

            System.out.println("Reversed string is : "+temp);

        }
    }
}

