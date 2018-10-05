import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Solution class.
 * This class creates a solution for the Searchable from the
 * goal state.
 *
 * @param <T>
 *            - generic.
 */
public class Solution<T> {
	// members
	private List<State<T>> solution;
	private String solutionString;

	// constructor
	public Solution(State<T> state) {
		this.solution = new ArrayList<State<T>>();

		setSolution(state);
	}

	/**
	 * The setSolution function. This function creates a solution from a given
	 * state.
	 * 
	 * @param state
	 *            - type State, the state to create the solution from.
	 */
	private void setSolution(State<T> state) {

		while (state != null) {
			this.solution.add(state);
			state = state.getCameFrom();
		}
		Collections.reverse(this.solution);
	}

	/**
	 * The getSolutionString function. This function builds a solution string
	 * represents the solution.
	 * 
	 * @return - type String, the solution string.
	 */
	public String getSolutionString() {

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < this.solution.size() - 1; i++) {
			State<T> state1 = this.solution.get(i);
			State<T> state2 = this.solution.get(i + 1);
			Point point1 = state1.getPosition();
			Point point2 = state2.getPosition();

			int x1 = point1.getX();
			int y1 = point1.getY();
			int x2 = point2.getX();
			int y2 = point2.getY();

			if (x2 == x1 - 1) {
				if (y2 == y1 - 1) {
					stringBuilder.append("LU");
				} else if (y2 == y1) {
					stringBuilder.append("L");
				} else if (y2 == y1 + 1) {
					stringBuilder.append("LD");
				}
			}
			if (x2 == x1) {
				if (y2 == y1 - 1) {
					stringBuilder.append("U");
				} else if (y2 == y1 + 1) {
					stringBuilder.append("D");
				}
			}
			if (x2 == x1 + 1) {
				if (y2 == y1 - 1) {
					stringBuilder.append("RU");
				} else if (y2 == y1) {
					stringBuilder.append("R");
				} else if (y2 == y1 + 1) {
					stringBuilder.append("RD");
				}
			}
			stringBuilder.append("-");
		}

		if (stringBuilder.length() > 0) {
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		}

		this.solutionString = stringBuilder.toString();

		return solutionString;
	}

}
