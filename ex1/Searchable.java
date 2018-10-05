import java.util.List;

/**
 * The Searchable interface.
 * This interface defines functions about the searchable.
 *
 * @param <T>
 *            - generic.
 */
public interface Searchable<T> {

	/**
	 * The getInitialState function. This function returns the initial state of
	 * the searchable.
	 * 
	 * @return - type State, the initial state of the searchable.
	 */
	public State<T> getInitialState();

	/**
	 * The getGoalState function. This function returns the goal state of the
	 * searchable.
	 * 
	 * @return - type State, the goal state of the searchable.
	 */
	public State<T> getGoalState();

	/**
	 * The getAllPossibleStates function. This function calculates the neighbors
	 * of the given state.
	 * 
	 * @param state
	 *            - type State, the state to create the neighbors from.
	 * @return - type List<ValuePoint>, the state's neighbors.
	 */
	public List<ValuePoint> getAllPossibleStates(State<T> state);

	/**
	 * The getGoalState function. This function returns the size of the
	 * searchable.
	 * 
	 * @return - type int, the size of the searchable.
	 */
	public int getSize();
}
