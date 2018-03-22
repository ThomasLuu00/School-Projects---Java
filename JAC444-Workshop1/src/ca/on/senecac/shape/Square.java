package ca.on.senecac.shape;

/**
 * Square class.
 * 
 * @author Thomas
 *
 */
final public class Square extends Rectangle{

	/**
	 * Square Object constructor. The constructor throws 
	 * an error if any of the parameters are invalid.
	 * A Square extends a Rectangle object.
	 * The width and height must be greater than 0.
	 * 
	 * @param side the length of the sides for the Square
	 * @throws InvalidParameterException
	 * @see Rectangle#Rectangle(double,double)
	 */
	public Square (double side) throws InvalidParallelogramException{
		super(side, side);
	}
	
	/**
	 * Returns whether this Rectangle is equal to the passed Rectangle.
	 * Two Rectangles are equal if all their data members are the same.
	 * 
	 * @param other	the other Rectangle to compare
	 * @return	whether this Rectangle is equal to the passed Rectangle
	 */
	public boolean equals(Square other) {
		return (this.getHeight() == other.getHeight() && 
				this.getWidth() == other.getWidth());
	}
	
	/**
	 * Returns the perimeter for this Square.
	 * 
	 * @param return the perimeter for this Square.
	 */
	public double perimeter() {
		return this.getSide()*4;
	}
	
	
	/**
	 * Set the length of the sides for this Square. The length must be
	 * greater than 0 or else this function throws an error.
	 * 
	 * @param side length of sides
	 * @throws InvalidParameterException
	 */
	public void setSide(double side) throws InvalidSquareException {
		if (side>0){
			this.w = side;
			this.h = side;
		}
		else{
			throw new InvalidSquareException("Invalid side!");
		}
	}
	
	/**
	 * Returns the length for this Square's sides.
	 * 
	 * @return length of sides
	 */
	public double getSide() {
		return this.getWidth();
	}
	
	/**
	 * Implemented for completeness. Same functionality as setSide().
	 * 
	 * @param height length of sides
	 * @throws InvalidParameterException
	 * @see Square#setSide(double)
	 */
	final public void setHeight(double height) throws InvalidSquareException {
		this.setSide(height);
	}
	
	/**
	 * Implemented for completeness. Same functionality as setSide().
	 * 
	 * @param width length of sides
	 * @throws InvalidParameterException
	 * @see Square#setSide(double)
	 */
	final public void setWidth(double width) throws InvalidSquareException {
		this.setSide(width);
	}
}