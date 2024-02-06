package ru.itsjava.strings;

public class StringPractice {

    public static void main(String[] args) {
        String name = "Vitaliy";
        String copyName = "Vitaliy"; //ctrl +D
        System.out.println("(name == copyName) = " + (name == copyName));

        String constructorName = new String("Vitaliy");
        System.out.println("(constructorName == name) = " + (constructorName == name));
        String internConstructorName = constructorName.intern();

        System.out.println("(internConstructorName == name) = " + (internConstructorName == name));

        String str = "Я строка";

        System.out.println("str.length() = " + str.length());
        System.out.println("str.isEmpty() = " + str.isEmpty());

        System.out.println("str.equals(\"Я строкА\") = " + str.equals("Я строкА"));
        System.out.println("str.equalsIgnoreCase(\"Я строкА\") = "
                + str.equalsIgnoreCase("Я строкА"));

        String[] strs = str.split(" ");
        System.out.println(strs[0]);
        System.out.println(strs[1]);

//        for (int i = 0; i < 1_000_000; i++) {
//            str = str + "!";
//        }

        StringBuilder builderStr = new StringBuilder(str);
        for (int i = 0; i < 1_000; i++) {
            builderStr.append('!');
        }
        System.out.println(builderStr.toString());


    }
}
