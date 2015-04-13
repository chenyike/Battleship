/**
 * HW11 Yike Chen and Hao Liu
 */

package battleship;

abstract class Ship {
	protected int bowRow;
	protected int bowColumn;
	protected int length;
	protected boolean horizontal;
	protected boolean [] hit = new boolean[4];

	public Ship(){
		super();
	}
	
	
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
		return true;
	}

	/**
	 * Put the ship in the ocean
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 */
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean){
		this.bowRow = row;
		this.bowColumn = column;
		this.horizontal = horizontal;
		
	}

	/**
	 * mark that part of the ship as ”hit” and return true,
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean shootAt(int row, int column){
		return true;
	}

	/**
	 * Return true if every part of the ship has been hit
	 * @return
	 */
	public boolean isSunk(){
		return true;
	}

	@Override
	/**
	 * This method should return ”x” if the ship has been sunk, ”S” if it has not been sunk.
	 */
	public String toString(){
		return "";
	}

}

