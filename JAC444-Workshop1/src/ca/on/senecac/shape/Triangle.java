package ca.on.senecac.shape;

import java.security.InvalidParameterException;
/**
 * Triangle class.
 * 
 * @author Thomas
 *
 */
final public class Triangle implements Shape{
	
	protected double s1 = 0;
	protected double s2 = 0;
	protected double s3 = 0;
	
	/**
	 * Triangle Object constructor.  All sides must be greater than 0 and the sum of any two sides
	 * must be greater the third side. Throws an Exception otherwise.
	 * 
	 * @param side1
	 * @param side2
	 * @param side3
	 * @throws InvalidParameterException
	 * @see Shape
	 */
	public Triangle(double side1, double side2, double side3) throws InvalidParameterException {
		if (side1 < 0 || side2 < 0 || side3 <0 || side1 + side2 <= side3 ||
				side1 + side3 <= side2 || side3 + side2 <= side1) {
			throw new InvalidParameterException("Invalid side(s)!");
		}
		else {
			s1 = side1;
			s2 = side2;
			s3 = side3;
		}
	}
	
	/**
	 * Returns the perimeter of this Triangle.
	 * 
	 * @return the perimeter of this Triangle
	 */
	public double perimeter() {
		return getSide1()+getSide2()+getSide3();
	}
	
	/**
	 * Returns the area this Triangle
	 * 
	 * @return the area this Triangle
	 */
	public double area() {
		Area area = (p) -> {	
			return Math.sqrt(p[0]*(p[0]-p[1])*(p[0]-p[2])*(p[0]-p[3]));
		};
		return area.get(this.perimeter(),this.getSide1(),
				this.getSide2(), this.getSide3()
		);
	}
	
	/**
	 * Returns the string representation of this Triangle.
	 * 
	 * @return the perimeter of this Triangle
	 */
	public String toString() {
		return String.format("%s {s1 : %.2f, s2 : %.2f, s3 : %.2f}", this.getClass().getSimpleName(),
				this.getSide1(), this.getSide2(), this.getSide3());
	}
	
	/**
	 * Returns whether this Triangle is the same as the other Triangle.
	 * Two triangles are equal if all three corresponding sides are the same.
	 * 
	 * @param other
	 * @return whether the two triangles are the same
	 */
	public boolean equals(Triangle other) {
		
		return (getSide1() == other.getSide1() && 
				getSide2() == other.getSide2() &&
				getSide3() == other.getSide3());
	}
	
	/**
	 * Sets all three sides of this Triangle to the passed values.
	 * All values must be greater than 0 and the sum of any two sides
	 * must be greater than the third side. Throws an Exception otherwise.
	 * 
	 * @param side1
	 * @param side2
	 * @param side3
	 * @throws InvalidParameterException
	 */
	public void setSides(double side1, double side2, double side3) throws InvalidParameterException{
		if (side1 < 0 || side2 < 0 || side3 <0 || side1 + side2 <= side3 ||
				side1 + side3 <= side2 || side3 + side2 <= side1) {
			throw new InvalidParameterException("Invalid side(s)!");
		}
		else {
			s1 = side1;
			s2 = side2;
			s3 = side3;
		}
	}
	
	/**
	 * Returns an array containing the three sides of this Triangle.
	 * 
	 * @return an array with the three sides of this Triangle
	 */
	public double[] getSides() {
		double temp[] = {getSide1(), getSide2(), getSide3()};
		return temp;
	}
	
	/**
	 * Sets the value for side1. The value must be greater than 0 
	 * and the sum of any two sides must be greater than the third side
	 * with the new value. Throws an exception otherwise.
	 * 
	 * @param side1
	 * @throws InvalidParameterException
	 */
	public void setSide1(double side1) throws InvalidParameterException{
		setSides(side1, s2,s3);
	}
	
	/**
	 * Returns the value of side1 for this Triangle.
	 * 
	 * @return side1 of this Triangle
	 */
	public double getSide1() {
		return s1;
	}
	
	/**
	 * Sets the value for side2. The value must be greater than 0 
	 * and the sum of any two sides must be greater than the third side
	 * with the new value. Throws an exception otherwise.
	 * 
	 * @param side2
	 * @throws InvalidParameterException
	 */
	public void setSide2(double side2) throws InvalidParameterException{
		setSides(s1, side2,s3);
	}

	/**
	 * Returns the value of side2 for this Triangle.
	 * 
	 * @return side2 of this Triangle
	 */
	public double getSide2() {
		return s2;
	}
	
	/**
	 * Sets the value for side3. The value must be greater than 0 
	 * and the sum of any two sides must be greater than the third side
	 * with the new value. Throws an exception otherwise.
	 * 
	 * @param side3
	 * @throws InvalidParameterException
	 */
	public void setSide3(double side3) throws InvalidParameterException{
		setSides(s1, s2,side3);
	}
	
	/**
	 * Returns the value of side3 for this Triangle.
	 * 
	 * @return side3 of this Triangle
	 */
	public double getSide3() {
		return s3;
	}
	

}