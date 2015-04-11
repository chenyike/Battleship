package battleship;

public class Battleship extends Ship {
	
	String shipType;
	String whichOne;
	int numOfShips;
	
	public Battleship() {
		// TODO Auto-generated constructor stub
		super();
		this.length = 3;
		this.numOfShips = 1;
		this.shipType = "Battleship";
	}
	
	public void defineNum(String num){
		this.whichOne = num;
	}
	
	 @Override
	 public String getShipType() {
		 return this.shipType;
	 }
	 
	 @Override
	public String toString() {
		// TODO Auto-generated method stub
		return "this is " + this.shipType + this.whichOne;
	}
}
