/**
 * HW11 Yike Chen and Hao Liu
 */
package battleship;
import java.util.*;

public class Ocean {
    private Ship[][] ships = new Ship[10][10];
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;
    private String[][] hits = new String[10][10]; 


    //Constructor
    public Ocean(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                this.ships[i][j] = new EmptySea();
                this.hits[i][j] = "";
            }
        }
        this.shotsFired = 0;
        this.hitCount = 0;
        this.shipsSunk = 0;
    }


    /**
     * Place one ship randomly on the ocean
     */
    public void placeOneShipRandomly(Ship ship){
        Random rd = new Random();
        int row = 0;
        int column = 0;
        boolean horizontal = false;
        while(!ship.okToPlaceShipAt(row,column,horizontal,this)){
            row = rd.nextInt(10);
            column = rd.nextInt(10);
            horizontal = rd.nextBoolean();
        }
        ship.placeShipAt(row, column, horizontal, this);
    }


    /**
     * Place all 10 ships randomly on the ocean. Place larger ships before smaller ones,
     */
    public void placeAllShipsRandomly(){

        Ship battleship1 = new Battleship();
        Ship cruiser1 = new Cruiser();
        Ship cruiser2 = new Cruiser();
        Ship destroyer1 = new Destroyer();
        Ship destroyer2 = new Destroyer();
        Ship destroyer3 = new Destroyer();
        Ship submarine1 = new Submarine();
        Ship submarine2 = new Submarine();
        Ship submarine3 = new Submarine();
        Ship submarine4 = new Submarine();

        placeOneShipRandomly(battleship1);
        placeOneShipRandomly(cruiser1);
        placeOneShipRandomly(cruiser2);
        placeOneShipRandomly(destroyer1);
        placeOneShipRandomly(destroyer2);
        placeOneShipRandomly(destroyer3);
        placeOneShipRandomly(submarine1);
        placeOneShipRandomly(submarine2);
        placeOneShipRandomly(submarine3);
        placeOneShipRandomly(submarine4);
    }


    /**
     * Return true if the given location contains a ship
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
     * This method updates the number of shots that have been fired, and the number of hits.
     * Once a ship has been ”sunk”, additional shots at its location should return false.
     * @param row
     * @param column
     * @return
     */
    public boolean shootAt(int row, int column){
        this.shotsFired += 1;
        if(!this.ships[row][column].isSunk()){
            if(this.ships[row][column].shootAt(row,column)){
                this.hits[row][column] = "hit";
                this.hitCount += 1;
                if(this.ships[row][column].isSunk()){
                    this.hits[row][column] = "hit";
                    this.shipsSunk += 1;
                }
                return true;
            }
            else{
                this.hits[row][column] = "miss";
                return false;
            }
        }
        else{
            this.hits[row][column] = "sink";
            return false;
        }
        
    }


    /**
     * Get the total shots fired
     * @return
     */
    public int getShotsFired(){
        return this.shotsFired;
    }


    /**
     * Get the number of hits recorded
     * All hits are counted, not just the first time a given square is hit.
     * @return
     */
    public int getHitCount(){
        return this.hitCount;
    }


    /**
     * Returns the number of ships sunk
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
     * Returns true if all the ships have been sunk
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
     * Get the 10x10 array of ships
     * @return
     */
    public Ship[][] getShipArray() {
        return this.ships;
    }


    /**
     * Prints the ocean. 
     * Row numbers should be displayed along the left edge of the array, and column numbers should be displayed along the top. 
     * Numbers should be 0 to 9 
     */
    public void print(){
        EmptySea emptySea = new EmptySea();
        System.out.println("\t 0\t 1\t 2\t 3\t 4\t 5\t 6\t 7\t 8\t 9\n ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
            for (int j=0;j<10;j++){
                if(hits[i][j].equals("hit")||hits[i][j].equals("sink")){
                    System.out.print("\t" + ships[i][j]);
                }
                else if (hits[i][j].equals("miss")){
                    System.out.print("\t" + "-");
                }
                else{
                    System.out.print("\t" + emptySea);
                }
            }
            System.out.println("\n");
        }
    }



}

