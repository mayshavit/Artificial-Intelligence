/**
 * The State class.
 * This class represents the searchable's state.
 *
 * @param <T>
 *            - generic
 */
public class State<T> {
	// members
	private T state;
	private double cost;
	private State<T> cameFrom;
	private double heuristicCost;
	private Point position;
	private int depth;
	private int creationTime;

	// constructor
	public State(T state, double cost, State<T> cameFrom, Point point) {
		this.state = state;
		this.cost = cost;
		this.cameFrom = cameFrom;
		this.position = point;
		this.setDepth(0);
		this.setCreationTime(0);
	}

	/**
	 * The setHeuristicCost function. This function sets the heuristicCost
	 * member of the class.
	 * 
	 * @param heuristicCost
	 *            - type double, the heuristic cost to be set to.
	 */
	public void setHeuristicCost(double heuristicCost) {
		this.heuristicCost = heuristicCost;
	}

	/**
	 * The getPosition function. This function returns the position member of
	 * the class.
	 * 
	 * @return - type Point, the position member of the class.
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * The getHeuristicCost function. This function returns the heuristicCost
	 * member of the class.
	 * 
	 * @return - type double, the heuristicCost member of the class.
	 */
	public double getHeuristicCost() {
		return heuristicCost;
	}

	@Override
	/**
	 * The equals function. This function compares a given state to the class's
	 * state.
	 * 
	 * @param -
	 *            type Object, the state to compare to.
	 * @return - type boolean, true if equals, false otherwise.
	 */
	public boolean equals(Object state) {
		if (state instanceof State) {
			if (this.position.equals(((State<T>) state).getPosition())) {
				return true;
			}
		} else if (state instanceof Point) {
			if (this.position.equals((Point) state)) {
				return true;
			}
		}

		return false;

	}

	/**
	 * The getCost function. This function returns the cost member of the class.
	 * 
	 * @return - type double, the cost member of the class.
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * The getCameFrom function. This function returns the cameFrom member of
	 * the class.
	 * 
	 * @return - type State, the cameFrom member of the class.
	 */
	public State<T> getCameFrom() {
		return cameFrom;
	}

	/**
	 * The getDepth function. This function returns the depth member of the
	 * class.
	 * 
	 * @return - type int, the depth member of the class.
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * The setDepth function. This function sets the depth member of the class.
	 * 
	 * @param depth
	 *            - type int, the depth to be set to.
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * The getCreationTime function. This function returns the creationTime
	 * member of the class.
	 * 
	 * @return - type int, the creationTime member of the class.
	 */
	public int getCreationTime() {
		return creationTime;
	}

	/**
	 * The setCreationTime function. This function sets the creationTime member
	 * of the class.
	 * 
	 * @param creationTime
	 *            - type int, the creation time to be set to.
	 */
	public void setCreationTime(int creationTime) {
		this.creationTime = creationTime;
	}

}
