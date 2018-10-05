import java.util.List;

/**
 * The SingleLink class.
 * This class implements the CalculatingFunction interface.
 * This class has a calc function that calculates the shortest distance
 * between 2 given clusters - the shortest distance between each node member in
 * the first cluster to each node member in the second cluster.
 */
public class SingleLink implements CalculatingFunction<Cluster<Node>> {

	// members
	private CalcDistanceFunction distanceFunction;

	// constructor
	public SingleLink(CalcDistanceFunction distanceFunction) {
		this.distanceFunction = distanceFunction;
	}

	@Override
	/**
	 * The calc function.
	 * This function calculates the shortest distance between 2 given
	 * clusters - the shortest distance between each node member in the first
	 * cluster to each node member in the second cluster.
	 * @param cluster1, type Cluster<Node>, the first given cluster.
	 * @param cluster2, type Cluster<Node>, the second given cluster.
	 * @return - type double, the calculated distance.
	 */
	public double calc(Cluster<Node> cluster1, Cluster<Node> cluster2) {
		double distance = -1;
		double minDistance = Double.POSITIVE_INFINITY;

		List<Node> clusterList1 = cluster1.getMembersList();
		List<Node> clusterList2 = cluster2.getMembersList();

		for (Node node1 : clusterList1) {
			for (Node node2 : clusterList2) {
				distance = this.distanceFunction.calc(node1, node2);
				if (distance < minDistance) {
					minDistance = distance;
				}
			}
		}

		return minDistance;
	}

}
