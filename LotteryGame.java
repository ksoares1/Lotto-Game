/*
 * author Keilah Soares
 * 
 * Program which simulates a Lotto draw.
 * These are the steps the program should perform during its execution. It should:
 * 1. Ask the user how many lines (games) the user would like to play. 
 * Each line is made of five numbers between 1 and 45 (inclusive).
 * 2. Ask the user to enter five numbers between 1 and 45 (inclusive) for each line. 
 * The user must NOT be allowed to enter a number more than once for each line.
 * 3. When all the numbers for all the lines are entered, the program should display all lines and asks the user to confirm the game. 
 * If the user does NOT confirm the game, the program should start all over again.
 * 4. Draw (generate) five numbers between 1 and 45 (inclusive). The numbers should be unique within the draw.
 * 5. Draw (generate) one number (the bonus number) between 1 and 45 (inclusive). The number should be unique within the draw.
 * 6. Display all the lines played and the result of each line.
 * 7. Ask the user if the person would like to play again, if so the program should start the process all over again.
 * 
 * Notes:
 * The program should NOT make use of any class variable (global variable) (10% penalty)
 * These methods MUST be part of your program:
 * public static boolean checkNumber( int[] list, int num ) (5% penalty)
 * This method receives an array of integers and an integer value. It checks whether or not the number (num) is already in the array (list), returning true if the number is in the list, and false if the number is not in the list.
 * public static int[] drawNumbers( int number ) (5% penalty)
 * This method draws all numbers of a game (quantity of numbers to draw is based on the number parameter) and returns them in an array.
 * public static void displayResult( int[][] list, int[] draw ) (5% penalty)
 * This method displays the result of the game. It receives a list of all lines played and a list of all numbers draw.
 */

import java.util.Scanner;
import java.io.IOException;

//Class LotteryGame
class LotteryGame {
	//Main Method
	public static void main(String[] args) {
		//declare variables and give them values
		char playAgain = ' ';
		char option = ' ';

		//Headline of the game
		System.out.println("*************************** Lotery Game ***************************");
		System.out.println();
		
		/*Condition while that will put the game in the order that needs to run and function calling the methods. 
		 * If the user wants to confirm the game it should show the final results. 
		 * If the user doesn't want to confirm the game, the program should go to the end "Bye- Bye"
		 */
		while(playAgain!= 'N' || option == 'N'){
			// calling of methods readLines() and readNumber(), define array digNumbers with the value of lines and number of collums (5).
			int lines = readLines();
			System.out.println();
			//create and define and array with lines and 5 collums
			int[][] digNumbers = new int[lines][5];
			digNumbers = readNumber(digNumbers);
			
			//option = receives (call) the method confGame()	
			option = confGame();
			System.out.println();
			//condition that check if the user wants to confirm the game - answer Y
			if(option == 'Y'){
			// Headline of the numbers (input from user)	
			System.out.println("=========================== Your numbers ===========================");
			//call method to print the array (digNumber that was input from user)
			printArray(digNumbers);
			System.out.println();
			//create and define array list with 5 positions
			int[] list = new int[5];	
			// Headline for the numbers drawn
			System.out.println("=========================== Numbers Drawn ==========================");
			//list receives (call) drawNumbers with 6 numbers (the sixt number is the bonus number)
			list = drawNumbers(6);
			System.out.println();
			System.out.println();
			// Headline for the numbers drawn
			System.out.println("********************************************************************");
			System.out.println("*************************** Lottery Result *************************");
			System.out.println("********************************************************************");
			//call method displayResult ();
			displayResult(digNumbers, list);	
			System.out.println();
			
			//playagain receives (call) method playAg
			playAgain = playAg();					
			}
			//if the user doesn't confirm the game it goes back to the beggining and starts the game again.
			else{
				playAgain = 'N';
			}
		}
		System.out.println();
		//prints the goodbye message to the screen if the user doesn't want to play anymore.
		System.out.println("===================== That's a shame...Bye Bye!! ====================");
	}//end of main method
	
