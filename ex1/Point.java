/**
 * The Point class.
 * This class represents a point of 2 coordinates.
 */
public class Point {

	// members
	protected int x;
	protected int y;

	// constructor
	public Point(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	/**
	 * The getX function. This function returns the x member of the class.
	 * 
	 * @return - type int, the x member of the class.
	 */
	public int getX() {
		return x;
	}

	/**
	 * The setX function. This function sets the x member of the class.
	 * 
	 * @param x
	 *            - type int, the x's setter.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * The getY function. This function returns the y member of the class.
	 * 
	 * @return - type int, the y member of the class.
	 */
	public int getY() {
		return y;
	}

	/**
	 * The setY function. This function sets the y member of the class.
	 * 
	 * @param y
	 *            - type int, the y's setter.
	 */
	public void setY(int y) {
		this.y = y;
	}

	@Override
	/**
	 * The equals function. This function compares a given point to the point by
	 * x and y.
	 * 
	 * @param point
	 *            - the point to compare to.
	 * @return - type boolean, true if equals, false otherwise.
	 */
	public boolean equals(Object point) {
		if (point instanceof Point) {
			if ((this.x == ((Point) point).getX()) && (this.y == ((Point) point).getY())) {
				return true;
			}
		}
		return false;
	}

}
