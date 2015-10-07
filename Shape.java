
public class Shape {

	private String appearance, shapeType;
	private int width, height;
	
	
	public Shape(int w, int h, String a, String type)
	{
		width = w;
		height = h;
		appearance = a;
		shapeType = type;
	}
	
	public String getAppearance()
	{
		return appearance;
	}
	
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	public String getShapeType()
	{
		return shapeType;
	}
}
