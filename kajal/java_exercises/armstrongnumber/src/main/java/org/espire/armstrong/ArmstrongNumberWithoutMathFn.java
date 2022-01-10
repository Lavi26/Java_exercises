package org.espire.armstrong;

import java.util.Scanner;

/*
 * Simple Java Program to check  if a number is Armstrong number or not.
 *An Armstrong number of three digit is a number whose sum of cubes of its digit is equal 
 *to its number. For example 153 is an Armstrong number
 * of 3 digit because 1^3+5^3+3^3 or 1+125+27=153
 */
public class ArmstrongNumberWithoutMathFn {
	// main method
	public static void main(String args[]) {
		// input number to check if its Armstrong number
		System.out.println("Please enter a 3 digit number to find if its is an Armstrong number:");
		int number = new Scanner(System.in).nextInt();
		// printing result
		if (isArmStrong(number)) {
			System.out.println("Number : " + number + " is an Armstrong number");
		} else {
			System.out.println("Number : " + number + " is not an Armstrong number");
		}
	}

	/* return true if number is Armstrong number or return false */
	private static boolean isArmStrong(int number) {
		int result = 0;
		int orig = number;
		while (number != 0) {
			int remainder = number % 10;
			result = result + remainder * remainder * remainder;
			number = number / 10;
		}
		// number is Armstrong return true
		if (orig == result) {
			return true;
		}
		return false;
	}
}
