/**
 * HW11 Yike Chen and Hao Liu
 */

package battleship;

import java.util.Scanner;

public class BattleshipGame {
	private boolean okToPrint;
	private boolean loopFlag;
	private Ocean ocean;
	//constructor
	public BattleshipGame(boolean okToPrint){
		this.okToPrint = okToPrint;
		this.loopFlag = true;
		this.ocean = new Ocean();
		this.ocean.placeAllShipsRandomly();
	}


	/**
	 * Print the message with System.out.print
	 * @param message
	 */
	public void print(String message){
		if (okToPrint) {
			System.out.print(message);
		}
	}


	/**
	 * Print the message with System.out.println
	 * @param message
	 */
	public void println(String message){
		if (okToPrint) {
			System.out.print(message);
		}
	}


	/**
	 * Take the shoot. The human player tries to hit the ships, by calling out a row and column number. 
	 * The computer responds with one bit of information saying ”hit” or ”miss.” When a ship is hit but not sunk, 
	 * the program does not provide any information about what kind of a ship was hit. 
	 * However, when a ship is hit and sinks, the program prints out a message ”You just sank a ship-type.” 
	 * @param row
	 * @param column
	 */
	public void shootAt(int row, int column){
		this.println("Shoot at location: " + "(" + row + ", " +column +  ")\n");
		if(this.ocean.shootAt(row,column)){
			this.println("hit\n");
			if(this.ocean.getShipArray()[row][column].isSunk()){
				this.println("You just sank a "+this.ocean.getShipArray()[row][column].getShipType()+"!\n\n");
			}
		}
		else {
			this.println("miss\n");
		}
		//this.ocean.shootAt(row,column);
	}


	/**
	 * Print the results
	 */
	public void display(){
		//this.println("The shoot result is:\n");
		this.ocean.print();
	}


	/**
	 *Print the final result, including total ships sunk, total shots fired, total hit counts
	 */
	public void finalResult(){
		this.println("Congrats! You win. \nYour total hits number: " + this.ocean.getHitCount() +"\n"
				+ "Total Ships Sunk: " + this.ocean.getShipsSunk() + "\n"
				+ "Total shoots fired: " + this.ocean.getShotsFired() + "\nThe final state of the battlefield looks like this: \n");
		this.display();
	}

	
	/**
	 * @param Check if the input is integer
	 * @return
	 */
	public boolean isInteger(String input){
		try {
			Integer.parseInt(input); 
			return true;
		}
		catch(RuntimeException e){
			return false;
		}
	}

	
	/**
	 * @param Check if the input is out of range
	 * @return
	 */
	public boolean checkInput(String input){
		if(isInteger(input)){
			if (Integer.parseInt(input)>9||Integer.parseInt(input)<0){
				return false;
			}
			return true;
		}
		return false;
	}


	/**
	 * Start the game. In this class we will set up the game; accept ”shots” from the user; 
	 * display the results; print final scores; and ask the user if he/she wants to play again. 
	 * All input/output is done here (although some of it is done by calling a print() method in the Ocean class.) 
	 */
	public void start(){
		this.println("Welcome to the Battleship Game! \nYou will now play against computer. "
				+ "Each of you have a fleet (a battleship, two cruisers, three destroyers, and four submarines) and \n"
				+ "an ocean(10 by 10 grid). Notice that computer's fleet is hidden from you, your job therefore is to guess where the computer's fleet is and sink it."
				+ "\nHere is what the sea looks like: \n");
		this.display();
		Scanner sc = new Scanner(System.in);
		String again = "";
		while(this.loopFlag){
			
			boolean gameFlag = true;
			while(gameFlag){
				String row = "";
				String column = "";
				while(!checkInput(row)){
					this.println("Please enter the row number you want to shoot at (0-9): ");
					row = sc.next();
				}
				while(!checkInput(column)){
					this.println("Please enter the column number you want to shoot at (0-9): ");
					column = sc.next();
				}
				this.shootAt(Integer.parseInt(row),Integer.parseInt(column));
				this.display();
				gameFlag = !this.ocean.isGameOver();
			}
			this.finalResult();
			this.println("\n Would you like to play again? y/n \n");
			again = sc.next();
			if(again.equals("y")||again.equals("Y")||again.equals("yes")||again.equals("Yes")){
				this.loopFlag = true;
				BattleshipGame gb = new BattleshipGame(true);
				gb.start();
				//this.ocean = new Ocean();
			}
			else{
				this.println("\n See ya! \n");
				this.loopFlag = false;
			}
		}
		sc.close();
	}


	/**
	 * Main function
	 * @param args
	 */
	public static void main(String[] args){
		BattleshipGame gb = new BattleshipGame(true);
		gb.start();
	}
}
