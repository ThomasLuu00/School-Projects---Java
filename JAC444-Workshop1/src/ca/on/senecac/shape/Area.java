package ca.on.senecac.shape;

@FunctionalInterface
public interface Area {
	/**
	 * Returns the area after taking in an array of variables for the area formula.
	 * 
	 * @param params value of variables to be included in the formula.
	 * @return
	 */
	public double get(double... params);
}

