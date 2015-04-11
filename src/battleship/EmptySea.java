package battleship;

public class EmptySea extends Ship {
	
	String shipType;
	String whichOne;
	int numOfShips;
	
	public EmptySea() {
		// TODO Auto-generated constructor stub
		super();
		this.length = 1;
		this.numOfShips = 80;
		this.shipType = "submarine";
	}
	
	@Override
	public boolean shootAt(int row, int column){
		return false;
	}
	
	@Override 
	public boolean isSunk(){
		return false;
	}
	
	 @Override
	 public String getShipType() {
		 return this.shipType;
	 }
	 
	 @Override
	public String toString() {
		// TODO Auto-generated method stub
		return "this is ";
	}
}
