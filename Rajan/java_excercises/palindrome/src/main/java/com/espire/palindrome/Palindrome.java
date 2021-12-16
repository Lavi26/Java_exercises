package com.espire.palindrome;

import java.util.*;

public class Palindrome {

    public static String isPalindrome(String s) {

        // converting string into char array
        char[] str = s.toCharArray();

        // declaring an empty string
        String rev = "";

        // loop from last to first element
        for (int i = str.length - 1; i >= 0; i--) {
            rev = rev + str[i];
        }
        // comparing the rev and user input
        if (s.equals(rev)) {
            return "String is palindrome";
        } else {
            return "String is not palindrome";
        }
        
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in); //taking user input

        String input = sc.nextLine();

        isPalindrome(input);

    }

}