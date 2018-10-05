import java.util.Comparator;

/**
 * The A_StrComparator class, implements Comparator. This class implements the
 * compare function.
 *
 * @param <T>
 *            - generic.
 */
public class A_StrComparator<T> implements Comparator<State<T>> {

	@Override
	/**
	 * The compare function. This function compares 2 states by their cost +
	 * their heuristic cost. If equals - compares by their creation time. If
	 * equals - compares by their insertion order.
	 * 
	 * @param state1
	 *            - type State, the first state.
	 * @param state2
	 *            - type State, the second state.
	 */
	public int compare(State<T> state1, State<T> state2) {
		double gCost1 = state1.getCost();
		double gCost2 = state2.getCost();
		double heuristicCost1 = state1.getHeuristicCost();
		double heuristicCost2 = state2.getHeuristicCost();

		double cost1 = gCost1 + heuristicCost1;
		double cost2 = gCost2 + heuristicCost2;

		if (cost1 < cost2) {
			return -1;
		} else if (cost1 > cost2) {
			return 1;
		} else {
			int creationTime1 = state1.getCreationTime();
			int creationTime2 = state2.getCreationTime();
			if (creationTime1 < creationTime2) {
				return -1;
			} else if (creationTime1 > creationTime2) {
				return 1;
			} else {
				return 1;
			}
		}
	}

}
