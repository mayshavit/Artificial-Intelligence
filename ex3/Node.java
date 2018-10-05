/**
 * The Node class.
 * This class represents the state of each node of the cluster.
 */
public class Node {

	// members
	private double x;
	private double y;

	// constructor
	public Node(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * The getX function.
	 * This function returns the x member of the class.
	 * 
	 * @return - x, type int, the x member of the class.
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * The getY function.
	 * This function returns the y member of the class.
	 * 
	 * @return - y, type int, the y member of the class.
	 */
	public double getY() {
		return this.y;
	}

}
