package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OceanTest {
	private Ship[][] ships = new Ship[10][10];
	private Ship emptySea = new EmptySea();
	private Ocean ocean = new Ocean();
	private Battleship battleship1 = new Battleship();

	@Before
	public void setUp() throws Exception {
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				this.ships[i][j] = emptySea;
			}
		}
		this.ocean.getShipArray()[0][0]=battleship1;
		this.ocean.getShipArray()[1][0]=battleship1;
		this.ocean.getShipArray()[2][0]=battleship1;
		this.ocean.getShipArray()[3][0]=battleship1;
	}

	@Test
	public void testisOccupied() {
		assertTrue(ocean.isOccupied(0,0));
		assertFalse(ocean.isOccupied(0,9));
		assertFalse(ocean.isOccupied(9,9));
		assertFalse(ocean.isOccupied(4,4));
	}

	@Test
	public void testShootAt() {
		ocean.getShotsFired();
		ocean.getHitCount();
		ocean.getShipsSunk();
		
		//check if the ship has been hit but not sunk yet, shootAt will return true
		System.out.println(ocean.getShotsFired());
		battleship1.shootAt(0, 0);
		battleship1.shootAt(1, 0);
		System.out.println(ocean.getShotsFired());
		assertTrue(battleship1.shootAt(2, 0));

		//check if the ship has been hit on the same spot, shootAt will return true
		assertTrue(battleship1.shootAt(2, 0));

		//check if the ship has not been hit, shootAt will return false
		assertFalse(battleship1.shootAt(2, 2));

		//check if the ship is been hit and sunk, shootAt will return true 
		boolean isShot = battleship1.shootAt(3, 0);
		assertTrue(isShot);

		//check if the ship is been sunk, shootAt will return false 
		boolean isShot2 = battleship1.shootAt(3, 0);
		assertFalse(isShot2);





	}

}
