package ca.on.senecac.shape;

/**
 * Circle class.
 * 
 * @author Thomas
 */
final public class Circle implements Shape{
	
	protected double  r = 0;
	
	/**
	 * Circle Object construtor. The radius must be greater than 0
	 * otherwise this constructor throws an exception.
	 * Implements the Shape interface.
	 * 
	 * @param radius the radius of the circle
	 * @throws InvalidCircleException
	 * @see Shape
	 */
	public Circle(double radius) throws InvalidCircleException{
		if (radius > 0) {
			this.r = radius;
		} 
		else {
			throw new InvalidCircleException("Invalid radius!");
		}
	}
	
	/**
	 * Returns the perimeter this circle.
	 * 
	 * @return the perimeter this circle
	 */
	public double perimeter() {
		return Math.PI * this.getRadius()*2;
	}

	/**
	 * Returns the area this circle.
	 * 
	 * @return the area this circle
	 */
	public double area() {
		Area area = (r) -> {
			return Math.PI * r[0] * r[0];
		};
		return area.get(this.getRadius()) ;
	}
	
	/**
	 * Returns the string representation of the Circle.
	 * 
	 * @return the string representation of the Circle.
	 */
	public String toString() {
		return String.format("%s {r : %.2f}", this.getClass().getSimpleName(),this.getRadius());
	}
	
	/**
	 * Returns whether this Circle is equal to the passed Circle.
	 * Two circles are equal if their radius are the same.
	 * 
	 * @param circle the Circle to compare
	 * @return whether this circle is equal to the passed circle 
	 */
	public boolean equals(Circle circle) {
		return (this.getRadius() == circle.getRadius());
	}
	
	/**
	 * Sets the radius this circle.  The radius must be greater than 0
	 * otherwise the function throws an Exception.
	 * 
	 * @param radius the new radius of the circle 
	 * @throws InvalidCircleException
	 */
	public void setRadius(double radius) throws InvalidCircleException{
		if (radius > 0) {
			this.r = radius;
		} 
		else {
			throw new InvalidCircleException("Invalid radius!");
		}
	}
	
	/**
	 * Returns the radius this circle.
	 * 
	 * @return the radius this circle
	 */
	public double getRadius() {
		return this.r;
	}
}