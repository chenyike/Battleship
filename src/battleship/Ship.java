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


	public int getLength() {
		// TODO Auto-generated constructor stub
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
	 * @param bowColumn the bowColumn to set
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
	 * @param horizontal the horizontal to set
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	/**
	 * abstract method
	 */
	abstract String getShipType();

	/**
	 * Return true if it is okay to put a ship in the ocean
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 * @return
	 */
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean){
		int Row = row;
		int Column = column;
		int endRow;
		int endColumn;
		if (!horizontal){
			endRow = Row + this.length;
			endColumn = Column;
		}
		else{
			endRow = Row;
			endColumn = Column + this.length;
		}
		//if the ship within range of the sea
		if ( (Row >= 0) &&(Column>=0)&& (endColumn <= 9)&&(endRow<= 9) ){
			int n=0;
			//check if the ship is overlapped with other ships
			for (int c = Column; c <= endColumn; c++ ){
				for (int r =Row; r <= endRow; r++){
					if(ocean.isOccupied(r, c)){
						n ++;
					}
				}
			}
			//if any part of the ship overlaps with other ships, return false
			if (n>0){
				return false;
			}
			//when the ship is within range, check peripheral
			else{
				for (int c = Column-1; c <= endColumn+1; c++ ){
					for (int r =Row-1; r < endRow+1; r++){
						if (c>=0 && c<=9 && r>=0 &&r<=9){
							if(ocean.isOccupied(r, c)){
								n ++;
							}
						}
					}
				}
				if (n>0){
					return false;
				}
				else{
					return true;
				}
			}
		}
		else{
			return false;
		}
	}


	/**
	 * Puts the ship in the ocean
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
	 * Whether shoot at a ship
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean shootAt(int row, int column){
		int L = this.getLength();
		if(!this.isSunk()){
			if(this.isHorizontal()){
				if(row == this.getBowRow() && column >= this.getBowColumn() && column <L + this.getBowColumn()){
					this.hit[column - this.getBowColumn()] = true;
					return true;
				}
			}
			else{
				if(row >= this.getBowRow() && row < this.getBowRow()+L && column == this.getBowColumn()){
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
	 * Return a single-character
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

