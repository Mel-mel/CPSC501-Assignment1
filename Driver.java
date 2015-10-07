//Last Name: Ta                                                                                                                                             
//First Name: Melissa                                                                                                                                       
//Student ID: 10110850                                                                                                                                      
//Course: CPSC 233                                                                                                                                          
//Tutorial Section: 05 
//Assignment: 2
//This program draws 2D shapes of a rectangle, a left triangle, and a right triangle. The programs takes in an input file and extracts the components into differet variables so that they can be passed into the Draw class. The Driver class will take be creating objects to draw the shapes. I also used the code from James Tam's website to read the input file for this assignment (I do not own his code). I was not able to draw the right triangle properly.
import java.io.*;

/*
  Author:  James Tam
  Version: Jan 21, 2013

  External source code used:
  * Getting the command-line input
  * Reading from file
  * Converting the lines from file to numeric form.
*/

public class Driver
{
	private static String SHAPE_TYPE_RECT = null;
	private static String SHAPE_TYPE_LEFTTRI = null;
	private static String SHAPE_TYPE_RIGHTTRI = null;
	private static FileReader fr = null;
    private static BufferedReader br = null;
    private static String filename = null;
    private static String lineFromFile = null;
    private static boolean finished = false;
    
	private static char appearanceRect;
	private static int width;
	private static int height;
	private static char appearanceLeftTri;
	private static int size_Left_Tri;
	private static char appearanceRightTri;
	private static int size_right_tri;
    
    public static void main(String [] args) throws Exception
    {
		readFromFile(args);
		
		extractRectContent();
		extractLeftTriContent();
		extractRightTriContent();
		
     		
				
		//Creates new rectangle object.		
		Draw aRectangle = new Draw();
		aRectangle.drawRectangle(appearanceRect, width, height);
                //Create new Left triangle object.
                Draw aLeftTri = new Draw();
                aLeftTri.drawLeftTriangle(appearanceLeftTri, size_Left_Tri);
                //Creates new Right triangle object.
		Draw aRightTri = new Draw();
		aRightTri.drawRightTriangle(appearanceRightTri, size_right_tri);
		//Displays the results for the drawings.
		Draw some_results = new Draw();
		some_results.showResults(SHAPE_TYPE_RECT, SHAPE_TYPE_LEFTTRI, SHAPE_TYPE_RIGHTTRI);
      
    }
    
    
    
 	//This is to extract the components for the rectangle.
	public static void extractRectContent() throws IOException
	{
		String aLine = lineFromFile;
		String appearanceStringRect = "a";
		appearanceStringRect = aLine.substring(2, 4);
		String heightStringRect = aLine.substring(3, 4);
		String widthStringRect = aLine.substring(4);
		height = Integer.parseInt(heightStringRect);//Converts height into an integer.
		width = Integer.parseInt(widthStringRect);//Converts the width into an integer.
		appearanceRect = appearanceStringRect.charAt(0);//Converts the appearance to a character.
		SHAPE_TYPE_RECT = aLine.substring(0, 2);
		lineFromFile = br.readLine();
	}
	
		
	//This is to extract the components for the Left Triangle.
	public static void extractLeftTriContent() throws IOException
	{
		String aLine2 = lineFromFile;
		String appearanceStringLeftTri = "l";
		appearanceStringLeftTri = aLine2.substring(2, 4);
		String sizeStringLeftTri = aLine2.substring(3, 4);
		size_Left_Tri = Integer.parseInt(sizeStringLeftTri);//Converts variable to an integer.
		appearanceLeftTri = appearanceStringLeftTri.charAt(0);//Converts to the variable to a character.
		SHAPE_TYPE_LEFTTRI= aLine2.substring(0, 2);
		lineFromFile = br.readLine();
	}
	
			
	//This is to extract the component for the Right Triangle.
	public static void extractRightTriContent() throws IOException
	{
		String aLine3 = lineFromFile;
		String appearanceStringRightTri = "r";
		appearanceStringRightTri = aLine3.substring(2, 4);
		String sizeStringRightTri = aLine3.substring(3, 4);
		size_right_tri = Integer.parseInt(sizeStringRightTri);//Converts the size into an integer.
		appearanceRightTri = appearanceStringRightTri.charAt(0);//Converts the appearance into a character.
		SHAPE_TYPE_RIGHTTRI = aLine3.substring(0, 2);
		//System.out.println(shape_type_RightTri);
		//System.out.println(sizeStringRightTri);
		lineFromFile = br.readLine();
	}
	// JT: The first and only input to the program (after name of Java 
 	// file) must be the name of the input file.
 	public static void readFromFile(String [] args) throws Exception
 	{
 	    if (args.length != 1)
 	        System.out.println("Usage:java Guessing <name of input file>");
 	    else
 	    {
 	        filename = args[0];
 			printBanner();
 		
 			fr = new FileReader(filename);
 		    br = new BufferedReader(fr);
 		    lineFromFile = br.readLine();
 		
 		    // JT: Empty input file
 		    if (lineFromFile == null)
 		    {
 		        System.out.println("Empty input file: no guesses to play with");
 		        finished = true;
 		    }
 	    }
 	}
	
    //This is the my banner.
  	public static void printBanner()
  	{
  	
  		System.out.println("Last Name: Ta");
  		System.out.println("First Name: Melissa");
  		System.out.println("Student ID: 10110850");
  		System.out.println("Course: CPSC 233");
  		System.out.println("Tutorial Section: 05");
  		System.out.println("Assignment: 2");
  	}
}
