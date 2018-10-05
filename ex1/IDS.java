import java.util.List;
import java.util.Stack;

/**
 * The IDS<T> class. This class extends AlgorithmSearcher<T>. This class
 * searches a solution through the given searchable according to the IDS
 * algorithm.
 *
 * @param <T>
 *            - generic.
 */
public class IDS<T> extends AlgorithmSearcher<T> {

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
		int size = (int) Math.pow(searchable.getSize(), 2);
		State<T> initialState = searchable.getInitialState();
		State<T> goalState = searchable.getGoalState();

		for (int depth = 0; depth < size; depth++) {
			State<T> found = IDSIteration(initialState, goalState, searchable, depth);
			if (found != null) {
				Solution<T> solution = new Solution<>(found);
				String solutionString = solution.getSolutionString() + " " + String.valueOf((int) found.getCost());
				return solutionString;
			}
		}

		return "no path";
	}

	/**
	 * The IDSIteration function.
	 * 
	 * This function executes a DFS until the given limit through the given
	 * searchable.
	 * 
	 * @param initialState
	 *            - type State, the initial state of the searchable.
	 * @param goalState
	 *            - type State, the goal state of the searchable.
	 * @param searchable
	 *            - type Searchable, the given searchable.
	 * @param lim
	 *            - type int, the given limit.
	 * @return - type State, the goal state of the searchable if found, null
	 *         otherwise.
	 */
	private State<T> IDSIteration(State<T> initialState, State<T> goalState, Searchable<T> searchable, int lim) {
		Stack<State<T>> stack = new Stack<State<T>>();
		stack.push(initialState);

		while (!stack.isEmpty()) {
			State<T> currentState = stack.elementAt(0);
			stack.remove(0);
			if (currentState.equals(goalState)) {
				return currentState;
			}

			int currentDepth = currentState.getDepth() + 1;
			if (currentDepth > lim) {
				continue;
			}
			List<ValuePoint> neighbors = searchable.getAllPossibleStates(currentState);
			for (ValuePoint neighbor : neighbors) {
				if (!checkDP(stack, neighbor)) {
					Character value = neighbor.getValue();
					double cost = calcCost(neighbor, currentState.getCost());
					State<T> state = new State<T>((T) value, cost, currentState, neighbor.getPoint());
					state.setDepth(currentDepth);
					stack.push(state);
				}
			}
		}

		return null;
	}

}
