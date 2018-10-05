import java.util.Collection;

/**
 * The AlgorithmSearcher class implements the Searcher interface. This is an
 * abstract class that has 2 functions: calcCost - for calculating the cost.
 * checkDP - for checking duplicate pruning in the open list.
 *
 * @param <T>
 *            - generic.
 */
public abstract class AlgorithmSearcher<T> implements Searcher<T> {

	/**
	 * The calcCost function. This function calculates the state's cost.
	 * 
	 * @param point
	 *            - the state's position.
	 * @param costState
	 *            - the cost of the state's came from.
	 * @return - type double, the state's cost.
	 */
	protected double calcCost(ValuePoint point, double costState) {
		double cost = 0;
		char character = point.getValue();

		switch (character) {
		case 'S':
			cost = 0;
			break;
		case 'G':
			cost = costState;
			break;
		case 'R':
			cost = costState + 1;
			break;
		case 'D':
			cost = costState + 3;
			break;
		case 'H':
			cost = costState + 10;
			break;
		case 'W':
			cost = -1;
			break;
		default:
			break;
		}

		return cost;
	}

	/**
	 * The checkDP function. This function checks duplicate pruning in the open
	 * list.
	 * 
	 * @param collection
	 *            - type Collection, the open list.
	 * @param currentStatePoint
	 *            - type Point, the state's position.
	 * @return - type boolean, true if there is a duplicate pruning, false
	 *         otherwise.
	 */
	protected boolean checkDP(Collection<State<T>> collection, Point currentStatePoint) {
		for (State<T> state : collection) {
			if (state.getPosition().equals(currentStatePoint)) {
				return true;
			}
		}

		return false;
	}
}
