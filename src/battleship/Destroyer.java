package battleship;

public class Destroyer extends Ship{


	public Destroyer() {
		// TODO Auto-generated constructor stub
		this.setLength(2);
		this.setHit(new boolean[] {false,false,false,false}); 
	}
	
	
	@Override
	 public String getShipType() {
		 return "destroyer";
	 }
	 
	
}
