package battleship;

import java.util.*;

public class Ocean {
	private Ship[][] ships = new Ship[10][10];
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
	private EmptySea emptySea;
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
	private boolean[][] hits = new boolean[10][10];


	public Ocean() {
		//Creates an ”empty” ocean (fills the ships array with EmptySeas).
		//Also initializes any game variables, such as how many shots have been fired.
		for (int i=0; i<10 ;i++){
			for (int j=0; j<10;j++){
				ships[i][j] = emptySea; 
				this.hits[i][j] = false;
			}
		}
		this.shotsFired = 0;
		this.hitCount = 0;
		this.shipsSunk = 0;
	}

	/**
	 * Place all ships randomly
	 */
	public void placeAllShipsRandomly(){
		Random rd = new Random();
		Ship bs = new Battleship();
		boolean valid = false;
		int row = 0;
		int column = 0;
		boolean horizontal = false;
		while(!valid){
			row = rd.nextInt(9);
			column = rd.nextInt(9);
			horizontal = rd.nextBoolean();
			valid = bs.okToPlaceShipAt(row,column,horizontal,this);
		}
		bs.placeShipAt(row, column, horizontal, this);
		for (int i=0; i<2; i++){
			valid = false;
			Ship cru = new Cruiser();
			while(!valid){
				row = rd.nextInt(9);
				column = rd.nextInt(9);
				horizontal = rd.nextBoolean();
				valid = cru.okToPlaceShipAt(row,column,horizontal,this);
			}
			cru.placeShipAt(row, column, horizontal, this);
		}
		for (int i=0; i<3; i++){
			valid = false;
			Ship des = new Destroyer();
			while(!valid){
				row = rd.nextInt(9);
				column = rd.nextInt(9);
				horizontal = rd.nextBoolean();
				valid = des.okToPlaceShipAt(row,column,horizontal,this);
			}
			des.placeShipAt(row, column, horizontal, this);
		}
		for (int i=0; i<4; i++){
			valid = false;
			Ship sub = new Submarine();
			while(!valid){
				row = rd.nextInt(9);
				column = rd.nextInt(9);
				horizontal = rd.nextBoolean();
				valid = sub.okToPlaceShipAt(row,column,horizontal,this);
			}
			sub.placeShipAt(row, column, horizontal, this);
		}
	}

	/**
	 * Returns true if the given location contains a ship, false if it does not.
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean isOccupied(int row,int column){
		if(this.ships[row][column].getShipType().equals("empty")){
			return false;
		}
		return true;
	}


	/**
	 * Returns true if the given location contains a real ship
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean shootAt(int row, int column){
		this.shotsFired += 1;
		this.hits[row][column] = true;
		if(this.ships[row][column].shootAt(row,column)){
			this.hitCount += 1;
			if(this.ships[row][column].isSunk()){
				this.shipsSunk += 1;
			}
			return true;
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
	 * Prints the ocean
	 */
	public void print(){
		for(int i = 0; i < 11; i++){
			for(int j = 0; j < 11; j++){
				if(i==0){
					if(j==0){
						System.out.print(" "+" ");
					}
					else{
						System.out.print(j-1+" ");
					}
				}
				else{
					if(j==0){
						System.out.print(i-1 + " ");
					}
					else{
						if(hits[i-1][j-1]){
							System.out.print(ships[i-1][j-1] + " ");
						}
						else{
							System.out.print("." + " ");
						}
					}
				}
			}
			System.out.println();
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
