import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DriverTest {

	private static Shape rect, rect2, rightTri;
	private static Driver driver;
	
	//Setup objects with predefined values
	@Before
	public void setup()
	{
		rect = new Shape(5, 3, "&", "RE");
		rect2 = new Shape(6, 4, "$", "LT");
		rightTri = new Shape(4, 7, "#", "RT");
	}

	//Tear down objects
	@After
	public void teardown()
	{
		rect = null;
		rect2 = null;
		rightTri = null;	
	}
	
	//Test each aspect of different objects to make sure they're returning the appropriate values
	@Test
	public void testShapeAttributes()
	{
		assertTrue(rect.getAppearance() == "&");
		assertTrue(rect2.getHeight() == 4);
		assertFalse(rightTri.getWidth() == 7);
		assertTrue(rect.getShapeType() == "RE");
	}

	//Test calcResult to see if the program recognizes that one object is named as a rectangle
	//but set as a left triangle.
	@Test
	public void testCalcResults() {
		boolean actualType = true;
		assertTrue(driver.calcResults(rect) == 1);
		assertTrue(driver.calcResults(rect2) == 1);//This should have failed here since rect2 should be RE not LT
		
		if(actualType = ofTypeRect(rect2))
		{
			System.out.println("Shape type of rect2 is RE");
		}
		
		//Should show that rect2 who has a shape type of RT should not be a rectangle or named as one.
		System.out.println("Shape type of rect2 is not RE but is " + rect2.getShapeType());
		assertFalse(rect2.getShapeType() == "RE");
	}
	
	//Boolean method to get a true or false value from a shape
	public boolean ofTypeRect(Shape shape)
	{
		if (shape.getShapeType() == "RE")
		{
			return true;
		}
		return false;
		
	}

}