 	/* method that does the draw of the random numbers, checks if there's a number already in the array and returns the value of "numbers".*/
	public static int[] drawNumbers(int number) {
		//create variables and give them values
		int[] numbers = new int[number];
		boolean yes = false;

		//condition that runs the array and generate the random numbers between 1 and 45		
		for (int j = 0 ; j < numbers.length ; j++) {
			//number receives the random number
			number = (int) (Math.random() * 45 + 1);
			//condition that runs the array and check if the random number generated is already in the array
			for(int x = 0 ; x < j ; x++){
				//if the number is already in the list, yes change to true and decrease the counter j
				if (numbers[x] == number){
					yes = true;
					j--;
				}
			}
			//condition that check if the number is not in the list - yes = false, stores the number in the position j
			if (yes == false){
				numbers[j] = number;
				System.out.print (numbers[j]);
			}	
			//condition to print an " - " between the numbers - the last one
			if(j < numbers.length - 1){
				System.out.print(" - " );
			}
		}
		//return the value of numbers
		return numbers;
	}//end of method drawNumbers

	/* method that prints the array digNumbers in positions x and y, plus a "-" sign between the numbers*/
	public static void printArray(int[][] digNumbers) {
		//create variables and give them values
		int counter = 0;
		int game = 0;
		//condition that runs the array digNumbers
		for (int x = 0; x < digNumbers.length; x++){
			//second condition that check the array digNumbers in the position x
			for (int y = 0; y < digNumbers[x].length; y++) {
				//prints array digNumbers with positions x and y + a " - " between the numbers
				System.out.print(digNumbers[x][y] + " - " );
			}
			//condition that prints the numbers with a " - " between the numbers (1 before the last)
			if(x < digNumbers.length - 1){
				System.out.print(" - ");
			}			
			//Prints an empty line
			System.out.println();
		}
	}//end of method printArray

	/* method that check if the number is already in the array. If yes, change the value of the flag and return the value of flag */
	public static boolean checkNumber(int[] list, int num) {
		//create variables and give them values
		int c = 0;
		boolean flag = true;
		//condition that check the whole array. If the number is already there, prints message on the screen and change flag to false.
		while (c < 5) {
			if (list[c] == num) {
				System.out.println("Number has already been entered. Please enter a new number! ");
				flag = false;
			}
			//increment counter c
			c++;
		}
		//returns the value of flag
		return flag;
	}//end of method checkNumber

	/* method that reads the input from user and checks if its a valid number in each line, returns the array digNumbers */
	public static int [][]readNumber(int [][] digNumbers) {
		///create variables and give them values
		boolean flag = true;
		int num = 0;
		int pos = 0;
		int line = 0;
		//condition that checks the whole array - 5 positions
		while(pos < digNumbers.length){
			//create and define an array with 5 positions, create variable line and give it a value
			int [] linearS = new int[5];
			line = 0;
		//Headline that prints the quantity of lines - input from user
		System.out.println("*************************** Line " + (pos + 1) +  " **************************");
			//condition that does the program to execute actions while line is smaller than 5
			while (line < 5) {
				//get the input from user and store in the variable data
				System.out.print("Please enter a number:");
				Scanner scanner = new Scanner(System.in);
				String data = scanner.nextLine();
				//try - convert the String from data to integer and stores in num
				try {
					num = new Integer(data);
					//boolean used as a flag to the method checkNumber()
					boolean yes = checkNumber(linearS, num);
					//condition that check if the number - input from user is between 1 and 45
					if ((num < 1) || (num > 45)) {
						//if number is out of range prints the error message on the screen
						System.out.println("Invalid number (1-45).");
					} 
					//otherwise - flag changes to false
					else {
						flag = false;
					}
					//array linearS receive num (line)
					linearS [line] = num;
					//array digNumbers receives num (position and line)
					digNumbers[pos][line] = num;
					//increment line
					line++;
				} 
				//catch if there's an exception. If there's an exception prints the error message on the screen
				catch (NumberFormatException e) {
					System.out.println("This is not a valid number.");
				}
			}
			//increment the position pos in 1
			pos++;
		}
		//returns the value of digNumbers
		return digNumbers;
	}//end of method readNumber

