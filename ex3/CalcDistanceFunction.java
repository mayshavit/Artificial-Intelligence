/**
 * The CalcDistanceFunction class.
 * This class implements the CalculatingFunction interface.
 * This class has a calc function that calculates the distance between 2 given
 * nodes.
 */
public class CalcDistanceFunction implements CalculatingFunction<Node> {

	@Override
	/**
	 * 
	 * The calc function.
	 * This function calculates the distance between 2 given nodes.
	 * @param node1 - the first given node.
	 * @param node2 - the second given node.
	 * @return - type double, the calculated distance.
	 */
	public double calc(Node node1, Node node2) {
		return Math.sqrt(Math.pow(node1.getX() - node2.getX(), 2) + 
				Math.pow(node1.getY() - node2.getY(), 2));
	}

}
