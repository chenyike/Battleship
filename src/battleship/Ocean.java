package battleship;

import java.util.*;

public class Ocean {
	Ship[][] ships = new Ship[10][10];
	int shotsFired;
	int hitCount;
	int shipsSunk;
	private EmptySea emptySea;
	private Ship ship;
	private Battleship battleship;
	private Ocean ocean;


	public Ocean() {
		//Creates an ”empty” ocean (fills the ships array with EmptySeas).
		//Also initializes any game variables, such as how many shots have been fired.
		for (int i=0; i<10 ;i++){
			for (int j=0; j<10;j++){
				ships[i][j] = emptySea; 
			}
		}
		this.shotsFired = 0;
		this.hitCount = 0;
		this.shipsSunk = 0;
	}

	int[] generateRandom() {
		int[] RandomVariable = new int[3]; 
		int Row = new Random().nextInt(10);
		int Column = new Random().nextInt(10);
		int horizontal = new Random().nextInt(2);
		RandomVariable[1]= Row;
		RandomVariable[2]=Column;
		RandomVariable[3]=horizontal;
		return RandomVariable;
	}

	void placeAllShipsRandomly(){
		boolean horizontal;
		if (generateRandom()[2] == 1){
			 horizontal= true;
		}
		else{
			horizontal = false;
		}
		battleship.placeShipAt(generateRandom()[0],generateRandom()[1], horizontal, ocean);	
	}

	/**
	 * Returns true if the given location contains a ship, false if it does not.
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean isOccupied(int row, int column){

		return true;
	}


	/**
	 * Returns true if the given location contains a ”real” ship, still afloat, (not an EmptySea), false if it does not. 
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean shootAt(int row, int column){
		return true;
	}

	/**
	 * Returns the number of shots fired (in this game).
	 * @return
	 */
	public  int getShotsFired(){
		return 1;
	}

	/**
	 * Returns the number of hits recorded (in this game). All hits are counted
	 * @return
	 */
	public int getHitCount(){
		return 1;
	}

	/**
	 * Returns the number of ships sunk (in this game).
	 * @return
	 */
	public int getShipsSunk(){
		return 1;
	}

	/**
	 * Returns true if all ships have been sunk, otherwise false.
	 * @return
	 */
	public boolean isGameOver(){
		return true;
	}

	/**
	 * Returns the 10x10 array of ships.
	 * @return
	 */
	public Ship[][] getShipArray(){
		return null;
	}

	/**
	 * Prints the ocean. 
	 */
	public void print(){
	}

}
