/*  COM1003 Java Programming 
	Autumn Semester 2018-9
	Programming Assignment 1
	Written by: Simonas Petkevicius
	Mole Username: acc17sp
	Registration No:180170308 
	Written on: 23/10/18
*/ 

import sheffield.*;
public class Distance {
	
	
	public static void main (String [] args) {

		// constants that could be used anytime needed
		final double MILES_IN_KM = 0.62137;
		final int YARDS_IN_MILE = 1760;

		// Using EasyReader class to create objects for getting an input from the user and file
		EasyReader keyboard = new EasyReader();
		EasyReader inputFile = new EasyReader("units.txt");

		// Object that prints data onto the console
		EasyWriter screen = new EasyWriter();

		// reads the data from the user
		double distanceInKilometres = keyboard.readDouble("What distance in kilometers shall I convert? ");

		// reads the data from the file
		String firstLine = inputFile.readString();
		int secondLine = inputFile.readInt();
		String thirdLine = inputFile.readString();
		String fourthLine = inputFile.readString();

		/* variables that will show me where does the integer
		   in the line of string starts and ends */
		int integerStart = 0;
		int integerEnd = 0;

		// finds where the integer in the string line starts and where it ends.
		for(int i = 0; i < fourthLine.length(); i++) {

			// if the number is found on the string if conditional statement is executed
			if(Character.isDigit(fourthLine.charAt(i))) {

				integerStart = i;

				// This for loop searches for the ending of the number in the string
				for(int j = i; j < fourthLine.length(); j++) {
					
					if(Character.isDigit(fourthLine.charAt(j))) 

						// we use j + 1 because .substring(a, b); because it makes a new string from a to b-1
 						integerEnd = j + 1;
					else

						// when the integer has ended we close the loop
						break;
				}

				// we exit the loop when we know the start and the end of the number in the string
				break;
			}
		}

		// converts the number value which is in the string line to the integer
		int fourthLineInteger = Integer.valueOf(fourthLine.substring(integerStart, integerEnd));

		// Counts the distance in miles
		double distanceInMiles = distanceInKilometres * MILES_IN_KM;

		// Counts the distance in Yards
		double distanceInYards = (distanceInMiles - (int) distanceInMiles) * YARDS_IN_MILE;

		// Counts the distance in the first given measure from units.txt
		double distanceFromSecondLine = (distanceInMiles - (int) distanceInMiles) * secondLine;

		// Counts the distance in the second given measure from units.txt
		double distanceFromFourthLine = (distanceInMiles - (int) distanceInMiles) * fourthLineInteger;

		// Writes distance in miles
		screen.print("In miles that is ");
		screen.println(distanceInMiles, 3);

		// Writes distance in miles and yards
		screen.print("Or " + (int) distanceInMiles + " miles and about"); 
		screen.print(Math.round(distanceInYards), 5);
		screen.println(" yards");

		// Writes distance in miles and the first given measure in units.txt
		screen.print("Or " + (int) distanceInMiles + " miles and about");
		screen.print(Math.round(distanceFromSecondLine), 5);
		screen.println( " " + thirdLine);

		// Writes distance in miles and the second given measure in units.txt 
		screen.print("Or " + (int) distanceInMiles + " miles and about");
		screen.print(Math.round(distanceFromFourthLine), 5);
		screen.println( " " + fourthLine.substring(integerEnd, fourthLine.length()).trim());
	}
}