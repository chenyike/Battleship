package battleship;

public class Destroyer extends Ship {
	
	String shipType;
	String whichOne;
	int numOfShips;
	
	public Destroyer() {
		// TODO Auto-generated constructor stub
		super();
		this.length = 2;
		this.numOfShips = 3;
		this.shipType = "destroyer";
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
