package ca.on.senecac.shape;

/**
 * Parallelogram class.
 * 
 * @author Thomas
 */
public class Parallelogram implements Shape{
	protected double w = 0;
	protected double h = 0;
	
	/**
	 * Creates a Parallelogram object. The constructor 
	 * throws an exception if any of the parameters are invalid.
	 * A Parallelogram implements a Shape interface.
	 * The width and height must be greater than 0.
	 * 
	 * @param width the width of the Parallelogram
	 * @param height the height of the Parallelogram
	 * @throws InvalidParameterException
	 * @see Shape 
	 */
	public Parallelogram(double width, double height) throws InvalidParallelogramException {
		if (width>0 && height >0){
			w = width;
			h = height;
		}
		else{
			throw new InvalidParallelogramException("Invalid width!");
		}
	}
	
	/**
	 * Returns the String representation for this Parallelogram.
	 * 
	 *  @return string representation for this parallelogram
	 */
	public String toString() {
		return String.format("%s {w : %.2f, h : %.2f}", this.getClass().getSimpleName(), 
				this.getWidth(), this.getHeight());
	}
	
	/**
	 * Returns whether this Parallelogram is equal to the passed Parallelogram.
	 * Two Parallelograms are equal their corresponding width and heights are the same.
	 * 
	 * @param other	the other Parallelogram to compare
	 * @return	whether this Parallelogram is equal to the passed Parallelogram
	 */
	public boolean equals(Parallelogram parallelogram) {
		return (getHeight() == parallelogram.getHeight() && getWidth() == parallelogram.getWidth());
	}
	
	/**
	 * Returns the area this parallelogram.
	 * 
	 * @return the area this parallelogram
	 */
	public double area() {
		Area area = (p) -> {
			return p[0]*p[1];
		};
		return area.get(this.getWidth(),this.getHeight()) ;
	}
	/**
	 * Returns the perimeter for this Parallelogram.
	 * 
	 * @return the perimeter for this Parallelogram
	 */
	public double perimeter() {
		return getWidth()*2 + getHeight()*2;
	}
	
	
	/**
	 * Set the height for this Parallelogram.
	 * 
	 * @param height the new height for this Parallelogram
	 * @throws InvalidParameterException
	 */
	public void setHeight(double height) throws InvalidParallelogramException {
		if (height>0){
			this.h = height;
		}
		else{
			throw new InvalidParallelogramException("Invalid height!");
		}
	}
	
	/**
	 * Returns the height for this Parallelogram.
	 * 
	 * @return the height for this Parallelogram
	 */
	public double getHeight() {
		return h;
	}
	
	/**
	 * Set the width for this Parallelogram
	 * 
	 * @param width the width for this Parallelogram
	 * @throws InvalidParameterException
	 */
	public void setWidth(double width) throws InvalidParallelogramException {
		if (width>0){
			w = width;
		}
		else{
			throw new InvalidParallelogramException("Invalid width!");
		}
	}
	
	/**
	 * Returns the width for this Parallelogram
	 * 
	 * @return the width for this Parallelogram
	 */
	public double getWidth() {
		return w;
	}
}