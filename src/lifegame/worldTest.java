package lifegame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class worldTest {
	private static world theWorld=new world();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWorld() {
		assertEquals(800,theWorld.getHeight());
		assertEquals(1000,theWorld.getWidth());
	}

	@Test
	public void testSetRandom() {
		fail("尚未实现");
	}

	@Test
	public void testSetSquare() {
		theWorld.setSquare();
		for(int i=10;i<30;i++)
		{
			assertEquals(1,theWorld.allNum[i][16]);
			assertEquals(1,theWorld.allNum[i][35]);
		}
		for(int i=16;i<35;i++)
		{
			assertEquals(1,theWorld.allNum[10][i]);
			assertEquals(1,theWorld.allNum[29][i]);
		}
	}

	@Test
	public void testSetRectangle() {
		theWorld.setRectangle();
		assertEquals(1,theWorld.allNum[10][20]);
		for(int i=1;i<=10;i++)
		{
			assertEquals(1,theWorld.allNum[10+i][20+i]);
			assertEquals(1,theWorld.allNum[10+i][20-i]);
		}
		for(int i=0;i<20;i++)
		{
			assertEquals(1,theWorld.allNum[20][10+i]);
		}
		
	}
	
	@Test
	public void testisAlive() {
		theWorld.setSquare();
		
		
	}
	
	@Test
	public void testNextState() {
		fail("尚未实现");
	}

}
