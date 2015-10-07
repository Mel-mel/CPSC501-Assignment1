import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DriverTest {

	Shape rect, leftTri, rightTri;
	
	@Before
	public void setup()
	{
		rect = new Shape(5, 3, "&");
		leftTri = new Shape(6, 4, "$");
		rightTri = new Shape(4, 7, "#");
	}

	@After
	public void teardown()
	{
		rect = null;
		leftTri = null;
		rightTri = null;	
	}
	
	@Test
	public void testShapeAttributes()
	{
		assertTrue(rect.getAppearance() == "&");
		assertTrue(leftTri.getHeight() == 4);
		assertFalse(rightTri.getWidth() == 7);
		
	}

}
