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

	void placeAllShipsRandomly(){
		boolean horizontal;
		int Row = new Random().nextInt(10);
		int Column = new Random().nextInt(10);
		if(new Random().nextInt(2)==1){
			horizontal=true;
		}
		else{
			horizontal=false;
		}
		battleship.placeShipAt(Row,Column, horizontal, ocean);	
	}

}
