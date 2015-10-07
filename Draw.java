//Last Name: Ta
//First Name: Melissa
//Student ID: 10110850
//Course: CPSC 233
//Tutorial Section: 05
//Assignment: 2

public class Draw{
    
	private static int width;
	private static int height;
	
    //This is the method that draws the rectangle.
	public void drawRectangle(Shape rectangle){
	    height = rectangle.getHeight() + 1;
	    width = rectangle.getWidth() + 1;
	    //This loop draws the rectangle.
	    for(int p = 1; p < height; p++)
	    {
	    	for (int q = 1; q < width; q++)
	    	{
	    		System.out.print(rectangle.getAppearance());
	    	}
	    	System.out.println("");
	    }
	    System.out.println("");

	}

    //This is the method that draws the Left Triangle.
	public void drawLeftTriangle(Shape leftTri){
		height = leftTri.getHeight();
		width = leftTri.getWidth();
	    //This loop draws the left triangle. It also decrements the width to make the triangle more distinct.
	    for(int j = 0; j < height; j++)
	    {
	    	for(int k = 0; k < width; k++)
	    	{
			    System.out.print(leftTri.getAppearance());
			    
			    System.out.print("");
			}
			width--;//Decreases width.
			System.out.println("");
		}
	    System.out.println("");
	}
    //This method draws the Right Triangle. This loop only draws a rectangle at the moment. Was not able to draw the right triangle properly.
	public void drawRightTriangle(Shape rightTri){
		height = rightTri.getHeight();
		width = rightTri.getWidth();
	    for(int i = 0; i < height; i++)
	    {
	    	for(int j = 0; j < width - 1; j++)
	    	{
	    		System.out.print(" ");
	    	}
	    	width--;
	    	for(int k = height; k > width; k--)
	    	{
	    		System.out.print(rightTri.getAppearance());
	    	}
	    	System.out.println("");
	    }
	}
}