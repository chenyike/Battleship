package battleship;

public class EmptySea extends Ship {
	
	public EmptySea() {
		// TODO Auto-generated constructor stub
		this.setLength(1); 
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
		 return "emptySea";
	 }
	 
	 @Override
	public String toString() {
		// TODO Auto-generated method stub
		return ".";
	}
}
