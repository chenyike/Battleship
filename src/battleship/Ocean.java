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
	private Cruiser cruiser1;
	private Cruiser cruiser2;
	private Destroyer destroyer1;
	private Destroyer destroyer2;
	private Destroyer destroyer3;
	private Submarine submarine1;
	private Submarine submarine2;
	private Submarine submarine3;
	private Submarine submarine4;
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

	void placeOneShip(Ship ship) {
		boolean horizontal;
		int row = new Random().nextInt(10);
		int column = new Random().nextInt(10);
		if (new Random().nextInt(2) == 1){
			horizontal = false;
		}
		else{
			horizontal =true;
		}
		
		while(!ship.okToPlaceShipAt(row, column, horizontal, ocean)){
			row = new Random().nextInt(10);
			column = new Random().nextInt(10);
			if (new Random().nextInt(2) == 1){
				horizontal = false;
			}
			else{
				horizontal =true;
			}
		}
		ship.placeShipAt(row, column, horizontal, ocean);
	}
	
	

	void placeAllShipsRandomly(){
		placeOneShip(this.battleship);
		placeOneShip(this.cruiser1);
		placeOneShip(this.cruiser2);
		placeOneShip(this.destroyer1);
		placeOneShip(this.destroyer2);
		placeOneShip(this.destroyer3);
		placeOneShip(this.submarine1);
		placeOneShip(this.submarine2);
		placeOneShip(this.submarine3);
		placeOneShip(this.submarine4);



		
		
	}

	/**
	 * Returns true if the given location contains a ship, false if it does not.
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean isOccupied(int row, int column){
		if (ships[row][column] instanceof EmptySea){
			return false;
		}
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
