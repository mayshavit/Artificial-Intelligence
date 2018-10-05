/**
 * The ValuePoint class.
 * This class extends the Point class, and has a value member.
 */
public class ValuePoint extends Point {

	// members
	private char value;

	// constructor
	public ValuePoint(int x, int y, char value) {
		super(x, y);
		this.setValue(value);
	}

	/**
	 * The getValue function. This function returns the value member of the
	 * class.
	 * 
	 * @return - type char, the value member of the class.
	 */
	public char getValue() {
		return value;
	}

	/**
	 * The setValue function. This function sets the value member of the class.
	 * 
	 * @param value
	 *            - type char, the value to be set to.
	 */
	public void setValue(char value) {
		this.value = value;
	}

	/**
	 * The getPoint function. This function returns the point of the class.
	 * 
	 * @return - type Point, the point of the class.
	 */
	public Point getPoint() {
		return new Point(this.x, this.y);
	}
}
