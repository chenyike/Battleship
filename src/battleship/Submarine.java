package battleship;

public class Submarine extends Ship {
	
	String shipType;
	String whichOne;
	int numOfShips;
	
	public Submarine() {
		// TODO Auto-generated constructor stub
		super();
		this.length = 1;
		this.numOfShips = 4;
		this.shipType = "submarine";
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
