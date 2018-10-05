import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * The A_Str<T> class. This class extends AlgorithmSearcher<T>. This class
 * searches a solution through the given searchable according to the A*
 * algorithm by a heuristic function.
 *
 * @param <T>
 *            - generic.
 */
public class A_Str<T> extends AlgorithmSearcher<T> {

	@Override
	/**
	 * The search function.
	 * 
	 * This function searches a solution through the given searchable.
	 * 
	 * @param searchable
	 *            - to search through.
	 * @return - type String, represents the solution.
	 */
	public String search(Searchable<T> searchable) {
		Comparator<State<T>> comparator = new A_StrComparator<T>();

		// open list.
		PriorityQueue<State<T>> queue = new PriorityQueue<>(comparator);
		State<T> initialState = searchable.getInitialState();
		State<T> goalState = searchable.getGoalState();
		initialState.setHeuristicCost(calcHeuristicCost(initialState, goalState));
		goalState.setHeuristicCost(calcHeuristicCost(goalState, goalState));

		String solutionString;
		int size = (int) (10 * (Math.pow(searchable.getSize(), 2)));

		queue.add(initialState);

		int currentCreationTime = 0;
		while (!queue.isEmpty()) {
			currentCreationTime++;
			State<T> currentState = queue.poll();

			if (currentState.getDepth() > size) {
				continue;
			}

			if (currentState.equals(goalState)) {
				Solution<T> solution = new Solution<T>(currentState);
				solutionString = solution.getSolutionString() + " " + String.valueOf((int) currentState.getCost());
				return solutionString;
			}

			// create neighbors.
			List<ValuePoint> neighbors = searchable.getAllPossibleStates(currentState);
			for (ValuePoint neighbor : neighbors) {
				double cost = calcCost(neighbor, currentState.getCost());
				Character value = neighbor.getValue();
				if (!checkDP(queue, neighbor)) {
					State<T> state = new State<T>((T) value, cost, currentState, neighbor.getPoint());
					state.setHeuristicCost(calcHeuristicCost(state, goalState));
					state.setDepth(currentState.getDepth() + 1);
					state.setCreationTime(currentCreationTime);
					queue.add(state);
				}
			}
		}

		solutionString = "no path";
		return solutionString;
	}

	/**
	 * The calcHeuristicCost function. This function calculates the heuristic
	 * cost - the max between x1 - x2 and y1 - y2.
	 * 
	 * @param state
	 *            - type State, the current state.
	 * @param goalState
	 *            - type State, the goal state.
	 * @return - type double, the heuristic cost.
	 */
	public double calcHeuristicCost(State<T> state, State<T> goalState) {
		Point position = state.getPosition();
		Point goalPosition = goalState.getPosition();
		int xDistance = goalPosition.getX() - position.getX();
		int yDistance = goalPosition.getY() - position.getY();
		return Integer.max(xDistance, yDistance);
	}

}
