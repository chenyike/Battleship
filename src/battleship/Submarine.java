package battleship;

public class Submarine extends Ship{


	public Submarine() {
		// TODO Auto-generated constructor stub
		this.setLength(1);
		this.setHit(new boolean[] {false,false,false,false}); 
	}
	
	
	@Override
	 public String getShipType() {
		 return "submarine";
	 }
	 
	
}
