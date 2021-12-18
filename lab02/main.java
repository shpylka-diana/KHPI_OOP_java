package ua.khpi.oop.Shpylka02;

import java.util.*;

public class main {
	public static void main(String[] args){
		int iterations = 10;
		for (int op = 0; op < iterations; op++) { 
			Random rnd = new Random();
			int inputData = rnd.nextInt(1000);
			int duplicateOfInput = inputData;
			
			int sizeOfNum = 0;
			int firstInputedData = inputData;
			int smallest  = 9;
			while (inputData > 0) {
				int temp = inputData % 10;
				if (temp < smallest) {
					smallest = temp;
				}
				inputData /= 10;
				sizeOfNum++;
			}
			System.out.println("The smallest digit in the number: " + firstInputedData + " is -> " + smallest);
			System.out.print("Position of the smallest digit [" + smallest + "] is -> ");
			
			// Rotate num 
			int rotatedInputedData = 0;
			while (duplicateOfInput > 0) {
				rotatedInputedData = rotatedInputedData * 10 + duplicateOfInput % 10;
				duplicateOfInput /= 10;
			}
			rotatedInputedData += 100000;
			// Position
			for (int i = 1; i <= sizeOfNum; i++) {
				int temp = rotatedInputedData % 10;
				if (temp == smallest) {
						System.out.print(i + " ");
				}
				rotatedInputedData /= 10;
			}						
			
			System.out.println();
			if (iterations > 1) {
				System.out.println("******");
			}
		}
	}
}
