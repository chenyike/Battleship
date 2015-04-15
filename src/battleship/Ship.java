/**
 * HW11 Yike Chen and Hao Liu
 */

package battleship;

abstract class Ship {
	private int bowRow;
	private int bowColumn;
	private int length;
	private boolean horizontal;
	private boolean [] hit = new boolean[4];


	/**
	 * Returns the length of this particular ship. This method exists only to be overridden, 
	 * @return length
	 */
	public int getLength(){
		return this.length;
	}


	/**
	 * @return the bowRow
	 */
	public int getBowRow() {
		return this.bowRow;
	}


	/**
	 * @return the hit
	 */
	public boolean[] getHit() {
		return hit;
	}


	/**
	 * @param hit the hit to set
	 */
	public void setHit(boolean[] hit) {
		this.hit = hit;
	}


	/**
	 * @param Set length
	 */
	public void setLength(int length) {
		this.length = length;
	}


	/**
	 * @param bowRow the bowRow to set
	 */
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}


	/**
	 * @return the bowColumn
	 */
	public int getBowColumn() {
		return this.bowColumn;
	}


	/**
	 * set the bowColumn
	 */
	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}


	/**
	 * @return the horizontal
	 */
	public boolean isHorizontal() {
		return this.horizontal;
	}


	/**
	 * @param set the horizontal to be true or false
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}


	/**
	 * abstract method, simply get the ship's type
	 */
	abstract String getShipType();


	/**
	 * Determine whether it is ok to put a ship. Returns true if it is okay 
	 * to put a ship of this length with its bow in this location, with the given orientation, and returns false otherwise. 
	 * The ship must not overlap another ship, or touch another ship (vertically, horizontally, or diagonally), 
	 * and it must not ”stick out” beyond the array. Does not actually change either the ship or the Ocean, just says whether it is legal to do so.
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 * @return a boolean either true or false
	 */
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean){
		int Row = row;
		int Column = column;
		int endRow;
		int endColumn;
		if (!horizontal){
			endRow = Row + this.length-1;
			endColumn = Column;
		}
		else{
			endRow = Row;
			endColumn = Column + this.length-1;
		}
		//if the ship is not within range of the sea, return false
		//if the ship is within the range of the sea, we need to further check the ship's peripheral space.
		if ( (Row >= 0) &&(Column>=0)&& (endColumn <= 9)&&(endRow<= 9) ){
			int n=0;
			//check if the ship itself is overlapped with other ships
			for (int c = Column; c <= endColumn; c++ ){
				for (int r =Row; r <= endRow; r++){
					if(ocean.isOccupied(r, c)){
						n ++;
					}
				}
			}
			//if any part of the ship itself overlaps with other ships, return false
			if (n>0){
				return false;
			}
			//when the ship is within range, check the ship's peripheral space
			else{
				for (int c = Column-1; c <= endColumn+1; c++ ){
					for (int r =Row-1; r <= endRow+1; r++){
						if (c>=0 && c<=9 && r>=0 &&r<=9){
							if(ocean.isOccupied(r, c)){
								n ++;
							}
						}
					}
				}
				//this ensures that no ships are immediately adjacent to each other, either horizontally, vertically, or diagonally
				if (n>0){
					return false;
				}
				return true;
			}
		}
		return false;
	}


	/**
	 * Puts the ship in the ocean. This involves giving values to the bowRow, bowColumn, and horizontal instance variables in the ship, 
	 * and it also involves putting a reference to the ship in each of 1 or more locations (up to 4) in the ships array in the Ocean object. 
	 * (Note: This will be as many as four identical references; you can’t refer to a ”part” of a ship, only to the whole ship.)
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 */
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean){
		int L = this.getLength();
		this.setBowRow(row);
		this.setBowColumn(column);
		this.setHorizontal(horizontal);
		if(horizontal){
			for (int i = column; i < column + L; i ++){
				ocean.getShipArray()[row][i] = this;
			}	
		}
		else{
			for (int i = row; i <row + L; i++){
				ocean.getShipArray()[i][column] = this;
			}
		}
	}


	/**
	 * If a part of the ship occupies the given row and column, and the ship hasn’t been sunk, 
	 * mark that part of the ship as ”hit” (in the hit array, 0 indicates the bow) and return true, otherwise return false.
	 * @param row
	 * @param column
	 * @return a boolean
	 */
	public boolean shootAt(int row, int column){
		int L = this.getLength();
		if(!this.isSunk()){
			if(this.isHorizontal()){
				if(row == this.getBowRow() && column >= this.getBowColumn()
						&& column <L + this.getBowColumn()){
					this.hit[column - this.getBowColumn()] = true;
					return true;
				}
			}
			else{
				if(row >= this.getBowRow() && row < this.getBowRow()+L
						&& column == this.getBowColumn()){
					this.hit[row - this.getBowRow()] = true;
					return true;
				}
			}
		}
		return false;
	}


	/**
	 * Return true if all the parts of the ship is hit
	 * @return
	 */
	public boolean isSunk(){
		int L = this.getLength();
		for (int i = 0; i < L; i++){
			if(!this.hit[i]){
				return false;
			}
		}
		return true;
	}


	/**
	 * Returns a single-character String to use in the Ocean’s print method (see below).
	 * This method should return ”x” if the ship has been sunk, ”S” if it has not been sunk. 
	 * This method can be used to print out locations in the ocean that have been shot at; 
	 * it should not be used to print locations that have not been shot at.
	 */
	@Override
	public String toString(){
		if(this.isSunk()){
			return "x";
		}
		else{
			return "S";
		}
	}

}

