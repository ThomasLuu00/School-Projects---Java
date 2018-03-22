package ca.on.senecac.deliverable;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import ca.on.senecac.shape.*;

public class Deliverable {
	
	final static String FNAME = "shapes.txt";
	final static int MAXSHAPES = 300;
	static Shape shapes[] = new Shape[MAXSHAPES];
	static int len = 0;

	
	/**
	 * Takes a CSV file and reads all the shape information within it.
	 * Stores those Shapes in an array if they are valid, otherwise
	 * this function prints an Exception message to the console.
	 * 
	 * @param fname CSV filename
	 */
	private static void readFile(String fname) {
        try {
        	String line = "";
            FileReader fileReader = new FileReader(fname);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null) {
            	String cell[] = line.split(",");
            	
            	// Add appropriate shape object if the number of parameters are right.
            	// The case strings follow the format:
            	// "nameOfObject" + "numOfTokensInRow"
        		try {
	            	switch (cell[0].toUpperCase() + cell.length) {
	                case "CIRCLE2":
	                	shapes[len] = new Circle(Double.parseDouble(cell[1]));
	                	break;
	                case "RECTANGLE3":
	                	shapes[len] = new Rectangle(Double.parseDouble(cell[1]),Double.parseDouble(cell[2]));
	                	break;
	                case "SQUARE2":
	                	shapes[len] = new Square(Double.parseDouble(cell[1]));
	                	break;
	                case "TRIANGLE4":
	                	shapes[len] = new Triangle(Double.parseDouble(cell[1]),Double.parseDouble(cell[2]),Double.parseDouble(cell[3]));
	                	break;
	                case "PARALLELOGRAM3":
	                	shapes[len] = new Parallelogram(Double.parseDouble(cell[1]),Double.parseDouble(cell[2]));
	                	break;
	                default:
	                	len--;
	                	break;
	            	}
	            	len++;
                }
        		catch(Exception ex) {
        			System.out.println(ex.getMessage());
        		}
            }   
            bufferedReader.close(); 
            Shape[] temp = new Shape[len];
    		for (int x = 0; x < len; x++) {
    			temp[x] = shapes[x];
    		}
    		shapes = temp;
            
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fname + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fname + "'");                  
        }
	}
	
	/**
	 * Displays the number of Shapes stored.
	 */
	private static void displayLength() {
		System.out.println(len + " shapes were created:");
	}
		
	/**
	 * Displays the number of shapes and a list of the Shapes stored.
	 */
	private static void task1() {
        System.out.println("------->Task 1 ... <-------");
        readFile(FNAME);   
        System.out.println();
		displayLength();
        for (int x = 0; x < len; x++) {
        	System.out.println(shapes[x].toString() + "\n");
        }
	}
	
	/**
	 * Removes the saved Circle(s) and Triangle(s) with the maximum and minimum
	 * perimeter(s), respectively. It then displays a list of the Shapes.
	 */
	private static void task2() {
        	
		double minP = Double.MAX_VALUE;
        double maxP = 0;
              
        // Determine the maximum perimeter for Circles and the minimum perimeter
        // for triangles.
        for (int x = 0; x < len; x++) {
        	if (shapes[x] instanceof Triangle && shapes[x].perimeter() < minP) {
        			minP = shapes[x].perimeter();
        	}
        	else if (shapes[x] instanceof Circle && shapes[x].perimeter() > maxP) {
        			maxP = shapes[x].perimeter();       		
        	}
        }	    
        
        int reduce = 0;
        for (int x = 0; x < len; x++) {
        	if ((shapes[x] instanceof Triangle && shapes[x].perimeter() == minP) ||
        			(shapes[x] instanceof Circle && shapes[x].perimeter() == maxP)) {
        			reduce += 1;
        	} 
        	else {
        		shapes[x-reduce] = shapes[x];
        	}
        }
        
        for (int x = len - 1; x >= len -reduce; x--) {
        	shapes[x] = null;
        }
        len -= reduce;
        
        Shape[] temp = new Shape[len];
		for (int x = 0; x < len; x++) {
			temp[x] = shapes[x];
		}
		shapes = temp;
        // Assign the new list back to the original array and print the 
        // Shapes to the console.
        System.out.println("------->Task 2 ... <-------");
        displayLength();
        for (int x = 0; x < len; x++) {
        	System.out.println(shapes[x].toString() + "\n");
        }
        
	}
	
	/**
	 * Displays the sums for the perimeters of Parallelograms and Triangles, seperately.
	 */
	private static void task3() {
		
		double sumPara = 0;
		double sumTri = 0;
		
		// Sums the perimeters of Parallelograms and Triangles seperately.
        for (int x = 0; x < len; x++) {
        	if (shapes[x].getClass() == Parallelogram.class) {
        			sumPara += shapes[x].perimeter();
        	}
        	else if (shapes[x].getClass() == Triangle.class) {
        			sumTri += shapes[x].perimeter();      		
        	}
        }

        // Display total perimeters.
        System.out.println("------->Task 3 ... <-------");        
        System.out.println("Total perimeter of Parallelogram is: " + sumPara);
        System.out.println("Total perimeter of Triangle is: " + sumTri);
	}
	
	/**
	 * Displays the area for Circles, Squares, and Rectangles and the perimeter for
	 * other shapes.
	 */
	private static void task4() {
	
		DisplayShape dspShape = (shape) -> {
			return shape.toString()  + 
					String.format(" Perimeter = %.2f", shape.perimeter()) + (
					(shape.getClass() == Circle.class || 
					shape.getClass() == Square.class || 
					shape.getClass() == Rectangle.class) ? 
					String.format("\n\tArea = %.2f", shape.area()) :
					"")
					;
		};
		
		System.out.print(Arrays.stream(shapes)
				.map(shape -> dspShape.get(shape))
				.reduce("",(a,b) -> a+b+"\n\n")
				);
	}
	public static void main(String[] args) {
		readFile(FNAME);
        System.out.println("------->JAC 444 Assignment 1<-------");			
        //task1();
        //task2();
        //task3();
        task4();
    }
}
