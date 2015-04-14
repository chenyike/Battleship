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
	 * Take the shoot
	 * @param row
	 * @param column
	 */
	public void shootAt(int row, int column){
		this.println("Shoot at the location: " + "(" + row + ", " +column +  ")\n");
		this.ocean.shootAt(row,column);
	}
	/**
	 * Print the results
	 */
	public void display(){
		this.println("The shoot result is:\n");
		this.ocean.print();
	}
	/**
	 *Print the final result
	 */
	public void finalResult(){
		this.println("Your total hits number: " + this.ocean.getHitCount() +"\n"
				+ "Total Ships Sunk: " + this.ocean.getShipsSunk() + "\n"
				+ "Total shoots fired: " + this.ocean.getShotsFired() + "\n");
		this.display();
	}
	/**
	 * Start the game
	 */
	public void start(){
		this.println("Welcome to the game");
		Scanner sc = new Scanner(System.in);
		int row=0;
		int column = 0;
		boolean gameFlag = true;
		String again = "";
		while(this.loopFlag){
			while(gameFlag){
				this.println("Please enter the row number you want to shoot(0-9):");
				row = sc.nextInt();
				this.println("Please enter the column number you want to shoot(0-9):");
				column = sc.nextInt();
				this.shootAt(row,column);
				this.display();
				gameFlag = !this.ocean.isGameOver();
			}
			this.finalResult();
			this.println("\n Do you like to play again? y/n \n");
			again = sc.next();
			if(again.equals("y")){
				this.loopFlag = true;
			}
			else{
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
