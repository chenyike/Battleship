package battleship;

public class Battleship extends Ship{
	public Battleship() {
		// TODO Auto-generated constructor stub
		this.setLength(4);
		this.setHit(new boolean[] {false,false,false,false}); 
	}
	
	
	@Override
	 public String getShipType() {
		 return "battleship";
	 }
	 
	
}
