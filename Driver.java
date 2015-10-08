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
  * 
  * What the program does:
  * This takes a command line argument that is a text file. In that text file it contains characters and integers
  * that need to be processed so that they can instantiated into an object that will draw a shape. The program only
  * deals with the specified file "shape.txt" and the content inside it.
*/

public class Driver
{
	private static FileReader fr = null;
    private static BufferedReader br = null;
    private static String filename = null;
    private static String lineFromFile = null;
    private static boolean emptyFile = false;
    
	private static Shape rectangle, leftTriangle, rightTriangle;
	private static Draw drawShapes = new Draw();
	
	private static String rectangleStr, triangleStr, stringFromLine, shapeType;
    private static int height, width, triSize;
	
    public static void main(String [] args) throws Exception
    {
		readFromFile(args);
		
		//Check if the file reading has finished. If it's not then there is an empty file
		//being passed in as a text document so program does not do anything but print
		//an error message.
		if(emptyFile == false)
		{
			extractRectContent();
			rectangle = new Shape(width, height, rectangleStr, shapeType);
			drawShapes.drawRectangle(rectangle);
			
			extractTriContent();
	    	leftTriangle = new Shape(triSize, triSize, triangleStr, shapeType);
	        drawShapes.drawLeftTriangle(leftTriangle);
	        
	    	extractTriContent();
	    	rightTriangle = new Shape(triSize, triSize, triangleStr, shapeType);
			drawShapes.drawRightTriangle(rightTriangle);
	     		
			//Displays the results for the drawings.
			System.out.println("\nTotals for the number of shapes drawn");
			
			showResults();
		}
		else
		{
			System.out.println("Please provide a non-empty text file");
		}
			
	
      
    }
    
    //This prints out the final results after drawing. Determines number of rectangles,
    //left and right triangles.
    public static void showResults()
    {
    	int numOfShape = calcResults(rectangle);
    	System.out.println("Rectangles: " + numOfShape);
    	
    	numOfShape = calcResults(leftTriangle);
    	System.out.println("Left Triangles: " + numOfShape);
    	
    	numOfShape = calcResults(rightTriangle);
		System.out.println("Right Triangles: " + numOfShape);
    }
    
    //This is to extract the components for the rectangle.
    //Parsing through the file it stores the .txt content into variables
    //that are used to make objects for drawing.
    public static void extractRectContent() throws IOException
    {
    	shapeType = lineFromFile.substring(0, 2);
		rectangleStr = lineFromFile.substring(2, 3);
		stringFromLine = lineFromFile.substring(3, 4);
		height = Integer.parseInt(stringFromLine);
		stringFromLine = lineFromFile.substring(4);
		width = Integer.parseInt(stringFromLine);//Converts the width into an integer.
		lineFromFile = br.readLine();
		
    }
    
    //This extracts the components for a left and right triangle
    //Parsing through the file it stores the .txt content into variables
    //that are used to make objects for drawing.
    public static void extractTriContent() throws IOException
    {
    	shapeType = lineFromFile.substring(0, 2);
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
 		        System.out.println("Empty input file");
 		        emptyFile = true;
 		    }
 	    }
 	}
	
 	//This method prints the final results after the program is finished drawing.
 	//It counts the shape type and adds the total number of shapes that have been printed.
    public static int calcResults(Shape shape){
    	int num = 0;
        if(shape.getShapeType() == "RE")
        {
        	num += 1;
        }
        else if(shape.getShapeType() == "LT")
        {
        	num += 1;
        }
        else
        {
        	num += 1;
        }
        return num;
   }
 	
    //This prints out my banner.
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
