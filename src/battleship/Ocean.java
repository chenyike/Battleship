package battleship;

import java.util.*;

public class Ocean {
	private Ship[][] ships = new Ship[10][10];
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
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
			horizontal = true;
		}

		while(! ship.okToPlaceShipAt(row, column, horizontal, this)){
			row = new Random().nextInt(10);
			column = new Random().nextInt(10);
			if (new Random().nextInt(2) == 1){
				horizontal = false;
			}
			else{
				horizontal =true;
			}
		}
		ship.placeShipAt(row, column, horizontal, this);
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
		if (ships[row][column].getShipType().equals("emptySea")){
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
		this.shotsFired ++;
		if (!ship.isSunk()){
			if (!(ships[row][column].getShipType().equals("emptySea"))){
				ship.shootAt(row, column);
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}

	/**
	 * Returns the number of ships sunk (in this game).
	 * @return
	 */
	public int getShipsSunk(){
		return this.shipsSunk;
	}
	
	/**
	 * @param shipsSunk the shipsSunk to set
	 */
	public void setShipsSunk(int shipsSunk) {
		this.shipsSunk = shipsSunk;
	}
	
	
	/**
	 * Returns the number of shots fired (in this game).
	 * @return
	 */
	public  int getShotsFired(){
		return this.shotsFired;
	}

	/**
	 * Returns the number of hits recorded (in this game). All hits are counted
	 * @return
	 */
	public int getHitCount(){
		return this.hitCount;
	}
	
	/**
	 * @param hitCount the hitCount to set
	 */
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}



	/**
	 * Returns true if all ships have been sunk, otherwise false.
	 * @return
	 */
	public boolean isGameOver(){
		if (this.shipsSunk == 10){
			return true;
		}
		else{
			return false;
		}
	}



	/**
	 * Prints the ocean. 
	 */
	public void print(){
		System.out.println("\t 0\t 1\t 2\t 3\t 4\t 5\t 6\t 7\t 8\t 9\n ");
		for (int i = 0; i < 11; i++) {
			System.out.println("0");
			for (int j=0;j<10;j++){
				if (ship.shootAt(i,j)){
					System.out.println("\t S");
				}
				else if (!ship.shootAt(i,j)){
					System.out.println("\t -");
				}
				else if (ship.isSunk()){
					System.out.println("\t x");
				}
				else {
					System.out.println("\t "+emptySea);
				}
			}
		}
	}
	


	
	

	/**
	 * @param shotsFired the shotsFired to set
	 */
	public void setShotsFired(int shotsFired) {
		this.shotsFired = shotsFired;
	}

	/**
	 * @return the ships
	 */
	public Ship[][] getShips() {
		return ships;
	}

	/**
	 * Returns the 10x10 array of ships.
	 * @return
	 */
	public Ship[][] getShipArray(){
		return ships;
	}
	
	/**
	 * @param ships the ships to set
	 */
	public void setShips(Ship[][] ships) {
		this.ships = ships;
	}

	

}
