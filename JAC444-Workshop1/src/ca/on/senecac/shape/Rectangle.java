package ca.on.senecac.shape;

import java.security.InvalidParameterException;

/**
 * Rectangle class.
 * 
 * @author Thomas
 *
 */
public class Rectangle extends Parallelogram{
	
	/**
	 * Rectangle Object constructor. The constructor throws 
	 * an exception if any of the parameters are invalid.
	 * A Rectangle extends a Parallelogram Object.
	 * The width and height must be greater than 0.
	 * 
	 * @param width the width of the Rectangle
	 * @param height the height of the Rectangle
	 * @throws InvalidParameterException
	 * @see Parallelogram#Parallelogram(double, double)
	 */
	public Rectangle(double width, double height) throws InvalidParallelogramException{
		super(width, height);
	}
	
	/**
	 * Returns whether this Rectangle is equal to the passed Rectangle.
	 * Two Rectangles are equal if all their data members are the same.
	 * 
	 * @param other	the other Rectangle to compare
	 * @return	whether this Rectangle is equal to the passed Rectangle
	 */
	public boolean equals(Rectangle other) {
		return (this.getHeight() == other.getHeight() && this.getWidth() == other.getWidth());
	}
	

}