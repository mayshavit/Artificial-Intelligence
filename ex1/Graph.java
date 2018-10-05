import java.util.ArrayList;
import java.util.List;

/**
 * The Graph<T> class. This class implements the Searchable<T> interface. This
 * class represents a searchable object.
 *
 * @param <T>
 *            - generic.
 */
public class Graph<T> implements Searchable<T> {

	// members
	private char[][] graph;
	private int size;
	private State<T> initialState;
	private State<T> goalState;

	// constructor
	public Graph(int size, String board) {
		this.size = size;
		this.graph = new char[this.size][this.size];

		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.graph[j][i] = board.charAt(j + this.size * i);
			}
		}

		Character initialChar = this.graph[0][0];
		Point initialPoint = new Point(0, 0);
		Character goalChar = this.graph[this.size - 1][this.size - 1];
		Point goalPoint = new Point(this.size - 1, this.size - 1);
		this.initialState = new State<T>((T) initialChar, 0, null, initialPoint);
		this.goalState = new State<T>((T) goalChar, 0, null, goalPoint);
	}

	@Override
	/**
	 * The getInitialState function. This function returns the initial state of
	 * the searchable.
	 * 
	 * @return - type State, the initial state of the searchable.
	 */
	public State<T> getInitialState() {
		return this.initialState;
	}

	@Override
	/**
	 * The getGoalState function. This function returns the goal state of the
	 * searchable.
	 * 
	 * @return - type State, the goal state of the searchable.
	 */
	public State<T> getGoalState() {
		return this.goalState;
	}

	@Override
	/**
	 * The getAllPossibleStates function. This function calculates the neighbors
	 * of the given state.
	 * 
	 * @param state
	 *            - type State, the state to create the neighbors from.
	 * @return - type List<ValuePoint>, the state's neighbors.
	 */
	public List<ValuePoint> getAllPossibleStates(State<T> state) {
		Point point = state.getPosition();
		ValuePoint[][] neighbors = new ValuePoint[3][3];
		List<ValuePoint> neighborsList = new ArrayList<ValuePoint>();
		int xPoint = point.getX();
		int yPoint = point.getY();
		int x, y, i = 0, j = 0;
		int xDistance = -1, yDistance = -1;

		// create neighbors
		for (xDistance = -1; xDistance < 2; xDistance++) {
			x = xPoint + xDistance;
			for (yDistance = -1; yDistance < 2; yDistance++) {
				y = yPoint + yDistance;

				if ((x < 0) || (x > this.size - 1) || (y < 0) || (y > this.size - 1)) {
					neighbors[i][j] = new ValuePoint(x, y, ' ');
					j++;
					continue;
				}

				neighbors[i][j] = new ValuePoint(x, y, this.graph[x][y]);
				j++;
			}
			j = 0;
			i++;

		}

		x = 0;
		y = 0;
		// remove the "water" neighbors
		for (x = 0; x < 3; x++) {
			for (y = 0; y < 3; y++) {
				char character = neighbors[x][y].getValue();
				if (character == 'W') {
					if ((x == 0) && (y == 1)) {
						neighbors[0][0].setValue(' ');
						neighbors[0][2].setValue(' ');
					}
					if ((x == 1) && (y == 0)) {
						neighbors[0][0].setValue(' ');
						neighbors[2][0].setValue(' ');
					}
					if ((x == 2) && (y == 1)) {
						neighbors[2][0].setValue(' ');
						neighbors[2][2].setValue(' ');
					}
					if ((x == 1) && (y == 2)) {
						neighbors[2][2].setValue(' ');
						neighbors[0][2].setValue(' ');
					}
					neighbors[x][y].setValue(' ');
				}
			}

		}

		neighborsList = convertToneighborsList(neighbors);
		return neighborsList;
	}

	/**
	 * The convertToneighborsList function. This function converts the matrix of
	 * neighbors to a list.
	 * 
	 * @param points
	 *            - type ValuePoint[][], the neighbors.
	 * @return - type List<ValuePoint>, the list of neighbors.
	 */
	private List<ValuePoint> convertToneighborsList(ValuePoint[][] points) {
		List<ValuePoint> neighbors = new ArrayList<ValuePoint>();
		addToList(neighbors, points[2][1]);

		for (int i = 2; i >= 0; i--) {
			addToList(neighbors, points[i][2]);
		}

		addToList(neighbors, points[0][1]);

		for (int i = 0; i <= 2; i++) {
			addToList(neighbors, points[i][0]);
		}

		return neighbors;

	}

	/**
	 * The addToList function. This function adds the given point to the given
	 * list.
	 * 
	 * @param list
	 *            - type List<ValuePoint>, the given list.
	 * @param point
	 *            - type ValuePoint, the given point.
	 */
	private void addToList(List<ValuePoint> list, ValuePoint point) {
		if (point.getValue() != ' ') {
			list.add(point);
		}
	}

	@Override
	/**
	 * The getGoalState function. This function returns the size of the
	 * searchable.
	 * 
	 * @return - type int, the size of the searchable.
	 */
	public int getSize() {
		return this.size;
	}

}
