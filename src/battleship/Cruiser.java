package battleship;

public class Cruiser extends Ship {
	
	String shipType;
	String whichOne;
	int numOfShips;
	
	public Cruiser() {
		// TODO Auto-generated constructor stub
		super();
		this.length = 3;
		this.numOfShips = 2;
		this.shipType = "cruiser";
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