	/* method to read the lines of the game, catch exceptions and return the value of lines */
	public static int readLines() {
		//create variables and give them values
		boolean flag = true;
		int lines = 0;
		//condition while flag is true, gets the number of lines - input from user and stores in data
		while (flag) {
			System.out.print("Please enter the number of games (lines) you would like to play:  ");
			Scanner scanner = new Scanner(System.in);
			String data = scanner.nextLine();
			//try - variable lines receives the number of lines and change flag to false
			try {
				lines = new Integer(data);
				flag = false;
			} 
			//catch if there's an exception. If there's an exception, prints the error message on the screen
			catch (NumberFormatException e) {
				System.out.println("Invalid input.");
			}
		}
		//returns the value of lines
		return lines;
	}//end of method readLines
	
	/* method that display the result of the game and show if there was(were) a match(es) */
	public static void displayResult(int[][] list, int[] draw) {
		//create variables and give them values
		int yes = 0;
		int pos = 0;
		boolean flag = true;
		//prints an empty line
		System.out.println();
		//condition that runs the array list, increment pos and keep flag = true
		for (int x = 0; x < list.length; x++) {
			pos++;
			flag = true;
			//second condition that runs the array list checking the x positions - lines
			for (int y = 0; y < list[x].length; y++) {
				//third condition that runs the array list checking the positions - collums
				for (int k = 0; k < 5; k++){
					//condition that check if there's a match. If there's a match change flag to false and increment yes
					if (list[x][y] == draw[k]) {
						flag = false;
						yes++;
					}
				}
			}
			//prints if there was a match
			System.out.print(yes + (flag ? " " : "*") + " -- ");
		}
		//prints the match message and the number of match(es)
		System.out.print(" You have a " + yes + " match(es)!");
	}//end of method displayResult
	
	/* method to ask the user if wants to confirm the game, catch exceptions and returns the value of option */
	public static char confGame(){
		//create variables and give them values
		char option = ' ';
		Scanner scanner = new Scanner(System.in);
		//condition do that ask if the user wants to confirm the game, check if the input is valid and catch exceptions
		do{
			System.out.println();

			// ask user if wants to confirm the game
			System.out.print("Would you like to confirm the game? <Y>es / <N>o: ");
			//try - option receives the input from user
			try{
				option = scanner.nextLine().toUpperCase().charAt(0);
			}
			//catch if there's an exception. If there's an exception shows error message on the screen
			catch( NumberFormatException e ){
				System.out.println("Ooops !!! Something went wrong...");
			}
			//catch different exception (StringIndexOutOfBoundsException). If there's an exception shows error message on the screen
			catch( StringIndexOutOfBoundsException siob ){
				System.out.println("Ooops !!! Something went wrong...");
			}			
			//condition that check if the input is valid or not to confirm the game
			if ( option != 'N' && option != 'Y' ){
				//if not, show the error message on the screen
				System.out.println("Invalid input, Try again ... ");
			}
		} 
		//program does the "do" above while option != 'N' && option != 'Y'
		while ( option != 'N' && option != 'Y' );
		//returns the value of option
		return option;
	}//end of method confGame
	
	/* method to ask if the user wants to play again, catch exceptions and returns the value of playAgain */
	public static char playAg(){
		//declare variables and give them value
		char playAgain = ' ';
		Scanner scanner = new Scanner(System.in);
		//condition do that ask if the user wants to play the game again, check if the input is valid and catch exceptions
		do{
			System.out.println();

			// ask user if wants to play again 
			System.out.print("Would you like to play again? <Y>es / <N>o: ");
			//try - playAgain recevives the input from user
			try{
				playAgain = scanner.nextLine().toUpperCase().charAt(0);
			}
			//catch if there's an exception. If there's an exception shows error message on the screen
			catch( NumberFormatException e ){
				System.out.println("Ooops !!! Something went wrong...");
			}
			//catch different exception (StringIndexOutOfBoundsException). If there's an exception shows error message on the screen
			catch( StringIndexOutOfBoundsException siob ){
				System.out.println("Ooops !!! Something went wrong...");
			}			
			//condition that checks if the input is valid or not to play again
			if ( playAgain != 'N' && playAgain != 'Y' ){
				//if not, show the error message on the screen
				System.out.println("Invalid input, Try again ... ");
			}
		} 
		//program does the "do" above while playAgain != 'N' && playAgain != 'Y'
		while ( playAgain != 'N' && playAgain != 'Y' );
		//returns the value of playAgain
		return playAgain;
	}//end of method playAg	
}//end of class LotteryGame