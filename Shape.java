
public class Shape {

	private String appearance;
	private int width;
	private int height;
	
	public Shape(int w, int h, String a)
	{
		width = w;
		height = h;
		appearance = a;
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
}
