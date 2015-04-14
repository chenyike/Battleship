package battleship;

public class Cruiser extends Ship{

	public Cruiser() {
		// TODO Auto-generated constructor stub
		this.setLength(3);
		this.setHit(new boolean[] {false,false,false,false}); 
	}
	
	
	@Override
	 public String getShipType() {
		 return "cruiser";
	 }
	 
	
}
