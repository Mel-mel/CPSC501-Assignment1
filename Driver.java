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
    
	private static Shape rectangle, leftTriangle, rightTriangle;
	private static Draw drawShapes = new Draw();
	
	private static String rectangleStr, triangleStr, stringFromLine;
    private static int height, width, triSize;
	
    public static void main(String [] args) throws Exception
    {
		readFromFile(args);
		
		extractRectContent();
		rectangle = new Shape(width, height, rectangleStr);
		drawShapes.drawRectangle(rectangle);
		
		extractTriContent();
    	leftTriangle = new Shape(triSize, triSize, triangleStr);
        drawShapes.drawLeftTriangle(leftTriangle);
        
    	extractTriContent();
    	rightTriangle = new Shape(triSize, triSize, triangleStr);
		drawShapes.drawRightTriangle(rightTriangle);
     		
		//Displays the results for the drawings.
		Draw some_results = new Draw();
		some_results.showResults(SHAPE_TYPE_RECT, SHAPE_TYPE_LEFTTRI, SHAPE_TYPE_RIGHTTRI);
      
    }
    
  //This is to extract the components for the rectangle.
    public static void extractRectContent() throws IOException
    {
		rectangleStr = lineFromFile.substring(2, 3);
		stringFromLine = lineFromFile.substring(3, 4);
		height = Integer.parseInt(stringFromLine);
		stringFromLine = lineFromFile.substring(4);
		width = Integer.parseInt(stringFromLine);//Converts the width into an integer.
		lineFromFile = br.readLine();
		//final String SHAPE_TYPE_RECT = lineFromFile.substring(0, 2);
    }
    
    public static void extractTriContent() throws IOException
    {
    	triangleStr = lineFromFile.substring(2, 3);
    	stringFromLine = lineFromFile.substring(3, 4);
    	triSize = Integer.parseInt(stringFromLine);
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
